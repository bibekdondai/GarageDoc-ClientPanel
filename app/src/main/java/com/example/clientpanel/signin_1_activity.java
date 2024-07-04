package com.example.clientpanel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signin_1_activity extends Activity {

	private EditText email_address;
	private Button next;
	private TextView use_mobile_number_instead;
	private SessionManager sessionManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signin_1);

		sessionManager = new SessionManager(this);

		// Check if user is already logged in
		if (sessionManager.isLoggedIn()) {
			Intent intent = new Intent(signin_1_activity.this, landing_home_page_1_activity.class);
			startActivity(intent);
			finish();
			return;
		}

		email_address = findViewById(R.id.email_address);
		next = findViewById(R.id.next);
		use_mobile_number_instead = findViewById(R.id.use_mobile_number_instead);

		next.setOnClickListener(v -> {
			String email = email_address.getText().toString().trim();

			if (!email.isEmpty() && isValidEmail(email)) {
				checkEmailInDatabase(email);
			} else {
				Toast.makeText(signin_1_activity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
			}
		});

		use_mobile_number_instead.setOnClickListener(v -> {
			Intent intent = new Intent(signin_1_activity.this, signin_2_activity.class);
			startActivity(intent);
		});
	}

	private void checkEmailInDatabase(final String email) {
		FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference usersRef = database.getReference("client_side");

		usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				boolean emailExists = false;

				for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
					String storedEmail = userSnapshot.child("email_address").getValue(String.class);
					if (storedEmail != null && storedEmail.equals(email)) {
						emailExists = true;
						break;
					}
				}

				if (emailExists) {
					Intent intent = new Intent(signin_1_activity.this, password_activity.class);
					intent.putExtra("email_address", email);
					startActivity(intent);
				} else {
					Toast.makeText(signin_1_activity.this, "Email not registered", Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError) {
				Toast.makeText(signin_1_activity.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	private boolean isValidEmail(CharSequence email) {
		return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
	}
}
