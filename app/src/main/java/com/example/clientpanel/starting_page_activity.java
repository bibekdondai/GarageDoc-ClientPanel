package com.example.clientpanel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class starting_page_activity extends Activity {

	private TextView _enter_your_mail;
	private SessionManager sessionManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting_page);

		// Initialize SessionManager
		sessionManager = new SessionManager(getApplicationContext());

		// Initialize views
		_enter_your_mail = findViewById(R.id._enter_your_mail);

		// Check if user is logged in
		if (sessionManager.isLoggedIn()) {
			// Redirect to landing page if logged in
			redirectToLandingPage();
		}

		// Set click listener for entering email
		_enter_your_mail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Navigate to signin_1_activity when clicking enter email text
				Intent intent = new Intent(starting_page_activity.this, signin_1_activity.class);
				startActivity(intent);
			}
		});
	}

	// Method to redirect to landing page
	private void redirectToLandingPage() {
		Intent intent = new Intent(starting_page_activity.this, landing_home_page_1_activity.class);
		startActivity(intent);
		finish(); // Finish this activity so user cannot navigate back to it
	}
}
