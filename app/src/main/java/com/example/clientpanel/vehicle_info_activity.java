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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class vehicle_info_activity extends Activity {

	private TableLayout bikeDetailsTable;
	private ImageView image_1_ek1;
	private FirebaseUser currentUser;

	private static final String TAG = "VehicleInfoActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vehicle_info);

		bikeDetailsTable = findViewById(R.id.bike_details_table);
		image_1_ek1 = findViewById(R.id.image_1_ek1);

		// Retrieve current user from Firebase authentication session
		currentUser = FirebaseAuth.getInstance().getCurrentUser();
		if (currentUser == null) {
			// If somehow currentUser is null, handle it gracefully
			Log.e(TAG, "Current user is null in vehicle_info_activity");
			Toast.makeText(this, "Error: Current user is null", Toast.LENGTH_SHORT).show();
			finish(); // Finish activity if user is not authenticated
			return;
		}

		// Proceed with fetching data using the authenticated user's UID
		String uid = currentUser.getUid();
		DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users")
				.child(uid)
				.child("bike_details");

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
				Toast.makeText(vehicle_info_activity.this, "Error loading data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
				Log.e(TAG, "Error loading data: " + databaseError.getMessage());
			}
		});

		image_1_ek1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Handle click to navigate to another activity
				Intent nextScreen = new Intent(getApplicationContext(), bike_scooter_details_activity.class);
				startActivity(nextScreen);
			}
		});
	}

	private void addTableHeader() {
		LayoutInflater inflater = getLayoutInflater();
		TableRow headerRow = (TableRow) inflater.inflate(R.layout.table_row, null);

		TextView snHeader = headerRow.findViewById(R.id.sn);
		TextView bikeDetailsHeader = headerRow.findViewById(R.id.bike_details);

		snHeader.setText("SN");
		bikeDetailsHeader.setText("Bike Details");

		bikeDetailsTable.addView(headerRow);
	}

	private void addRowToTable(int sn, BikeScooterDetails details) {
		LayoutInflater inflater = getLayoutInflater();
		TableRow row = (TableRow) inflater.inflate(R.layout.table_row, null);

		TextView snTextView = row.findViewById(R.id.sn);
		TextView bikeDetailsTextView = row.findViewById(R.id.bike_details);

		snTextView.setText(String.valueOf(sn));
		bikeDetailsTextView.setText("Model: " + details.bikeModel + ", Plate: " + details.numberPlate + ", Color: " + details.color);

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
	}
}
