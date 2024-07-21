package com.example.clientpanel;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class landing_home_page_1_activity extends FragmentActivity {
	private static final String TAG = "LandingHomePage"; // Define TAG constant for logging


	private TextView hi;
	private TextView garage_doc_ek6;
	private ImageView vector_ek134;
	private ImageView repair_removebg_preview_1;
	private TextView services_ek3;
	private ImageView vector_ek118;
	private TextView emergency;
	private ImageView vector_ek119;
	private ImageView vector_ek120;
	private ImageView vector_ek121;
	private TextView add_vehicles_ek1;
	private TextView bookings;
	private ImageView vector_ek124;
	private ImageView vector_ek125;
	private ImageView _vector_ek126;
	private ImageView _vector_ek127;
	private ImageView vector_ek128;
	private ImageView vector_ek129;

	private SessionManager sessionManager;
	private Handler sessionTimeoutHandler;
	private Runnable sessionTimeoutRunnable;
	private TextView welcomeText;
	private String emailAddress;

	private static final long SESSION_TIMEOUT_MS = 5 * 60 * 1000; // 5 minutes in milliseconds

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.landing_home_page_1);
		welcomeText = findViewById(R.id.hi);

		sessionManager = new SessionManager(this);
		emailAddress = getIntent().getStringExtra("emailAddress");
		String email = sessionManager.getEmail();

		initializeViews();

		// Check if user is logged in
		if (!sessionManager.isLoggedIn()) {
			navigateToSignInActivity();
			return;
		}
		// Fetch and display full name
		fetchAndDisplayFullName(email);


		// Start session timeout countdown
		startSessionTimeout();

		// Set click listeners for various buttons and views
		setClickListeners();
	}

	private void initializeViews() {
		hi = findViewById(R.id.hi);
		garage_doc_ek6 = findViewById(R.id.garage_doc_ek6);
		vector_ek134 = findViewById(R.id.vector_ek134);
		repair_removebg_preview_1 = findViewById(R.id.repair_removebg_preview_1);
		services_ek3 = findViewById(R.id.services_ek3);
		vector_ek118 = findViewById(R.id.vector_ek118);
		emergency = findViewById(R.id.emergency);
		vector_ek119 = findViewById(R.id.vector_ek119);
		vector_ek120 = findViewById(R.id.vector_ek120);
		vector_ek121 = findViewById(R.id.vector_ek121);
		add_vehicles_ek1 = findViewById(R.id.add_vehicles_ek1);
		bookings = findViewById(R.id.bookings);
		vector_ek124 = findViewById(R.id.vector_ek124);
		vector_ek125 = findViewById(R.id.vector_ek125);
		_vector_ek126 = findViewById(R.id._vector_ek126);
		_vector_ek127 = findViewById(R.id._vector_ek127);

		vector_ek129 = findViewById(R.id.vector_ek129);
	}

	private void setClickListeners() {
		_vector_ek126.setOnClickListener(v -> {
			startActivity(new Intent(getApplicationContext(), settings_activity.class));
		});

		_vector_ek127.setOnClickListener(v -> {
			startActivity(new Intent(getApplicationContext(), notification_activity.class));
		});

		repair_removebg_preview_1.setOnClickListener(v -> {
			startActivity(new Intent(getApplicationContext(), services_activity.class));
		});

		vector_ek118.setOnClickListener(v -> {
			startActivity(new Intent(getApplicationContext(), _emergency_activity.class));
		});

		vector_ek119.setOnClickListener(v -> {
			more_option_activity dialog = new more_option_activity();


			dialog.show(getSupportFragmentManager(), "MoreOptionsBottomSheet");
		});

		vector_ek120.setOnClickListener(v -> {
			startActivity(new Intent(getApplicationContext(), status_of_vehicles_activity.class));
		});
	}

	@Override
	public void onBackPressed() {
		showLogoutConfirmationDialog();
	}

	@Override
	protected void onResume() {
		super.onResume();
		startSessionTimeout();
	}

	@Override
	protected void onPause() {
		super.onPause();
		stopSessionTimeout();
	}

	private void startSessionTimeout() {
		if (sessionTimeoutHandler == null) {
			sessionTimeoutHandler = new Handler();
		}
		if (sessionTimeoutRunnable == null) {
			sessionTimeoutRunnable = new Runnable() {
				@Override
				public void run() {
					sessionManager.clearSession();
					Toast.makeText(landing_home_page_1_activity.this, "Session expired. Please login again.", Toast.LENGTH_SHORT).show();
					navigateToSignInActivity();
				}
			};
		}
		sessionTimeoutHandler.postDelayed(sessionTimeoutRunnable, SESSION_TIMEOUT_MS);
	}

	private void stopSessionTimeout() {
		if (sessionTimeoutHandler != null && sessionTimeoutRunnable != null) {
			sessionTimeoutHandler.removeCallbacks(sessionTimeoutRunnable);
		}
	}

	private void showLogoutConfirmationDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Logout Confirmation");
		builder.setMessage("Are you sure you want to logout?");
		builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				sessionManager.clearSession();
				Toast.makeText(landing_home_page_1_activity.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
				navigateToSignInActivity();
			}
		});
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builder.show();
	}

	private void navigateToSignInActivity() {
		Intent intent = new Intent(landing_home_page_1_activity.this, signin_1_activity.class);
		startActivity(intent);
		finish(); // Finish current activity to prevent back button from returning here
	}

	private void fetchAndDisplayFullName(String email) {
		String formattedEmail = email.replace(".", ",");
		DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(formattedEmail);

		userRef.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				if (dataSnapshot.exists()) {
					String fullName = dataSnapshot.child("fullName").getValue(String.class);
					if (fullName != null) {
						welcomeText.setText("Hi, " + fullName);
					} else {
						welcomeText.setText("Hi, User");
					}
				} else {
					welcomeText.setText("Hi, User");
				}
			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError) {
				Log.e(TAG, "Failed to read full name.", databaseError.toException());
				welcomeText.setText("Hi, User");
			}
		});
	}

//	private void getSupportFragmentManager() {
//		Intent intent = new Intent(getActivity(), vehicle_info_activity.class);
//		intent.putExtra("email", emailAddress);
//
//		startActivity(intent);
//		dismiss();
//		// Dismiss the bottom sheet after starting the activity
//	}
}
