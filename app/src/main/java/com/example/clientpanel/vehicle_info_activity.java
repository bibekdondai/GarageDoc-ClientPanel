package com.example.clientpanel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

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


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vehicle_info);

		bikeDetailsTable = findViewById(R.id.bike_details_table);
		image_1_ek1 = findViewById(R.id.image_1_ek1);

		if (image_1_ek1 != null) {
			image_1_ek1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent nextScreen = new Intent(getApplicationContext(), bike_scooter_details_activity.class);
					startActivity(nextScreen);


				}
			});
		}

//		image_1_ek1.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				Intent nextScreen = new Intent(getApplicationContext(), bike_scooter_details_activity.class);
//				startActivity(nextScreen);
//
//
//			}
//		});

//		FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//		if (user == null) {
//			Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show();
//			return;
//		}
//		String uid = user.getUid();

//		DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("client_side").child("bike_details");
//
//		databaseReference.addValueEventListener(new ValueEventListener() {
//			@Override
//			public void onDataChange(DataSnapshot dataSnapshot) {
//				int sn = 1;
//				bikeDetailsTable.removeAllViews(); // Clear previous rows
//				addTableHeader();
//				for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//					BikeScooterDetails details = snapshot.getValue(BikeScooterDetails.class);
//					if (details != null) {
//						addRowToTable(sn++, details);
//					}
//				}
//			}
//
//			@Override
//			public void onCancelled(DatabaseError databaseError) {
//				Toast.makeText(vehicle_info_activity.this, "Error loading data", Toast.LENGTH_SHORT).show();
//			}
//		});
//	}
//
//	private void addTableHeader() {
//		LayoutInflater inflater = getLayoutInflater();
//		TableRow headerRow = (TableRow) inflater.inflate(R.layout.table_row, null);
//
//		TextView snHeader = headerRow.findViewById(R.id.sn);
//		TextView bikeDetailsHeader = headerRow.findViewById(R.id.bike_details);
//
//		snHeader.setText("SN");
//		bikeDetailsHeader.setText("Bike Details");
//
//		bikeDetailsTable.addView(headerRow);
//	}
//
//	private void addRowToTable(int sn, BikeScooterDetails details) {
//		LayoutInflater inflater = getLayoutInflater();
//		TableRow row = (TableRow) inflater.inflate(R.layout.table_row, null);
//
//		TextView snTextView = row.findViewById(R.id.sn);
//		TextView bikeDetailsTextView = row.findViewById(R.id.bike_details);
//
//		snTextView.setText(String.valueOf(sn));
//		bikeDetailsTextView.setText("Model: " + details.bikeModel + ", Plate: " + details.numberPlate + ", Color: " + details.color);
//
//		bikeDetailsTable.addView(row);
//	}
//
//	public static class BikeScooterDetails {
//		public String bikeModel;
//		public String numberPlate;
//		public String color;
//
//		public BikeScooterDetails() {
//			// Default constructor required for calls to DataSnapshot.getValue(BikeScooterDetails.class)
//		}
//
//		public BikeScooterDetails(String bikeModel, String numberPlate, String color) {
//			this.bikeModel = bikeModel;
//			this.numberPlate = numberPlate;
//			this.color = color;
//		}
	}
}
