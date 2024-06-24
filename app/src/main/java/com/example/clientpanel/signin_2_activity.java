package com.example.clientpanel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class signin_2_activity extends Activity {

	private EditText phone_number;
	private Button next_p;
	private TextView _use_email_instead__;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signin_2);

		phone_number = findViewById(R.id.phone_number);
		next_p = findViewById(R.id.next_p);
		_use_email_instead__ = findViewById(R.id._use_email_instead__);

		next_p.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String phone = phone_number.getText().toString().trim();

				if (!phone.isEmpty() && isValidPhoneNumber(phone)) {
					checkPhoneInDatabase(phone);
				} else {
					Toast.makeText(signin_2_activity.this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show();
				}
			}
		});

	_use_email_instead__.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(signin_2_activity.this, signin_1_activity.class);
			startActivity(intent);
		}
	});
}

	private void checkPhoneInDatabase(final String phone) {
		FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference usersRef = database.getReference("client_side");

		usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				boolean phoneExists = false;

				for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
					String storedPhone = userSnapshot.child("phone_number").getValue(String.class);
					Log.d("checkPhoneInDatabase", "Checking phone: " + storedPhone);
					if (storedPhone != null && storedPhone.equals(phone)) {
						phoneExists = true;
						break;
					}
				}

				if (phoneExists) {
					Log.d("checkPhoneInDatabase", "Phone exists: " + phone);

					Intent intent = new Intent(signin_2_activity.this, password_activity.class);
					intent.putExtra("phone_number", phone);
					startActivity(intent);
				} else {
					Log.d("checkPhoneInDatabase", "Phone does not exist: " + phone);

					Toast.makeText(signin_2_activity.this, "Phone not registered", Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError) {
				Log.e("checkPhoneInDatabase", "Database error: " + databaseError.getMessage());

				Toast.makeText(signin_2_activity.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	private boolean isValidPhoneNumber(CharSequence phone) {
		// You can add more complex phone number validation logic if needed
		return phone.length() >= 10 && phone.length() <= 15;
	}
}
