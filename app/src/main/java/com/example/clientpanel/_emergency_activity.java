
	 
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
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class _emergency_activity extends Activity {

	
	private View _bg____emergency_ek2;
	private View rectangle_2_ek1;
	private ImageView rectangle_28;
	private ImageView rectangle_30;
	private ImageView rectangle_31;
	private TextView address_street_name;
	private View rectangle_29;
	private TextView choose_from_map;
	private TextView confirm_location;
	private ImageView maps_removebg_preview_1;
	private TextView contact_details;
	private TextView home_ek6;
	private TextView notification_ek13;
	private TextView call_ek7;
	private TextView setting_ek6;
	private ImageView vector_ek46;
	private ImageView vector_ek47;
	private ImageView _vector_ek48;
	private ImageView vector_ek49;
	private ImageView _vector_ek50;
	private ImageView _vector_ek51;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout._emergency);

		
//		_bg____emergency_ek2 = (View) findViewById(R.id._bg____emergency_ek2);
		rectangle_2_ek1 = (View) findViewById(R.id.rectangle_2_ek1);
		rectangle_28 = (ImageView) findViewById(R.id.rectangle_28);
		rectangle_30 = (ImageView) findViewById(R.id.rectangle_30);
		rectangle_31 = (ImageView) findViewById(R.id.rectangle_31);
		address_street_name = (TextView) findViewById(R.id.address_street_name);
		rectangle_29 = (View) findViewById(R.id.rectangle_29);
		choose_from_map = (TextView) findViewById(R.id.choose_from_map);
		confirm_location = (TextView) findViewById(R.id.confirm_location);
//		maps_removebg_preview_1 = (ImageView) findViewById(R.id.maps_removebg_preview_1);
		contact_details = (TextView) findViewById(R.id.contact_details);
//		home_ek6 = (TextView) findViewById(R.id.home_ek6);
//		notification_ek13 = (TextView) findViewById(R.id.notification_ek13);
//		call_ek7 = (TextView) findViewById(R.id.call_ek7);
//		setting_ek6 = (TextView) findViewById(R.id.setting_ek6);
		vector_ek46 = (ImageView) findViewById(R.id.vector_ek46);
//		vector_ek47 = (ImageView) findViewById(R.id.vector_ek47);

		vector_ek49 = (ImageView) findViewById(R.id.vector_ek49);
		_vector_ek50 = (ImageView) findViewById(R.id._vector_ek50);
		_vector_ek51 = (ImageView) findViewById(R.id._vector_ek51);
	
		
		_vector_ek48.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek50.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek51.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	