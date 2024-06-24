package com.example.clientpanel;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;

public class landing_home_page_1_activity extends FragmentActivity {

	private View rectangle_1_ek10;
	private TextView hi;
	private TextView garage_doc_ek6;
	private View rectangle_37;
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

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.landing_home_page_1);

		rectangle_1_ek10 = findViewById(R.id.rectangle_1_ek10);
		hi = findViewById(R.id.hi);
		garage_doc_ek6 = findViewById(R.id.garage_doc_ek6);
		rectangle_37 = findViewById(R.id.rectangle_37);
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
		vector_ek128 = findViewById(R.id.vector_ek128);
		vector_ek129 = findViewById(R.id.vector_ek129);

		_vector_ek126.setOnClickListener(v -> {
			Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
			startActivity(nextScreen);
		});

		_vector_ek127.setOnClickListener(v -> {
			Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
			startActivity(nextScreen);
		});

		repair_removebg_preview_1.setOnClickListener(v -> {
			Intent nextScreen = new Intent(getApplicationContext(), services_activity.class);
			startActivity(nextScreen);
		});

		vector_ek118.setOnClickListener(v -> {
			Intent nextScreen = new Intent(getApplicationContext(), _emergency_activity.class);
			startActivity(nextScreen);
		});

		vector_ek119.setOnClickListener(v -> {
			more_option_activity dialog = new more_option_activity();
			dialog.show(getSupportFragmentManager(), "MoreOptionsBottomSheet");
		});

		vector_ek120.setOnClickListener(v -> {
			Intent nextScreen = new Intent(getApplicationContext(), status_of_vehicles_activity.class);
			startActivity(nextScreen);
		});


		vector_ek129.setOnClickListener(v -> {
			frame_25_activity dialog = new frame_25_activity();
//			dialog.show(getSupportFragmentManager(), "MoreOptionsBottomSheet");

		});

//		vector_ek129.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Fragment frame25Fragment = new frame_25_activity();
//				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//				transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_right,
//						R.anim.slide_in_right, R.anim.slide_out_right);
//				transaction.replace(R.id.frame_25_root, frame25Fragment);
//				transaction.addToBackStack(null);
//				transaction.commit();
//			}
//		});

		// Custom code goes here
	}
}
