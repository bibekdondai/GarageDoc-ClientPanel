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
		// Get the selected time from the Intent
		Intent intent = getIntent();
		String selectedTime = intent.getStringExtra("tokenTime");

		if (selectedTime != null) {
			Log.d("details_to_be_filled_activity", "Received time: " + selectedTime);
			// Use selectedTime as needed
		}

		// Get email from SessionManager
		String email = sessionManager.getEmail();

		String bikeModel = intent.getStringExtra("bikeModel");
		String plateNumber = intent.getStringExtra("plateNumber");

		Log.d(TAG, "Email from SessionManager: " + email);
		Log.d(TAG, "Bike Model from Intent: " + bikeModel);
		Log.d(TAG, "Plate Number from Intent: " + plateNumber);
		Log.d(TAG, "token Number from Intent: " + selectedTime);


		if (bikeModel != null && plateNumber != null) {
			// Set bike model and plate number in EditTexts
			txtModel.setText(bikeModel);
			txtVehicleNo.setText(plateNumber);

			// Replace "." with "," in email to match Firebase database structure
			if (email != null) {
				String sanitizedEmail = email.replace(".", ",");
				bikePartsRef = firebaseDatabase.getReference("users")
						.child(sanitizedEmail)
						.child("bikes")
						.child(plateNumber)
						.child("services");

				// Fetch token times first
				fetchTokenTimes();
				fetchBikePartsData(tokenTime);
			} else {
				Log.e(TAG, "Email is null.");
			}
		} else {
			Log.e(TAG, "Bike model or plate number is null.");
		}

		btnAddPartService.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Create an intent to start services_activity
				Intent intent = new Intent(details_to_be_filled_activity.this, services_activity.class);

				// Pass bike model and plate number as extras
				intent.putExtra("bikeModel", txtModel.getText().toString());
				intent.putExtra("plateNumber", txtVehicleNo.getText().toString());

				// Start the activity
				startActivity(intent);
			}
		});
	}

	private void fetchTokenTimes() {
		bikePartsRef.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				boolean tokenTimeFound = false;

				for (DataSnapshot serviceSnapshot : dataSnapshot.getChildren()) {
					tokenTime = serviceSnapshot.child("services").getValue(String.class);

					if (tokenTime != null) {
						tokenTimeFound = true;
						fetchBikePartsData(tokenTime);
						break; // Exit loop if token time is found
					}
				}

				if (!tokenTimeFound) {
					Log.e(TAG, "Token time is null or not found.");
				}
			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError) {
				Log.e(TAG, "Error fetching token times", databaseError.toException());
			}
		});
	}
	private void loadServiceData() {
		String email = sessionManager.getEmail();
		if (email == null || email.isEmpty()) {
			Log.e("DetailsActivity", "Email is null or empty in loadServiceData");
			Toast.makeText(this, R.string.error_null_email, Toast.LENGTH_SHORT).show();
			return;
		}

		String sanitizedEmail = email.replace(".", ","); // Sanitize email
		DatabaseReference servicesRef = FirebaseDatabase.getInstance().getReference("users")
				.child(sanitizedEmail).child("bikes").child(plateNumber).child("services").child(tokenTime);

		servicesRef.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				upperTable.removeAllViews();
				for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
					Map<String, String> serviceData = (Map<String, String>) snapshot.getValue();
					if (serviceData != null) {
						String part = serviceData.get("part");
						String price = serviceData.get("price");
						addDataToTable(part, price);
					}
				}
			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError) {
				Log.e("DetailsActivity", "Failed to load service data", databaseError.toException());
				Toast.makeText(details_to_be_filled_activity.this, "Failed to load service data", Toast.LENGTH_SHORT).show();
			}
		});
	}
	private void addDataToTable(String part, String price) {
		TableRow tableRow = new TableRow(this);

		// Create TextViews for each column
		TextView partTextView = new TextView(this);
		partTextView.setText(part);
		partTextView.setPadding(16, 16, 16, 16);
		partTextView.setGravity(Gravity.CENTER);

		TextView priceTextView = new TextView(this);
		priceTextView.setText(price);
		priceTextView.setPadding(16, 16, 16, 16);
		priceTextView.setGravity(Gravity.CENTER);

		// Add TextViews to TableRow
		tableRow.addView(partTextView);
		tableRow.addView(priceTextView);

		// Add TableRow to TableLayout
		upperTable.addView(tableRow);
	}


	private void fetchBikePartsData(String tokenTime) {
		if (tokenTime == null || tokenTime.isEmpty()) {
			Log.e(TAG, "Token time is null or empty.");
			return;
		}

		// Construct the path using tokenTime
		String email = sessionManager.getEmail().replace(".", ","); // Sanitize email
		DatabaseReference bikePartsRef = firebaseDatabase.getReference("users")
				.child(email)
				.child("bikes")
				.child(plateNumber)
				.child("services")
				.child(tokenTime); // Use tokenTime here

		Log.d(TAG, "Fetching data from: " + bikePartsRef.toString());

		bikePartsRef.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				upperTable.removeAllViews(); // Clear existing rows

				// Check if dataSnapshot has children
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
					// Access individual service items (0, 1, 2, ...)
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

						// Set layout parameters for rows
						TableLayout.LayoutParams rowParams = new TableLayout.LayoutParams(
								ViewGroup.LayoutParams.MATCH_PARENT,
								ViewGroup.LayoutParams.WRAP_CONTENT);
						rowParams.setMargins(0, 1, 0, 1);
						row.setLayoutParams(rowParams);

						// Add row to table
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
	}





	private String generateRandomRemark() {
		String[] remarks = {"N/A"};
		Random random = new Random();
		int index = random.nextInt(remarks.length);
		return remarks[index];
	}
}
