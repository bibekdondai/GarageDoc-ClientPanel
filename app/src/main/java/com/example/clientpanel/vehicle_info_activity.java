package com.example.clientpanel;

import android.annotation.SuppressLint;
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
		emailAddress = sessionManager.getEmail();
		if (emailAddress == null || emailAddress.isEmpty()) {
			Log.e(TAG, "Email is null or empty in vehicle_info_activity");
			Toast.makeText(this, R.string.error_null_email, Toast.LENGTH_SHORT).show();
			finish(); // Finish activity if email is not available
			return;
		}

		// Proceed with fetching data using the email as UID
		String emailKey = emailAddress.replace(".", ","); // Use email as UID
		DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users")
				.child(emailKey)
				.child("bikes");

		databaseReference.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				int sn = 1;
				bikeDetailsTable.removeAllViews(); // Clear previous rows
				addTableHeader();

				for (DataSnapshot bikeSnapshot : dataSnapshot.getChildren()) {
					String bikeModel = bikeSnapshot.child("bikeModel").getValue(String.class);
					String numberPlate = bikeSnapshot.getKey(); // Assuming number plate is the key

					if (bikeModel != null && numberPlate != null) {
						BikeScooterDetails details = new BikeScooterDetails(bikeModel, numberPlate);
						addRowToTable(sn++, details);
					} else {
						Log.e(TAG, "Bike details are incomplete for key: " + bikeSnapshot.getKey());
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
			intent.putExtra("emailAddress", emailAddress); // Pass email address

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

	@SuppressLint("StringFormatMatches")
	private void addRowToTable(int sn, BikeScooterDetails details) {
		LayoutInflater inflater = getLayoutInflater();
		TableRow row = (TableRow) inflater.inflate(R.layout.table_row, null);

		TextView snTextView = row.findViewById(R.id.sn);
		TextView bikeDetailsTextView = row.findViewById(R.id.bike_details);

		snTextView.setText(String.valueOf(sn));
		bikeDetailsTextView.setText(getString(R.string.bike_details_text, details.bikeModel, details.numberPlate));

		// Set onClickListener for the row
		row.setOnClickListener(v -> {
			if (emailAddress == null || emailAddress.isEmpty()) {
				Log.e(TAG, "Email address is null or empty");
				Toast.makeText(vehicle_info_activity.this, "Failed to load details. Email is missing.", Toast.LENGTH_SHORT).show();
				return;
			}

			String formattedEmail = emailAddress.replace(".", ",");
			DatabaseReference tokenRef = FirebaseDatabase.getInstance().getReference("users")
					.child(formattedEmail)
					.child("bikes")
					.child(details.numberPlate)
					.child("services");

			tokenRef.addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
					for (DataSnapshot serviceSnapshot : dataSnapshot.getChildren()) {
						String tokenTime = serviceSnapshot.child("token_time").getValue(String.class);
						String tokenDate = serviceSnapshot.child("token_date").getValue(String.class);

						// Create a list to store part details
						StringBuilder partsDetails = new StringBuilder();
						for (DataSnapshot partSnapshot : serviceSnapshot.getChildren()) {
							if (partSnapshot.getKey().matches("\\d+")) { // Check if it's a part entry
								String partName = partSnapshot.child("part").getValue(String.class);
								String partPrice = partSnapshot.child("price").getValue(String.class);
								if (partName != null && partPrice != null) {
									partsDetails.append(partName).append(" - ").append(partPrice).append("\n");
								}
							}
						}

						Intent intent = new Intent(vehicle_info_activity.this, details_to_be_filled_activity.class);
						intent.putExtra("bikeModel", details.bikeModel);
						intent.putExtra("plateNumber", details.numberPlate);
						intent.putExtra("tokenTime", tokenTime);
						intent.putExtra("tokenDate", tokenDate);
						intent.putExtra("partsDetails", partsDetails.toString());
						startActivity(intent);
						return; // Stop after first token (assuming only one token per day per bike)
					}
				}

				@Override
				public void onCancelled(@NonNull DatabaseError databaseError) {
					Toast.makeText(vehicle_info_activity.this, "Failed to load token details.", Toast.LENGTH_SHORT).show();
				}
			});
		});

		bikeDetailsTable.addView(row);
	}

	public static class BikeScooterDetails {
		public String bikeModel;
		public String numberPlate;

		public BikeScooterDetails() {
			// Default constructor required for calls to DataSnapshot.getValue(BikeScooterDetails.class)
		}

		public BikeScooterDetails(String bikeModel, String numberPlate) {
			this.bikeModel = bikeModel;
			this.numberPlate = numberPlate;
		}
	}
}
