package com.example.clientpanel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class bike_scooter_details_activity extends Activity {

	private Spinner bikeModelSpinner;
	private EditText plateNumberEditText;
	private Button doneButton;
	private String emailAddress;
	private SessionManager sessionManager;
	private static final String TAG = "bikescooterdetails";

	private List<String> bikeModels = new ArrayList<>();
	private String selectedBikeModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bike_scooter_details);

		// Initialize views
		bikeModelSpinner = findViewById(R.id.bikeModelEditText);
		plateNumberEditText = findViewById(R.id.plateNumberEditText);
		doneButton = findViewById(R.id.done);
		sessionManager = new SessionManager(this);

		// Get email from session manager
		emailAddress = sessionManager.getEmail();

		// Log the email address received
		Log.d("EmailPassing", "Email received in bike_scooter_details_activity: " + emailAddress);

		// Check if email is valid
		if (emailAddress == null || emailAddress.isEmpty()) {
			Log.e(TAG, "Email is null or empty in bikescooterdetails");
			Toast.makeText(this, R.string.error_null_email, Toast.LENGTH_SHORT).show();
			finish(); // Finish activity if email is not available
			return;
		}

		// Load bike models from Firestore
		loadBikeModels();

		// Spinner item selection listener
		bikeModelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				selectedBikeModel = bikeModels.get(position);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				selectedBikeModel = null;
			}
		});

		// Button click listener
		doneButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				addBikeDetails();
			}
		});
	}

	private void loadBikeModels() {
		FirebaseFirestore db = FirebaseFirestore.getInstance();
		db.collection("bikeModels")
				.get()
				.addOnCompleteListener(task -> {
					if (task.isSuccessful()) {
						bikeModels.clear();
						for (QueryDocumentSnapshot document : task.getResult()) {
							bikeModels.add(document.getId());
						}
						setupBikeModelSpinner();
					} else {
						Log.w(TAG, "Error getting bike models.", task.getException());
					}
				});
	}

	private void setupBikeModelSpinner() {
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bikeModels);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bikeModelSpinner.setAdapter(adapter);
	}

	private void addBikeDetails() {
		String plateNumber = plateNumberEditText.getText().toString().trim();

		if (selectedBikeModel == null || plateNumber.isEmpty()) {
			Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
			return;
		}

		// Save bike details to Firebase
		saveBikeDetailsToDatabase(selectedBikeModel, plateNumber);
	}

	private void saveBikeDetailsToDatabase(String bikeModel, String plateNumber) {
		String formattedEmail = emailAddress.replace(".", ",");
		DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(formattedEmail);
		DatabaseReference userBikesRef = userRef.child("bikes").child(plateNumber);

		// Create a bike object to store bike details
		Bike bike = new Bike(bikeModel, plateNumber);

		// Save bike details under the user's node
		userBikesRef.setValue(bike).addOnCompleteListener(task -> {
			if (task.isSuccessful()) {
				Toast.makeText(bike_scooter_details_activity.this, "Bike details added successfully", Toast.LENGTH_SHORT).show();
				navigateToVehicleInfo();
			} else {
				Toast.makeText(bike_scooter_details_activity.this, "Failed to add bike details", Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void navigateToVehicleInfo() {
		Intent intent = new Intent(bike_scooter_details_activity.this, vehicle_info_activity.class);
		intent.putExtra("emailAddress", emailAddress); // Use "emailAddress" to match retrieval in vehicle_info_activity
		startActivity(intent);
		finish(); // Optional: Close current activity
	}

	// Inner class for Bike details
	static class Bike {
		public String bikeModel, plateNumber;

		public Bike(String bikeModel, String plateNumber) {
			this.bikeModel = bikeModel;
			this.plateNumber = plateNumber;
		}
	}
}
