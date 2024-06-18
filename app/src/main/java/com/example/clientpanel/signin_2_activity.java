
	 
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
import android.content.Intent;
import android.widget.TextView;

public class signin_2_activity extends Activity {

	
	private View _bg__signin_2_ek2;
	private ImageView ellipse_3;
	private View _rectangle_21_ek1;
	private TextView next_ek2;
	private TextView terms_and_conditions___privacy_policy;
	private TextView _use_email_instead__;
	private ImageView line_13;
	private TextView phone_number_ek1;
	private View line_12;
	private TextView __977;
	private TextView you_ll_get_an_sms_to;
	private ImageView _back_arrow_ek3;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.signin_2);

		
		_bg__signin_2_ek2 = (View) findViewById(R.id._bg__signin_2_ek2);
		ellipse_3 = (ImageView) findViewById(R.id.ellipse_3);
		_rectangle_21_ek1 = (View) findViewById(R.id._rectangle_21_ek1);
		next_ek2 = (TextView) findViewById(R.id.next_ek2);
		terms_and_conditions___privacy_policy = (TextView) findViewById(R.id.terms_and_conditions___privacy_policy);
		_use_email_instead__ = (TextView) findViewById(R.id._use_email_instead__);
		line_13 = (ImageView) findViewById(R.id.line_13);
		phone_number_ek1 = (TextView) findViewById(R.id.phone_number_ek1);
		line_12 = (View) findViewById(R.id.line_12);
		__977 = (TextView) findViewById(R.id.__977);
		you_ll_get_an_sms_to = (TextView) findViewById(R.id.you_ll_get_an_sms_to);
		_back_arrow_ek3 = (ImageView) findViewById(R.id._back_arrow_ek3);
	
		
		_rectangle_21_ek1.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), verification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_use_email_instead__.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), signin_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_back_arrow_ek3.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), starting_page_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	