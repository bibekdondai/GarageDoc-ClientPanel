
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		extra_page_
	 *	@date 		Monday 17th of June 2024 06:12:58 PM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */


	package com.example.clientpanel;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;

public class notification_activity extends Activity {

	
	private View _bg__notification_ek6;
	private View rectangle_5_ek2;
	private View rectangle_7_ek1;
	private TextView _25__discount_on_oil_change__ek1;
	private View rectangle_6_ek2;
	private TextView your_vehiche_is_on_bayarea__ek1;
	private TextView notification_ek7;
	private ImageView notification_ek8;
	private TextView _mark_all_as_read;
	private TextView your_vehicle_is_ready_to_pickup__ek1;
	private TextView home_ek2;
	private TextView notification_ek9;
	private TextView call_ek3;
	private TextView setting_ek2;
	private ImageView vector_ek13;
	private ImageView vector_ek14;
	private ImageView _vector_ek15;
	private ImageView vector_ek16;
	private ImageView _vector_ek17;
	private ImageView vector_ek18;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);

		

		rectangle_5_ek2 = (View) findViewById(R.id.rectangle_5_ek2);
		rectangle_7_ek1 = (View) findViewById(R.id.rectangle_7_ek1);
		_25__discount_on_oil_change__ek1 = (TextView) findViewById(R.id._25__discount_on_oil_change__ek1);
		rectangle_6_ek2 = (View) findViewById(R.id.rectangle_6_ek2);
		your_vehiche_is_on_bayarea__ek1 = (TextView) findViewById(R.id.your_vehiche_is_on_bayarea__ek1);
		notification_ek7 = (TextView) findViewById(R.id.notification_ek7);
		notification_ek8 = (ImageView) findViewById(R.id.notification_ek8);
		_mark_all_as_read = (TextView) findViewById(R.id._mark_all_as_read);
		your_vehicle_is_ready_to_pickup__ek1 = (TextView) findViewById(R.id.your_vehicle_is_ready_to_pickup__ek1);

		_vector_ek15 = (ImageView) findViewById(R.id._vector_ek15);
		vector_ek16 = (ImageView) findViewById(R.id.vector_ek16);
		_vector_ek17 = (ImageView) findViewById(R.id._vector_ek17);
		vector_ek18 = (ImageView) findViewById(R.id.vector_ek18);
	
		
//		_mark_all_as_read.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				Intent nextScreen = new Intent(getApplicationContext(), mark_as_read_notification__activity.class);
//				startActivity(nextScreen);
//
//
//			}
//		});
		
		
		_vector_ek15.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek17.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	