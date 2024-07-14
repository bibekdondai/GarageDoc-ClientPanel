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

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class starting_page_activity extends FragmentActivity {

	private TextView _enter_your_mail;
	private SessionManager sessionManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting_page);

		// Initialize SessionManager
		sessionManager = new SessionManager(getApplicationContext());

		// Initialize views
		_enter_your_mail = findViewById(R.id._enter_your_mail);
		initializeViews();

		// Check if user is logged in
		if (sessionManager.isLoggedIn()) {
			// Redirect to landing page if logged in
			redirectToLandingPage();

		}
		setClickListeners();
	}
		private void initializeViews() {
			_enter_your_mail = findViewById(R.id._enter_your_mail);
		}


		// Set click listener for entering email
		private void setClickListeners() {
//			_enter_your_mail.setOnClickListener(new View.OnClickListener() {
				_enter_your_mail.setOnClickListener(v -> {
				login_option_activity dialog = new login_option_activity();
			dialog.show(getSupportFragmentManager(), "LoginOptionsBottomSheet");
			});
		}


	// Method to redirect to landing page
	private void redirectToLandingPage() {
		Intent intent = new Intent(starting_page_activity.this, landing_home_page_1_activity.class);
		startActivity(intent);
		finish(); // Finish this activity so user cannot navigate back to it
	}
}
