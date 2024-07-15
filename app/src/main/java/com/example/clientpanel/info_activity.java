package com.example.clientpanel;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class info_activity extends Activity {

	private EditText enter_your_full_name_ek1, enter_your_email_ek1, enter_your_phone_number, address, birthday, gender;
	private TextView finish;

	private String emailVerificationCode;

	private FirebaseDatabase firebaseDatabase;
	private DatabaseReference databaseReference;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);

		// Initialize Firebase
		firebaseDatabase = FirebaseDatabase.getInstance();
		databaseReference = firebaseDatabase.getReference("users");

		// Initialize UI elements
		enter_your_full_name_ek1 = findViewById(R.id.enter_your_full_name_ek1);
		enter_your_email_ek1 = findViewById(R.id.enter_your_email_ek1);
		enter_your_phone_number = findViewById(R.id.enter_your_phone_number);
		address = findViewById(R.id.address);
		birthday = findViewById(R.id.birthday);
		gender = findViewById(R.id.gender);
		finish = findViewById(R.id.finish);

		// Handle finish button click
		finish.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Validate input fields (optional)

				// Generate OTP and send via email
				sendOTPByEmail();
			}
		});
	}

	// Method to generate OTP and send via email
	private void sendOTPByEmail() {
		// Generate a random OTP (you can use your own logic to generate OTP)
		emailVerificationCode = generateOTP();

		// For demonstration purpose, log the OTP
		Toast.makeText(info_activity.this, "Generated OTP: " + emailVerificationCode, Toast.LENGTH_SHORT).show();

		// Send email with OTP
		sendEmailVerification(emailVerificationCode);
	}

	// Method to send email verification with OTP
	private void sendEmailVerification(String otp) {
		String email = enter_your_email_ek1.getText().toString().trim();
		String subject = "Verification Code";
		String message = "Your verification code is: " + otp;

		// You can use JavaMail or any email service to send this email
		// For demonstration purpose, you can toast the OTP
		Toast.makeText(info_activity.this, "Email sent with OTP.", Toast.LENGTH_SHORT).show();

		// After sending email, show OTP dialog
		showOTPDialog();
	}

	// Method to generate a random OTP (for demonstration purpose)
	private String generateOTP() {
		// Generate a 4-digit random OTP
		return String.format("%04d", new java.util.Random().nextInt(10000));
	}

	// Method to show OTP dialog
	private void showOTPDialog() {
		// Inflate custom layout for OTP dialog
		View dialogView = getLayoutInflater().inflate(R.layout.dialog_enter_otp, null);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setView(dialogView)
				.setTitle("Enter OTP")
				.setPositiveButton("Verify", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						EditText editTextOTP1 = dialogView.findViewById(R.id.editTextOTP1);
						EditText editTextOTP2 = dialogView.findViewById(R.id.editTextOTP2);
						EditText editTextOTP3 = dialogView.findViewById(R.id.editTextOTP3);
						EditText editTextOTP4 = dialogView.findViewById(R.id.editTextOTP4);

						// Validate OTP input
						String otp = editTextOTP1.getText().toString().trim() +
								editTextOTP2.getText().toString().trim() +
								editTextOTP3.getText().toString().trim() +
								editTextOTP4.getText().toString().trim();

						// Verify OTP
						if (otp.equals(emailVerificationCode)) {
							// OTP verification successful, save data and proceed to password creation
							saveDataToFirebase();
						} else {
							// Invalid OTP
							Toast.makeText(info_activity.this, "Invalid OTP. Please try again.", Toast.LENGTH_SHORT).show();
						}
					}
				})
				.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});

		AlertDialog alertDialog = builder.create();
		alertDialog.show();
	}

	// Method to save user data to Firebase
	private void saveDataToFirebase() {
		String fullName = enter_your_full_name_ek1.getText().toString();
		String email = enter_your_email_ek1.getText().toString().replace(".", ","); // Replace . with , for Firebase key
		String phoneNumber = enter_your_phone_number.getText().toString();
		String addressText = address.getText().toString();
		String birthdayText = birthday.getText().toString();
		String genderText = gender.getText().toString();

		User user = new User(fullName, email, phoneNumber, addressText, birthdayText, genderText);

		// Save user data to Firebase
		databaseReference.child(email).setValue(user)
				.addOnCompleteListener(task -> {
					if (task.isSuccessful()) {
						// Data saved successfully, proceed to password creation
						navigateToPasswordCreation();
					} else {
						// Failed to save data
						Toast.makeText(info_activity.this, "Failed to save data. Please try again.", Toast.LENGTH_SHORT).show();
					}
				});
	}

	// Method to navigate to password creation activity
	private void navigateToPasswordCreation() {
		Intent intent = new Intent(info_activity.this, password_creation_activity.class);

		// Pass user data to the next activity if needed
		intent.putExtra("fullName", enter_your_full_name_ek1.getText().toString());
		intent.putExtra("email", enter_your_email_ek1.getText().toString());
		intent.putExtra("phoneNumber", enter_your_phone_number.getText().toString());
		intent.putExtra("address", address.getText().toString());
		intent.putExtra("birthday", birthday.getText().toString());
		intent.putExtra("gender", gender.getText().toString());
		startActivity(intent);
		finish(); // Optional: Close current activity
	}

	// User class to hold user information
	public static class User {
		public String fullName, email, phoneNumber, address, birthday, gender;

		public User() {
			// Default constructor required for calls to DataSnapshot.getValue(User.class)
		}

		public User(String fullName, String email, String phoneNumber, String address, String birthday, String gender) {
			this.fullName = fullName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.birthday = birthday;
			this.gender = gender;
		}
	}

}
