
	 
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
import android.content.Intent;
import android.widget.ImageView;

public class settings_activity extends Activity {

	
	private View _bg__settings_ek2;
	private View rectangle_1_ek2;
	private TextView settings_ek3;
	private View rectangle_60;
	private TextView faqs_ek1;
	private View _rectangle_61, support;

	private View rectangle_63;
	private TextView mode;
	private View rectangle_65;
	private TextView share;
	private View rectangle_66;
	private TextView write_a_review;
	private ImageView rectangle_64;
	private View rectangle_62;
	private TextView feedback;
	private TextView change_password;
	private ImageView vector_ek25;
	private ImageView vector_ek26;
	private ImageView vector_ek27;
	private ImageView vector_ek28;
	private ImageView vector_ek29;
	private ImageView vector_ek30;
	private ImageView vector_ek31;
	private ImageView vector_ek32;
	private ImageView vector_ek33;
	private TextView support_ek4;
	private TextView home_ek4;
	private TextView notification_ek11 ;
	private TextView call_ek5;
	private TextView setting_ek4;
	private ImageView vector_ek34;
	private ImageView vector_ek35 ,settings, home, call, notification;
	private ImageView _vector_ek36;
	private ImageView vector_ek37;
	private ImageView _vector_ek38;
	private ImageView _vector_ek39;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		

//		rectangle_1_ek2 = (View) findViewById(R.id.rectangle_1_ek2);
//		settings_ek3 = (TextView) findViewById(R.id.settings_ek3);
//		rectangle_60 = (View) findViewById(R.id.rectangle_60);
//		faqs_ek1 = (TextView) findViewById(R.id.faqs_ek1);
//		_rectangle_61 = (View) findViewById(R.id._rectangle_61);
//		rectangle_63 = (View) findViewById(R.id.rectangle_63);
//
//		rectangle_65 = (View) findViewById(R.id.rectangle_65);
//		share = (TextView) findViewById(R.id.share);
//		rectangle_66 = (View) findViewById(R.id.rectangle_66);
//		write_a_review = (TextView) findViewById(R.id.write_a_review);
//
//		rectangle_62 = (View) findViewById(R.id.rectangle_62);
//
//		change_password = (TextView) findViewById(R.id.change_password);
//		vector_ek25 = (ImageView) findViewById(R.id.vector_ek25);
//		vector_ek26 = (ImageView) findViewById(R.id.vector_ek26);
//
//		vector_ek29 = (ImageView) findViewById(R.id.vector_ek29);
//		vector_ek30 = (ImageView) findViewById(R.id.vector_ek30);
//
//		vector_ek33 = (ImageView) findViewById(R.id.vector_ek33);
//		support_ek4 = (TextView) findViewById(R.id.support_ek4);
//		home_ek4 = (TextView) findViewById(R.id.home_ek4);
//		notification_ek11 = (TextView) findViewById(R.id.notification_ek11);
//		call_ek5 = (TextView) findViewById(R.id.call_ek5);
//		setting_ek4 = (TextView) findViewById(R.id.setting_ek4);
		home = findViewById(R.id.vector_ek46);

//		call = (ImageView) findViewById(R.id.vector_ek49);
//		settings= (ImageView) findViewById(R.id._vector_ek50);
		notification= (ImageView) findViewById(R.id._vector_ek51);
		support = findViewById(R.id._rectangle_61);


		support.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				Intent nextScreen = new Intent(getApplicationContext(), support_activity.class);
				startActivity(nextScreen);
				finish();


			}
		});
		
		
		home.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
				finish();
			
		
			}
		});
		
//		home.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
//				startActivity(nextScreen);
//
//
//			}
//		});
		
		
		notification.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
				finish();
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	