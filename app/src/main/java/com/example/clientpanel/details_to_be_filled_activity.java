package com.example.clientpanel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;
import java.util.Random;

public class details_to_be_filled_activity extends Activity {

	private static final String TAG = "DetailsToBeFilledActivity";

	private TableLayout upperTable;
	private EditText txtModel;
	private EditText txtVehicleNo;
	private FirebaseDatabase firebaseDatabase;
	private DatabaseReference bikePartsRef;
	private SessionManager sessionManager;
	private Button btnAddPartService;
	private String tokenTime;
	private String plateNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details_to_be_filled);

		// Initialize Firebase and SessionManager
		txtModel = findViewById(R.id.txt_model);
		txtVehicleNo = findViewById(R.id.txt_vehicleno);
		upperTable = findViewById(R.id.upper_table);
		firebaseDatabase = FirebaseDatabase.getInstance();
		btnAddPartService = findViewById(R.id.btn_add_part_service);
		sessionManager = new SessionManager(this);

		// Get data from the Intent
		Intent intent = getIntent();
		if (intent != null) {
			String bikeModel = intent.getStringExtra("bikeModel");
			plateNumber = intent.getStringExtra("plateNumber");
			tokenTime = intent.getStringExtra("tokenTime");

			if (bikeModel != null && plateNumber != null && tokenTime != null) {
				txtModel.setText(bikeModel);
				txtVehicleNo.setText(plateNumber);

				String email = sessionManager.getEmail();
				if (email != null && !email.isEmpty()) {
					String sanitizedEmail = email.replace(".", ",");
					bikePartsRef = firebaseDatabase.getReference("users")
							.child(sanitizedEmail)
							.child("bikes")
							.child(plateNumber)
							.child("services");

					// Fetch and load service data
					fetchBikePartsData(tokenTime);
				} else {
					Log.e(TAG, "Email is null or empty.");
					Toast.makeText(this, "Email is not available.", Toast.LENGTH_SHORT).show();
				}
			} else {
				Log.e(TAG, "Bike model, plate number, or token time is null.");
				Toast.makeText(this, "Required data is missing.", Toast.LENGTH_SHORT).show();
			}
		} else {
			Log.e(TAG, "Intent is null.");
			Toast.makeText(this, "No data received.", Toast.LENGTH_SHORT).show();
		}

		btnAddPartService.setOnClickListener(v -> {
			Intent serviceIntent = new Intent(details_to_be_filled_activity.this, services_activity.class);
			serviceIntent.putExtra("bikeModel", txtModel.getText().toString());
			serviceIntent.putExtra("plateNumber", txtVehicleNo.getText().toString());
			startActivity(serviceIntent);
		});
	}

	private void fetchBikePartsData(String tokenTime) {
		if (tokenTime == null || tokenTime.isEmpty()) {
			Log.e(TAG, "Token time is null or empty.");
			return;
		}

		String email = sessionManager.getEmail();
		if (email != null && !email.isEmpty()) {
			String sanitizedEmail = email.replace(".", ",");
			DatabaseReference bikePartsRef = firebaseDatabase.getReference("users")
					.child(sanitizedEmail)
					.child("bikes")
					.child(plateNumber)
					.child("services")
					.child(tokenTime);

			Log.d(TAG, "Fetching data from: " + bikePartsRef.toString());

			bikePartsRef.addValueEventListener(new ValueEventListener() {
				@Override
				public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
					upperTable.removeAllViews();

					if (!dataSnapshot.exists() || !dataSnapshot.hasChildren()) {
						Log.w(TAG, "No data available at path.");
						Toast.makeText(details_to_be_filled_activity.this, "No service data available.", Toast.LENGTH_SHORT).show();
						return;
					}

					// Add header row
					TableRow headerRow = new TableRow(details_to_be_filled_activity.this);
					String[] headers = {"Part", "Price", "Remarks"};
					for (String header : headers) {
						TextView headerTextView = new TextView(details_to_be_filled_activity.this);
						headerTextView.setText(header);
						headerTextView.setPadding(16, 8, 16, 8);
						headerTextView.setTextColor(getResources().getColor(android.R.color.white));
						headerTextView.setBackgroundColor(getResources().getColor(android.R.color.black));
						headerTextView.setGravity(Gravity.CENTER);
						headerTextView.setLayoutParams(new TableRow.LayoutParams(
								0, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
						headerRow.addView(headerTextView);
					}
					upperTable.addView(headerRow);

					// Add data rows
					for (DataSnapshot partSnapshot : dataSnapshot.getChildren()) {
						String partName = partSnapshot.child("part").getValue(String.class);
						String partPrice = partSnapshot.child("price").getValue(String.class);
						String remarks = partSnapshot.child("remarks").getValue(String.class);

						Log.d(TAG, "Fetched data: Part = " + partName + ", Price = " + partPrice + ", Remarks = " + remarks);

						if (partName != null && partPrice != null) {
							TableRow row = new TableRow(details_to_be_filled_activity.this);

							TextView partNameTextView = new TextView(details_to_be_filled_activity.this);
							partNameTextView.setText(partName);
							partNameTextView.setPadding(16, 8, 16, 8);
							partNameTextView.setGravity(Gravity.CENTER);
							partNameTextView.setLayoutParams(new TableRow.LayoutParams(
									0, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));

							TextView priceTextView = new TextView(details_to_be_filled_activity.this);
							priceTextView.setText(partPrice);
							priceTextView.setPadding(16, 8, 16, 8);
							priceTextView.setGravity(Gravity.CENTER);
							priceTextView.setLayoutParams(new TableRow.LayoutParams(
									0, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));

							TextView remarksTextView = new TextView(details_to_be_filled_activity.this);
							remarksTextView.setText(remarks != null ? remarks : generateRandomRemark());
							remarksTextView.setPadding(16, 8, 16, 8);
							remarksTextView.setGravity(Gravity.CENTER);
							remarksTextView.setLayoutParams(new TableRow.LayoutParams(
									0, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));

							row.addView(partNameTextView);
							row.addView(priceTextView);
							row.addView(remarksTextView);

							TableLayout.LayoutParams rowParams = new TableLayout.LayoutParams(
									ViewGroup.LayoutParams.MATCH_PARENT,
									ViewGroup.LayoutParams.WRAP_CONTENT);
							rowParams.setMargins(0, 1, 0, 1);
							row.setLayoutParams(rowParams);

							upperTable.addView(row);
						} else {
							Log.w(TAG, "Part or price is null.");
						}
					}
				}

				@Override
				public void onCancelled(@NonNull DatabaseError databaseError) {
					Log.e(TAG, "Error fetching bike parts data", databaseError.toException());
				}
			});
		} else {
			Log.e(TAG, "Email is null or empty.");
		}
	}

	private String generateRandomRemark() {
		String[] remarks = {"N/A"};
		Random random = new Random();
		int index = random.nextInt(remarks.length);
		return remarks[index];
	}
}
