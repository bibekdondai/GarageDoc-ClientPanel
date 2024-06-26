package com.example.clientpanel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class password_activity extends Activity {

	private EditText password_ek3;
	private Button login;
	private String emailAddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.password);

		password_ek3 = findViewById(R.id.password_ek3);
		login = findViewById(R.id.login);

		// Get email address from intent
		emailAddress = getIntent().getStringExtra("email_address");

		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String inputPassword = password_ek3.getText().toString().trim();

				if (!inputPassword.isEmpty()) {
					verifyPassword(inputPassword);
				} else {
					Toast.makeText(password_activity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	private void verifyPassword(final String inputPassword) {
		FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference usersRef = database.getReference("client_side");

		usersRef.orderByChild("email_address").equalTo(emailAddress).addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				if (dataSnapshot.exists()) {
					for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
						String correctPassword = userSnapshot.child("password").getValue(String.class);

						if (correctPassword != null && correctPassword.equals(inputPassword)) {
							Toast.makeText(password_activity.this, "Login successful", Toast.LENGTH_SHORT).show();
							// Proceed to next activity
							Intent intent = new Intent(password_activity.this, landing_home_page_1_activity.class);
							startActivity(intent);
						} else {
							Toast.makeText(password_activity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
						}
					}
				} else {
					Toast.makeText(password_activity.this, "User data not found", Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError) {
				Toast.makeText(password_activity.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}
