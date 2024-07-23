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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class details_to_be_filled_activity extends Activity {

	private static final String TAG = "DetailsToBeFilledActivity";

	private TableLayout upperTable;
	private EditText txtModel;
	private EditText txtVehicleNo;
	private TextView txtTokenTime; // Add TextView for token time
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

		initializeComponents();
		retrieveIntentData();
		setupFirebase();
		setupButtonListeners();
	}

	private void initializeComponents() {
		txtModel = findViewById(R.id.txt_model);
		txtVehicleNo = findViewById(R.id.txt_vehicleno);
		upperTable = findViewById(R.id.upper_table);
		txtTokenTime = findViewById(R.id.txt_token_time); // Initialize token time TextView
		btnAddPartService = findViewById(R.id.btn_add_part_service);
		sessionManager = new SessionManager(this);
		firebaseDatabase = FirebaseDatabase.getInstance();
	}

	private void retrieveIntentData() {
		Intent intent = getIntent();
		if (intent != null) {
			String bikeModel = intent.getStringExtra("bikeModel");
			plateNumber = intent.getStringExtra("plateNumber");
			tokenTime = intent.getStringExtra("tokenTime");

			if (bikeModel != null && plateNumber != null && tokenTime != null) {
				txtModel.setText(bikeModel);
				txtVehicleNo.setText(plateNumber);
				// Format and set token time
				txtTokenTime.setText("Token Time: " + formatTokenTime(tokenTime));
			} else {
				showToast("Required data is missing.");
			}
		} else {
			showToast("No data received.");
		}
	}

	private void setupFirebase() {
		String email = sessionManager.getEmail();
		if (email != null && !email.isEmpty()) {
			String sanitizedEmail = email.replace(".", ",");
			bikePartsRef = firebaseDatabase.getReference("users")
					.child(sanitizedEmail)
					.child("bikes")
					.child(plateNumber)
					.child("services");
			fetchBikePartsData(tokenTime);
		} else {
			showToast("Email is not available.");
		}
	}

	private void setupButtonListeners() {
		btnAddPartService.setOnClickListener(v -> {
			Intent serviceIntent = new Intent(details_to_be_filled_activity.this, services_activity.class);
			serviceIntent.putExtra("bikeModel", txtModel.getText().toString());
			serviceIntent.putExtra("plateNumber", txtVehicleNo.getText().toString());
			startActivity(serviceIntent);
		});
	}

	private void fetchBikePartsData(String tokenTime) {
		if (tokenTime == null || tokenTime.isEmpty()) {
			showToast("Token time is invalid.");
			return;
		}

		bikePartsRef.child(tokenTime).addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				updateTableLayout(dataSnapshot);
			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError) {
				Log.e(TAG, "Error fetching bike parts data", databaseError.toException());
			}
		});
	}

	private void updateTableLayout(DataSnapshot dataSnapshot) {
		upperTable.removeAllViews();

		if (!dataSnapshot.exists() || !dataSnapshot.hasChildren()) {
			showToast("No service data available.");
			return;
		}

		// Add header row
		TableRow headerRow = new TableRow(this);
		String[] headers = {"Part", "Price", "Remarks"};
		for (String header : headers) {
			TextView headerTextView = createTextView(header, true);
			headerRow.addView(headerTextView);
		}
		upperTable.addView(headerRow);

		// Add data rows
		for (DataSnapshot partSnapshot : dataSnapshot.getChildren()) {
			String partName = partSnapshot.child("part").getValue(String.class);
			String partPrice = partSnapshot.child("price").getValue(String.class);
			String remarks = partSnapshot.child("remarks").getValue(String.class);

			if (partName != null && partPrice != null) {
				TableRow row = new TableRow(this);
				row.addView(createTextView(partName, false));
				row.addView(createTextView(partPrice, false));
				row.addView(createTextView(remarks != null ? remarks : generateRandomRemark(), false));
				upperTable.addView(row);
			}
		}
	}

	private TextView createTextView(String text, boolean isHeader) {
		TextView textView = new TextView(this);
		textView.setText(text);
		textView.setPadding(16, 8, 16, 8);
		textView.setGravity(Gravity.CENTER);
		if (isHeader) {
			textView.setTextColor(getResources().getColor(android.R.color.white));
			textView.setBackgroundColor(getResources().getColor(android.R.color.black));
		}
		return textView;
	}

	private String generateRandomRemark() {
		String[] remarks = {"N/A"};
		Random random = new Random();
		int index = random.nextInt(remarks.length);
		return remarks[index];
	}

	private String formatTokenTime(String tokenTime) {
		try {
			// Assuming tokenTime is in the format "yyyy-MM-dd HH:mm:ss"
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
			SimpleDateFormat outputFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm a", Locale.getDefault());
			Date date = inputFormat.parse(tokenTime);
			return outputFormat.format(date);
		} catch (Exception e) {
			Log.e(TAG, "Error formatting token time", e);
			return tokenTime; // Return the original tokenTime if formatting fails
		}
	}

	private void showToast(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}
}
