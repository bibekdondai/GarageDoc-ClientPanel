
	 
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

public class info_activity extends Activity {

	
	private View _bg__info_ek2;
	private View rectangle_18;
	private TextView enter_your_full_name_ek1;
	private View rectangle_19;
	private TextView enter_your_email_ek1;
	private View rectangle_20;
	private TextView enter_your_phone_number;
	private View rectangle_24;
	private TextView address;
	private View rectangle_21;
	private TextView birthday;
	private View rectangle_22;
	private TextView gender;
	private View _rectangle_25;
	private TextView finish;
	private TextView please_enter_accurate_data_so_we_can_best_serve_you_____;
	private TextView lets_get_started;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);

		
		_bg__info_ek2 = (View) findViewById(R.id._bg__info_ek2);
		rectangle_18 = (View) findViewById(R.id.rectangle_18);
		enter_your_full_name_ek1 = (TextView) findViewById(R.id.enter_your_full_name_ek1);
		rectangle_19 = (View) findViewById(R.id.rectangle_19);
		enter_your_email_ek1 = (TextView) findViewById(R.id.enter_your_email_ek1);
		rectangle_20 = (View) findViewById(R.id.rectangle_20);
		enter_your_phone_number = (TextView) findViewById(R.id.enter_your_phone_number);
		rectangle_24 = (View) findViewById(R.id.rectangle_24);
		address = (TextView) findViewById(R.id.address);
		rectangle_21 = (View) findViewById(R.id.rectangle_21);
		birthday = (TextView) findViewById(R.id.birthday);
		rectangle_22 = (View) findViewById(R.id.rectangle_22);
		gender = (TextView) findViewById(R.id.gender);
		_rectangle_25 = (View) findViewById(R.id._rectangle_25);
		finish = (TextView) findViewById(R.id.finish);
		please_enter_accurate_data_so_we_can_best_serve_you_____ = (TextView) findViewById(R.id.please_enter_accurate_data_so_we_can_best_serve_you_____);
		lets_get_started = (TextView) findViewById(R.id.lets_get_started);
	
		
		_rectangle_25.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	