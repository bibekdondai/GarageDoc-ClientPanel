package com.example.clientpanel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.FirebaseApp;

public class bike_scooter_details_activity extends Activity {

	private EditText bikeModelEditText, numberPlateEditText;
	private TextView blackTextView, blueTextView, redTextView, orangeTextView;
	private Button doneButton;
	private String selectedColor;
	private FirebaseUser currentUser;

	private static final String TAG = "BikeScooterDetailsActivity";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bike_scooter_details);

		// Initialize Firebase
		FirebaseApp.initializeApp(this);

		currentUser = FirebaseAuth.getInstance().getCurrentUser();
		if (currentUser == null) {
			Toast.makeText(this, "User not authenticated", Toast.LENGTH_SHORT).show();
			Log.e(TAG, "User not authenticated");
			finish();
			return;
		}

		bikeModelEditText = findViewById(R.id.bike_model);
		numberPlateEditText = findViewById(R.id.number_plate);
		blackTextView = findViewById(R.id.black);
		blueTextView = findViewById(R.id.blue);
		redTextView = findViewById(R.id.red);
		orangeTextView = findViewById(R.id.orange);
		doneButton = findViewById(R.id.done);

		// Add TextWatchers to EditTexts
		bikeModelEditText.addTextChangedListener(textWatcher);
		numberPlateEditText.addTextChangedListener(textWatcher);

		// Add click listeners to color TextViews
		blackTextView.setOnClickListener(colorClickListener);
		blueTextView.setOnClickListener(colorClickListener);
		redTextView.setOnClickListener(colorClickListener);
		orangeTextView.setOnClickListener(colorClickListener);

		// Add click listener to Done button
		doneButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				checkForDuplicateAndSave();
			}
		});

		// Your existing code for imageView click listeners
		findViewById(R.id._vector_ek54).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			}
		});

		findViewById(R.id._vector_ek56).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			}
		});

		findViewById(R.id._vector_ek57).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			}
		});
	}

	private TextWatcher textWatcher = new TextWatcher() {
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			validateInputs();
		}

		@Override
		public void afterTextChanged(Editable s) {
		}
	};

	private View.OnClickListener colorClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			selectedColor = ((TextView) v).getText().toString();
			validateInputs();
		}
	};

	private void validateInputs() {
		String bikeModel = bikeModelEditText.getText().toString().trim();
		String numberPlate = numberPlateEditText.getText().toString().trim();
		doneButton.setEnabled(!bikeModel.isEmpty() && !numberPlate.isEmpty() && selectedColor != null);
	}

	private void checkForDuplicateAndSave() {
		String bikeModel = bikeModelEditText.getText().toString().trim();
		String numberPlate = numberPlateEditText.getText().toString().trim();

		if (currentUser != null) {
			String uid = currentUser.getUid(); // Use UID as user identifier

			DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("client_side")
					.child(uid)
					.child("bike_details");

			Query query = databaseReference.orderByChild("numberPlate").equalTo(numberPlate);
			query.addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot dataSnapshot) {
					boolean duplicateFound = false;
					for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
						BikeScooterDetails existingDetails = snapshot.getValue(BikeScooterDetails.class);
						if (existingDetails != null && existingDetails.bikeModel.equals(bikeModel)) {
							duplicateFound = true;
							break;
						}
					}

					if (duplicateFound) {
						Toast.makeText(bike_scooter_details_activity.this, "Bike details already exist!", Toast.LENGTH_SHORT).show();
						Log.e(TAG, "Bike details already exist");
					} else {
						saveDataToFirebase(uid, bikeModel, numberPlate, selectedColor);
					}
				}

				@Override
				public void onCancelled(DatabaseError databaseError) {
					Toast.makeText(bike_scooter_details_activity.this, "Error checking for duplicates", Toast.LENGTH_SHORT).show();
					Log.e(TAG, "Error checking for duplicates: " + databaseError.getMessage());
				}
			});
		} else {
			Toast.makeText(this, "User not authenticated", Toast.LENGTH_SHORT).show();
			Log.e(TAG, "User not authenticated");
		}
	}

	private void saveDataToFirebase(String uid, String bikeModel, String numberPlate, String color) {
		DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("client_side")
				.child(uid)
				.child("bike_details");

		String id = databaseReference.push().getKey();
		BikeScooterDetails details = new BikeScooterDetails(bikeModel, numberPlate, color);

		databaseReference.child(id).setValue(details)
				.addOnSuccessListener(aVoid -> {
					Toast.makeText(bike_scooter_details_activity.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
					Log.d(TAG, "Data saved successfully");
					Intent intent = new Intent(bike_scooter_details_activity.this, vehicle_info_activity.class);
					startActivity(intent);
					finish(); // Optional: Finish current activity after saving
				})
				.addOnFailureListener(e -> {
					Toast.makeText(bike_scooter_details_activity.this, "Failed to save data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
					Log.e(TAG, "Failed to save data: " + e.getMessage());
				});
	}

	public static class BikeScooterDetails {
		public String bikeModel;
		public String numberPlate;
		public String color;

		public BikeScooterDetails() {
		}

		public BikeScooterDetails(String bikeModel, String numberPlate, String color) {
			this.bikeModel = bikeModel;
			this.numberPlate = numberPlate;
			this.color = color;
		}
	}
}
