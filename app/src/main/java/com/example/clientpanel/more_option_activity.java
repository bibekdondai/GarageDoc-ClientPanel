
	 
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

public class more_option_activity extends Activity {

	
	private View _bg__more_option_ek2;
	private View rectangle_44;
	private TextView _add_bike;
	private TextView _add_scooter;
	private View line_18;
	private View _rectangle_45;
	private TextView dismiss;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.more_option);

		
		_bg__more_option_ek2 = (View) findViewById(R.id._bg__more_option_ek2);
		rectangle_44 = (View) findViewById(R.id.rectangle_44);
		_add_bike = (TextView) findViewById(R.id._add_bike);
		_add_scooter = (TextView) findViewById(R.id._add_scooter);
		line_18 = (View) findViewById(R.id.line_18);
		_rectangle_45 = (View) findViewById(R.id._rectangle_45);
		dismiss = (TextView) findViewById(R.id.dismiss);
	
		
		_add_bike.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), add_bike_scooter_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_add_scooter.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), add_bike_scooter_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_rectangle_45.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	