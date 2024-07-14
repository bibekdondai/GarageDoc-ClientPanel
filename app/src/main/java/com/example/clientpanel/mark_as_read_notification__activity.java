
	 
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

public class mark_as_read_notification__activity extends Activity {

	
	private View _bg__mark_as_read_notification__ek2;
	private View rectangle_5_ek1;
	private View rectangle_7;
	private TextView _25__discount_on_oil_change_;
	private View rectangle_6_ek1;
	private TextView your_vehiche_is_on_bayarea_;
	private TextView notification_ek1;
	private ImageView notification_ek2;
	private TextView your_vehicle_is_ready_to_pickup_;
	private TextView home_ek1;
	private TextView notification_ek3;
	private TextView call_ek2;
	private TextView setting_ek1;
	private ImageView vector_ek7;
	private ImageView vector_ek8;
	private ImageView _vector_ek9;
	private ImageView vector_ek10;
	private ImageView _vector_ek11;
	private ImageView _vector_ek12;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.mark_as_read_notification_);

		
		_bg__mark_as_read_notification__ek2 = (View) findViewById(R.id._bg__mark_as_read_notification__ek2);
		rectangle_5_ek1 = (View) findViewById(R.id.rectangle_5_ek1);
		rectangle_7 = (View) findViewById(R.id.rectangle_7);
		_25__discount_on_oil_change_ = (TextView) findViewById(R.id._25__discount_on_oil_change_);
		rectangle_6_ek1 = (View) findViewById(R.id.rectangle_6_ek1);
		your_vehiche_is_on_bayarea_ = (TextView) findViewById(R.id.your_vehiche_is_on_bayarea_);
		notification_ek1 = (TextView) findViewById(R.id.notification_ek1);
		notification_ek2 = (ImageView) findViewById(R.id.notification_ek2);
		your_vehicle_is_ready_to_pickup_ = (TextView) findViewById(R.id.your_vehicle_is_ready_to_pickup_);
//		home_ek1 = (TextView) findViewById(R.id.home_ek1);
//		notification_ek3 = (TextView) findViewById(R.id.notification_ek3);
//		call_ek2 = (TextView) findViewById(R.id.call_ek2);
//		setting_ek1 = (TextView) findViewById(R.id.setting_ek1);
		vector_ek7 = (ImageView) findViewById(R.id.vector_ek7);
		vector_ek8 = (ImageView) findViewById(R.id.vector_ek8);
		_vector_ek9 = (ImageView) findViewById(R.id._vector_ek9);
		vector_ek10 = (ImageView) findViewById(R.id.vector_ek10);
		_vector_ek11 = (ImageView) findViewById(R.id._vector_ek11);
		_vector_ek12 = (ImageView) findViewById(R.id._vector_ek12);
	
		
		_vector_ek9.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek11.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek12.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	