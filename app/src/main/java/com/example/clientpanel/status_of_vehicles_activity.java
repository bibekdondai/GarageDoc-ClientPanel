
	 
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

public class status_of_vehicles_activity extends Activity {

	
	private View _bg__status_of_vehicles_ek2;
	private View rectangle_1_ek3;
	private TextView garage_doc;
	private TextView ca;
	private View rectangle_75;
	private View rectangle_76;
	private TextView pending;
	private View rectangle_77;
	private View rectangle_78;
	private TextView process;
	private TextView delivered;
	private View rectangle_79;
	private TextView cancelled;
	private TextView home_ek5;
	private TextView notification_ek12;
	private TextView call_ek6;
	private TextView setting_ek5;
	private ImageView vector_ek40;
	private ImageView vector_ek41;
	private ImageView _vector_ek42;
	private ImageView vector_ek43;
	private ImageView _vector_ek44;
	private ImageView _vector_ek45;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.status_of_vehicles);

		
		_bg__status_of_vehicles_ek2 = (View) findViewById(R.id._bg__status_of_vehicles_ek2);
		rectangle_1_ek3 = (View) findViewById(R.id.rectangle_1_ek3);
		garage_doc = (TextView) findViewById(R.id.garage_doc);
		ca = (TextView) findViewById(R.id.ca);
		rectangle_75 = (View) findViewById(R.id.rectangle_75);
		rectangle_76 = (View) findViewById(R.id.rectangle_76);
		pending = (TextView) findViewById(R.id.pending);
		rectangle_77 = (View) findViewById(R.id.rectangle_77);
		rectangle_78 = (View) findViewById(R.id.rectangle_78);
		process = (TextView) findViewById(R.id.process);
		delivered = (TextView) findViewById(R.id.delivered);
		rectangle_79 = (View) findViewById(R.id.rectangle_79);
		cancelled = (TextView) findViewById(R.id.cancelled);
		home_ek5 = (TextView) findViewById(R.id.home_ek5);
		notification_ek12 = (TextView) findViewById(R.id.notification_ek12);
		call_ek6 = (TextView) findViewById(R.id.call_ek6);
		setting_ek5 = (TextView) findViewById(R.id.setting_ek5);
		vector_ek40 = (ImageView) findViewById(R.id.vector_ek40);
		vector_ek41 = (ImageView) findViewById(R.id.vector_ek41);
		_vector_ek42 = (ImageView) findViewById(R.id._vector_ek42);
		vector_ek43 = (ImageView) findViewById(R.id.vector_ek43);
		_vector_ek44 = (ImageView) findViewById(R.id._vector_ek44);
		_vector_ek45 = (ImageView) findViewById(R.id._vector_ek45);
	
		
		_vector_ek42.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek44.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek45.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	