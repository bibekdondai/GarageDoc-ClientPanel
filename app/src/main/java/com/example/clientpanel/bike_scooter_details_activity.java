
	 
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

public class bike_scooter_details_activity extends Activity {

	
	private View _bg__bike_scooter_details_ek2;
	private View rectangle_1_ek4;
	private TextView garage_doc_ek1;
	private View rectangle_93;
	private TextView bike_details;
	private TextView bike_model_;
	private TextView number_plate_;
	private TextView choose_bike_color_;
	private View rectangle_97;
	private View rectangle_98;
	private View rectangle_100;
	private View rectangle_99;
	private TextView black;
	private TextView blue;
	private TextView red;
	private TextView orange;
	private View line_21;
	private View line_22;
	private TextView home_ek7;
	private TextView notification_ek14;
	private TextView call_ek8;
	private TextView setting_ek7;
	private ImageView vector_ek52;
	private ImageView vector_ek53;
	private ImageView _vector_ek54;
	private ImageView vector_ek55;
	private ImageView _vector_ek56;
	private ImageView _vector_ek57;
	private View rectangle_115;
	private TextView done;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.bike_scooter_details);

		
		_bg__bike_scooter_details_ek2 = (View) findViewById(R.id._bg__bike_scooter_details_ek2);
		rectangle_1_ek4 = (View) findViewById(R.id.rectangle_1_ek4);
		garage_doc_ek1 = (TextView) findViewById(R.id.garage_doc_ek1);
		rectangle_93 = (View) findViewById(R.id.rectangle_93);
		bike_details = (TextView) findViewById(R.id.bike_details);
		bike_model_ = (TextView) findViewById(R.id.bike_model_);
		number_plate_ = (TextView) findViewById(R.id.number_plate_);
		choose_bike_color_ = (TextView) findViewById(R.id.choose_bike_color_);
		rectangle_97 = (View) findViewById(R.id.rectangle_97);
		rectangle_98 = (View) findViewById(R.id.rectangle_98);
		rectangle_100 = (View) findViewById(R.id.rectangle_100);
		rectangle_99 = (View) findViewById(R.id.rectangle_99);
		black = (TextView) findViewById(R.id.black);
		blue = (TextView) findViewById(R.id.blue);
		red = (TextView) findViewById(R.id.red);
		orange = (TextView) findViewById(R.id.orange);
		line_21 = (View) findViewById(R.id.line_21);
		line_22 = (View) findViewById(R.id.line_22);
		home_ek7 = (TextView) findViewById(R.id.home_ek7);
		notification_ek14 = (TextView) findViewById(R.id.notification_ek14);
		call_ek8 = (TextView) findViewById(R.id.call_ek8);
		setting_ek7 = (TextView) findViewById(R.id.setting_ek7);
		vector_ek52 = (ImageView) findViewById(R.id.vector_ek52);
		vector_ek53 = (ImageView) findViewById(R.id.vector_ek53);
		_vector_ek54 = (ImageView) findViewById(R.id._vector_ek54);
		vector_ek55 = (ImageView) findViewById(R.id.vector_ek55);
		_vector_ek56 = (ImageView) findViewById(R.id._vector_ek56);
		_vector_ek57 = (ImageView) findViewById(R.id._vector_ek57);
		rectangle_115 = (View) findViewById(R.id.rectangle_115);
		done = (TextView) findViewById(R.id.done);
	
		
		_vector_ek54.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek56.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek57.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	