package com.example.clientpanel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
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

public class vehicle_info_activity extends Activity {

	private TableLayout bikeDetailsTable;
	private ImageView image_1_ek1;
	private SessionManager sessionManager;
	private String emailAddress;

	private static final String TAG = "VehicleInfoActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vehicle_info);

		bikeDetailsTable = findViewById(R.id.bike_details_table);
		image_1_ek1 = findViewById(R.id.image_1_ek1);
		sessionManager = new SessionManager(this);

		// Retrieve email from SessionManager
		String email = sessionManager.getEmail();
		if (email == null || email.isEmpty()) {
			Log.e(TAG, "Email is null or empty in vehicle_info_activity");
			Toast.makeText(this, R.string.error_null_email, Toast.LENGTH_SHORT).show();
			finish(); // Finish activity if email is not available
			return;
		}

		// Proceed with fetching data using the email as UID
		String emailKey = email.replace(".", ","); // Use email as UID
		DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users")
				.child(emailKey)
				.child("bikes");

		databaseReference.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				int sn = 1;
				bikeDetailsTable.removeAllViews(); // Clear previous rows
				addTableHeader();
				for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
					BikeScooterDetails details = snapshot.getValue(BikeScooterDetails.class);
					if (details != null) {
						addRowToTable(sn++, details);
					}
				}
			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError) {
				Toast.makeText(vehicle_info_activity.this, getString(R.string.error_loading_data, databaseError.getMessage()), Toast.LENGTH_SHORT).show();
				Log.e(TAG, "Error loading data: " + databaseError.getMessage());
			}
		});

		image_1_ek1.setOnClickListener(v -> {
			// Handle click to navigate to another activity
			Intent intent  = new Intent(getApplicationContext(), bike_scooter_details_activity.class);
			intent.putExtra("emailAddress", getIntent().getStringExtra("emailAddress")); // Pass email address


			startActivity(intent);
			finish();

		});
	}

	private void addTableHeader() {
		LayoutInflater inflater = getLayoutInflater();
		TableRow headerRow = (TableRow) inflater.inflate(R.layout.table_row, null);

		TextView snHeader = headerRow.findViewById(R.id.sn);
		TextView bikeDetailsHeader = headerRow.findViewById(R.id.bike_details);

		snHeader.setText(R.string.sn_header); // Use string resources for headers
		bikeDetailsHeader.setText(R.string.bike_details_header);

		bikeDetailsTable.addView(headerRow);
	}

	private void addRowToTable(int sn, BikeScooterDetails details) {
		LayoutInflater inflater = getLayoutInflater();
		TableRow row = (TableRow) inflater.inflate(R.layout.table_row, null);

		TextView snTextView = row.findViewById(R.id.sn);
		TextView bikeDetailsTextView = row.findViewById(R.id.bike_details);

		snTextView.setText(String.valueOf(sn));
		bikeDetailsTextView.setText(getString(R.string.bike_details_text, details.bikeModel, details.numberPlate, details.color));

		bikeDetailsTable.addView(row);
	}

	public static class BikeScooterDetails {
		public String bikeModel;
		public String numberPlate;
		public String color;

		public BikeScooterDetails() {
			// Default constructor required for calls to DataSnapshot.getValue(BikeScooterDetails.class)
		}

		public BikeScooterDetails(String bikeModel, String numberPlate, String color) {
			this.bikeModel = bikeModel;
			this.numberPlate = numberPlate;
			this.color = color;
		}

		public BikeScooterDetails(String bikeModel, String numberPlate) {
			this.bikeModel = bikeModel;
			this.numberPlate = numberPlate;
		}
	}
}
