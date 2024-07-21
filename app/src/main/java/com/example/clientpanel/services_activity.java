package com.example.clientpanel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
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
		ArrayAdapter<String> modelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bikeModels);
		modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner3.setAdapter(modelAdapter);

		ArrayAdapter<String> partsAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bikeParts1);
		partsAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(partsAdapter1);

		// Load bike models
		loadBikeModels();

		// Spinner3 item selection listener
		spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String selectedBikeModel = bikeModels.size() > position ? bikeModels.get(position) : null;
				if (selectedBikeModel != null) {
					loadBikePartsFromFirestore(selectedBikeModel);
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
					// Assuming that each bikeSnapshot contains plateNumber as key and bikeModel as value
					String bikeModel = bikeSnapshot.child("bikeModel").getValue(String.class); // Get bikeModel value
					if (bikeModel != null) {
						bikeModels.add(bikeModel);
					} else {
						Log.w(TAG, "Bike model is null for plateNumber: " + bikeSnapshot.getKey());
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

			for (int i = 0; i < tableLayout.getChildCount(); i++) {
				View child = tableLayout.getChildAt(i);
				if (child instanceof TableRow) {
					TableRow tableRow = (TableRow) child;
					if (tableRow.getChildCount() == 3) {
						TextView partTextView = (TextView) tableRow.getChildAt(0);
						TextView priceTextView = (TextView) tableRow.getChildAt(1);

						String partName = partTextView.getText().toString();
						String partPrice = priceTextView.getText().toString();

						if (!partName.isEmpty() && !partPrice.isEmpty()) {
							Map<String, String> rowData = new HashMap<>();
							rowData.put("part", partName);
							rowData.put("price", partPrice);
							tableData.add(rowData);
						}
					}
				}
			}

			if (tableData.isEmpty()) {
				Toast.makeText(services_activity.this, "No data to save", Toast.LENGTH_SHORT).show();
				return;
			}

			saveDataToDatabase(tableData);

			// Navigate to details_to_be_filled page
			Intent intent = new Intent(services_activity.this, details_to_be_filled_activity.class);
			intent.putExtra("tableData", new ArrayList<>(tableData)); // Pass table data
			startActivity(intent);
		});
	}

	private void saveDataToDatabase(List<Map<String, String>> tableData) {
		// Use Firebase Realtime Database or Firestore to save data
		// Example for Firebase Realtime Database:
		String email = sessionManager.getEmail();
		if (email == null || email.isEmpty()) {
			Log.e(TAG, "Email is null or empty in saveDataToDatabase");
			return;
		}

		String sanitizedEmail = email.replace(".", ","); // Sanitize email
		DatabaseReference userDataRef = usersRef.child(sanitizedEmail).child("selectedData");

		userDataRef.setValue(tableData).addOnCompleteListener(task -> {
			if (task.isSuccessful()) {
				Toast.makeText(services_activity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(services_activity.this, "Failed to save data", Toast.LENGTH_SHORT).show();
				Log.e(TAG, "Error saving data", task.getException());
			}
		});
	}
}
