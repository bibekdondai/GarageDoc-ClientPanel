
	 
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
import android.content.Intent;
import android.widget.TextView;

public class verification_activity extends Activity {

	
	private View _bg__verification_ek2;
	private View _rectangle_30_ek1;
	private TextView verify_phone;
	private TextView didn_t_receive_a_code__click;
	private View rectangle_32_ek1;
	private View rectangle_33;
	private View rectangle_34;
	private View rectangle_35;
	private View rectangle_36;
	private TextView a_verification_code_has_been_sent_to_the_phone_number_listed_prior__please_type_in_your_code_below_to_get_started_with_garagedoc_;
	private TextView verification_ek3;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.verification);

		

		_rectangle_30_ek1 = (View) findViewById(R.id._rectangle_30_ek1);
		verify_phone = (TextView) findViewById(R.id.verify_phone);
		didn_t_receive_a_code__click = (TextView) findViewById(R.id.didn_t_receive_a_code__click);
		rectangle_32_ek1 = (View) findViewById(R.id.rectangle_32_ek1);
		rectangle_33 = (View) findViewById(R.id.rectangle_33);
		rectangle_34 = (View) findViewById(R.id.rectangle_34);
		rectangle_35 = (View) findViewById(R.id.rectangle_35);
		rectangle_36 = (View) findViewById(R.id.rectangle_36);
		a_verification_code_has_been_sent_to_the_phone_number_listed_prior__please_type_in_your_code_below_to_get_started_with_garagedoc_ = (TextView) findViewById(R.id.a_verification_code_has_been_sent_to_the_phone_number_listed_prior__please_type_in_your_code_below_to_get_started_with_garagedoc_);
		verification_ek3 = (TextView) findViewById(R.id.verification_ek3);
	
		
		_rectangle_30_ek1.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), password_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	