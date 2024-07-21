package com.example.clientpanel;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class services_activity extends AppCompatActivity {

	private Spinner spinner1, spinner3;
	private String tokenTime; // Declare tokenTime here

	private Button submitButton;
	private Button addButton;
	private TableLayout tableLayout;
	private FirebaseDatabase firebaseDatabase;
	private DatabaseReference usersRef;
	private FirebaseFirestore firestore;
	private List<String> bikeModels;
	private List<String> bikeParts1;
	private Map<String, String> partPrices1; // Map to hold part names and their prices
	private SessionManager sessionManager;
	private static final String TAG = "ServicesActivity";
	private String bikeModel; // Define this variable
	private String plateNumber; // Define this variable

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.services);

		spinner1 = findViewById(R.id.spinner);
		spinner3 = findViewById(R.id.spinner3);
		submitButton = findViewById(R.id.submit);
		addButton = findViewById(R.id.addbtn);
		tableLayout = findViewById(R.id.table);
		sessionManager = new SessionManager(this);

		firebaseDatabase = FirebaseDatabase.getInstance();
		usersRef = firebaseDatabase.getReference("users");
		firestore = FirebaseFirestore.getInstance();

		bikeModels = new ArrayList<>();
		bikeParts1 = new ArrayList<>();
		partPrices1 = new HashMap<>();

		setupSpinners();
		setupAddButton();
		setupSubmitButton();
	}

	private void setupSpinners() {
		// Setup spinner3 with bike models
		ArrayAdapter<String> modelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bikeModels);
		modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner3.setAdapter(modelAdapter);

		// Setup spinner1 with bike parts
		ArrayAdapter<String> partsAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bikeParts1);
		partsAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(partsAdapter1);

		// Load bike models into spinner3
		loadBikeModels();

		// Spinner3 item selection listener
		spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String selectedBikeModel = bikeModels.size() > position ? bikeModels.get(position) : null;
				if (selectedBikeModel != null) {
					bikeModel = selectedBikeModel; // Set bikeModel
					loadBikePartsFromFirestore(selectedBikeModel);
					loadPlateNumberForBikeModel(selectedBikeModel); // Load plate number
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// Handle if needed
			}
		});
	}

	private void loadBikeModels() {
		String email = sessionManager.getEmail();
		if (email == null || email.isEmpty()) {
			Log.e(TAG, "Email is null or empty in services_activity");
			Toast.makeText(this, R.string.error_null_email, Toast.LENGTH_SHORT).show();
			return;
		}

		String sanitizedEmail = email.replace(".", ","); // Sanitize email
		DatabaseReference userBikesRef = usersRef.child(sanitizedEmail).child("bikes");

		userBikesRef.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				bikeModels.clear();
				for (DataSnapshot bikeSnapshot : dataSnapshot.getChildren()) {
					String plateNumber = bikeSnapshot.getKey(); // Get plateNumber as key
					DataSnapshot bikeData = bikeSnapshot.child("bikeModel");
					String bikeModel = bikeData.getValue(String.class); // Get bikeModel value
					if (bikeModel != null) {
						bikeModels.add(bikeModel);
					} else {
						Log.w(TAG, "Bike model is null for plateNumber: " + plateNumber);
					}
				}
				((ArrayAdapter<String>) spinner3.getAdapter()).notifyDataSetChanged();
			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError) {
				Toast.makeText(services_activity.this, "Failed to load bike models", Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void loadBikePartsFromFirestore(String bikeModel) {
		firestore.collection("bikeModels")
				.document(bikeModel)
				.collection("bikeParts")
				.get()
				.addOnCompleteListener(task -> {
					if (task.isSuccessful()) {
						bikeParts1.clear();
						partPrices1.clear();

						QuerySnapshot querySnapshot = task.getResult();
						if (querySnapshot != null) {
							for (QueryDocumentSnapshot document : querySnapshot) {
								String partName = document.getString("part");
								Object priceObject = document.get("price");

								String price = null;
								if (priceObject instanceof String) {
									price = (String) priceObject;
								} else if (priceObject instanceof Number) {
									price = String.valueOf(((Number) priceObject).doubleValue());
								}

								if (partName != null && price != null) {
									bikeParts1.add(partName);
									partPrices1.put(partName, price);
								} else {
									Log.w(TAG, "Part name or price is null");
								}
							}
						}
						((ArrayAdapter<String>) spinner1.getAdapter()).notifyDataSetChanged();
					} else {
						Log.e(TAG, "Error getting bike parts", task.getException());
						Toast.makeText(services_activity.this, "Failed to load bike parts", Toast.LENGTH_SHORT).show();
					}
				});
	}

	private void setupAddButton() {
		addButton.setOnClickListener(v -> {
			String selectedPart = spinner1.getSelectedItem() != null ? spinner1.getSelectedItem().toString() : "";
			String selectedModel = spinner3.getSelectedItem() != null ? spinner3.getSelectedItem().toString() : "";

			if (selectedPart.isEmpty() || selectedModel.isEmpty()) {
				Toast.makeText(services_activity.this, "Please select all fields", Toast.LENGTH_SHORT).show();
				return;
			}

			// Add data to table
			addDataToTable(selectedPart, partPrices1.get(selectedPart));
		});
	}

	private void addDataToTable(String part1, String price) {
		TableRow tableRow = new TableRow(this);

		// Create TextViews for each column
		TextView partTextView = new TextView(this);
		partTextView.setText(part1);
		partTextView.setPadding(16, 16, 16, 16);
		partTextView.setGravity(Gravity.CENTER);

		TextView priceTextView = new TextView(this);
		priceTextView.setText(price);
		priceTextView.setPadding(16, 16, 16, 16);
		priceTextView.setGravity(Gravity.CENTER);

		// Create a cancel button to remove the row
		Button cancelButton = new Button(this);
		cancelButton.setText("Remove");
		cancelButton.setOnClickListener(v -> tableLayout.removeView(tableRow));

		// Add TextViews and cancel button to TableRow
		tableRow.addView(partTextView);
		tableRow.addView(priceTextView);
		tableRow.addView(cancelButton);

		// Add TableRow to TableLayout
		tableLayout.addView(tableRow);
	}

	private void setupSubmitButton() {
		submitButton.setOnClickListener(v -> {
			List<Map<String, String>> tableData = new ArrayList<>();
			boolean hasEmptyFields = false; // Flag to check if any fields are empty

			for (int i = 0; i < tableLayout.getChildCount(); i++) {
				View child = tableLayout.getChildAt(i);
				if (child instanceof TableRow) {
					TableRow tableRow = (TableRow) child;
					if (tableRow.getChildCount() >= 3) {
						TextView partTextView = (TextView) tableRow.getChildAt(0);
						TextView priceTextView = (TextView) tableRow.getChildAt(1);
						String partName = partTextView.getText().toString();
						String price = priceTextView.getText().toString();

						// Check if any part or price field is empty
						if (partName.isEmpty() || price.isEmpty()) {
							hasEmptyFields = true;
							break; // Break out of the loop if an empty field is found
						}

						Map<String, String> rowData = new HashMap<>();
						rowData.put("part", partName);
						rowData.put("price", price);
						tableData.add(rowData);
					}
				}
			}

			if (tableData.isEmpty() || hasEmptyFields) {
				Toast.makeText(services_activity.this, "Please add valid parts and prices before submitting", Toast.LENGTH_SHORT).show();
			} else {
				showTimePickerDialog(tableData);
			}
		});
	}

	private void showTimePickerDialog(List<Map<String, String>> tableData) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		LayoutInflater inflater = getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.dialog_token_time, null);
		builder.setView(dialogView);

		TimePicker timePicker = dialogView.findViewById(R.id.timePicker);
		timePicker.setIs24HourView(true);

		builder.setPositiveButton("OK", (dialog, which) -> {
			int hour = timePicker.getCurrentHour();
			int minute = timePicker.getCurrentMinute();
			tokenTime = String.format("%02d:%02d", hour, minute);
			Log.d(TAG, "Token Time selected: " + tokenTime);

			// Save data to Firebase
			saveDataToFirebase(tableData, tokenTime);
		});

		builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

		AlertDialog dialog = builder.create();
		dialog.show();
	}

	private void saveDataToFirebase(List<Map<String, String>> tableData, String tokenTime) {
		if (bikeModel == null || plateNumber == null || tokenTime == null) {
			Toast.makeText(this, "Bike model, plate number, or token time is null", Toast.LENGTH_SHORT).show();
			return;
		}

		String email = sessionManager.getEmail();
		if (email == null || email.isEmpty()) {
			Log.e(TAG, "Email is null or empty in saveDataToFirebase");
			Toast.makeText(this, R.string.error_null_email, Toast.LENGTH_SHORT).show();
			return;
		}

		String sanitizedEmail = email.replace(".", ","); // Sanitize email
		DatabaseReference servicesRef = usersRef.child(sanitizedEmail).child("bikes").child(plateNumber).child("services").child(tokenTime);

		servicesRef.setValue(tableData)
				.addOnSuccessListener(aVoid -> {
					Toast.makeText(services_activity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
					tableLayout.removeAllViews();
					navigateToDetailsActivity();
				})
				.addOnFailureListener(e -> {
					Log.e(TAG, "Error saving data", e);
					Toast.makeText(services_activity.this, "Failed to save data", Toast.LENGTH_SHORT).show();
				});
	}


	private void loadPlateNumberForBikeModel(String selectedBikeModel) {
		String email = sessionManager.getEmail();
		if (email == null || email.isEmpty()) {
			Log.e(TAG, "Email is null or empty in loadPlateNumberForBikeModel");
			Toast.makeText(this, R.string.error_null_email, Toast.LENGTH_SHORT).show();
			return;
		}

		String sanitizedEmail = email.replace(".", ","); // Sanitize email
		DatabaseReference userBikesRef = usersRef.child(sanitizedEmail).child("bikes");

		userBikesRef.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				for (DataSnapshot bikeSnapshot : dataSnapshot.getChildren()) {
					String plateNumberKey = bikeSnapshot.getKey();
					String bikeModelValue = bikeSnapshot.child("bikeModel").getValue(String.class);

					if (bikeModelValue != null && bikeModelValue.equals(selectedBikeModel)) {
						plateNumber = plateNumberKey; // Set plateNumber
						break; // Exit loop once the matching plateNumber is found
					}
				}
			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError) {
				Toast.makeText(services_activity.this, "Failed to load plate number", Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void navigateToDetailsActivity() {
		Intent intent = new Intent(services_activity.this, details_to_be_filled_activity.class);
		intent.putExtra("bikeModel", bikeModel);
		intent.putExtra("plateNumber", plateNumber);
		intent.putExtra("tokenTime", tokenTime); // Pass tokenTime


		startActivity(intent);
		finish(); // Optional: Finish current activity if you don't want to return to it
	}
}
