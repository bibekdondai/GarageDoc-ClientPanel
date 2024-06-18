
	 
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

public class vehicle_info_activity extends Activity {

	
	private View _bg__vehicle_info_ek2;
	private View rectangle_1_ek8;
	private TextView _10_59_ek1;
	private TextView garage_doc_ek4;
	private View rectangle_80_ek2;
	private TextView _1_;
	private TextView mt_15__yamaha_last_serviced__2012_12_10_;
	private ImageView image_1_ek1;
	private TextView add_vehicles;
	private TextView home_ek15;
	private TextView notification_ek22;
	private TextView call_ek16;
	private TextView setting_ek15;
	private ImageView vector_ek105;
	private ImageView vector_ek106;
	private ImageView _vector_ek107;
	private ImageView vector_ek108;
	private ImageView _vector_ek109;
	private ImageView _vector_ek110;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.vehicle_info);

		
		_bg__vehicle_info_ek2 = (View) findViewById(R.id._bg__vehicle_info_ek2);
		rectangle_1_ek8 = (View) findViewById(R.id.rectangle_1_ek8);
		_10_59_ek1 = (TextView) findViewById(R.id._10_59_ek1);
		garage_doc_ek4 = (TextView) findViewById(R.id.garage_doc_ek4);
		rectangle_80_ek2 = (View) findViewById(R.id.rectangle_80_ek2);
		_1_ = (TextView) findViewById(R.id._1_);
		mt_15__yamaha_last_serviced__2012_12_10_ = (TextView) findViewById(R.id.mt_15__yamaha_last_serviced__2012_12_10_);
		image_1_ek1 = (ImageView) findViewById(R.id.image_1_ek1);
		add_vehicles = (TextView) findViewById(R.id.add_vehicles);
		home_ek15 = (TextView) findViewById(R.id.home_ek15);
		notification_ek22 = (TextView) findViewById(R.id.notification_ek22);
		call_ek16 = (TextView) findViewById(R.id.call_ek16);
		setting_ek15 = (TextView) findViewById(R.id.setting_ek15);
		vector_ek105 = (ImageView) findViewById(R.id.vector_ek105);
		vector_ek106 = (ImageView) findViewById(R.id.vector_ek106);
		_vector_ek107 = (ImageView) findViewById(R.id._vector_ek107);
		vector_ek108 = (ImageView) findViewById(R.id.vector_ek108);
		_vector_ek109 = (ImageView) findViewById(R.id._vector_ek109);
		_vector_ek110 = (ImageView) findViewById(R.id._vector_ek110);
	
		
		_vector_ek107.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek109.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek110.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	