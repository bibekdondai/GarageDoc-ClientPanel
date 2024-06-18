
	 
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

public class signin_1_activity extends Activity {

	
	private View _bg__signin_1_ek2;
	private ImageView ellipse_2;
	private TextView terms_and_conditions___privacy_policy_ek1;
	private View _rectangle_21_ek2;
	private TextView next_ek3;
	private TextView _use_mobile_number_instead__;
	private ImageView line_13_ek1;
	private TextView email_address;
	private TextView proceed_with_your_email;
	private ImageView _back_arrow_ek4;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.signin_1);

		
		_bg__signin_1_ek2 = (View) findViewById(R.id._bg__signin_1_ek2);
		ellipse_2 = (ImageView) findViewById(R.id.ellipse_2);
		terms_and_conditions___privacy_policy_ek1 = (TextView) findViewById(R.id.terms_and_conditions___privacy_policy_ek1);
		_rectangle_21_ek2 = (View) findViewById(R.id._rectangle_21_ek2);
		next_ek3 = (TextView) findViewById(R.id.next_ek3);
		_use_mobile_number_instead__ = (TextView) findViewById(R.id._use_mobile_number_instead__);
		line_13_ek1 = (ImageView) findViewById(R.id.line_13_ek1);
		email_address = (TextView) findViewById(R.id.email_address);
		proceed_with_your_email = (TextView) findViewById(R.id.proceed_with_your_email);
		_back_arrow_ek4 = (ImageView) findViewById(R.id._back_arrow_ek4);
	
		
		_rectangle_21_ek2.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), verification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_use_mobile_number_instead__.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), signin_2_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_back_arrow_ek4.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), starting_page_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	