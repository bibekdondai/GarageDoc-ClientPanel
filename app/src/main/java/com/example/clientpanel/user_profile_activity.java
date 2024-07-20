
	 
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

public class user_profile_activity extends Activity {

	
	private View _bg__user_profile_ek2;
	private ImageView rectangle_1_ek9;
	private ImageView vector_ek111;
	private TextView user_profile_ek3;
	private TextView garage_doc_ek5;
	private View rectangle_2_ek5;
	private View rectangle_3_ek2;
	private View rectangle_4_ek2;
	private View rectangle_5_ek5;
	private View rectangle_6_ek5;
	private View rectangle_7_ek3;
	private TextView enter_your_full_name;
	private TextView enter_your_email;
	private TextView phone_number;
	private TextView enter_your_address;
	private TextView enter_your_gender;
	private TextView what_is_your_date_of_birth_;
	private ImageView mapppp_removebg_preview_1;
	private View line_1;
	private ImageView name;
	private ImageView post;
	private ImageView home_address;
	private ImageView toilet;
	private ImageView pay_date;
	private View _rectangle_8;
	private TextView update_profile;
	private TextView home_ek16;
	private TextView notification_ek23;
	private TextView call_ek17;
	private TextView setting_ek16;
	private ImageView vector_ek112;
	private ImageView vector_ek113;
	private ImageView _vector_ek114;
	private ImageView vector_ek115;
	private ImageView _vector_ek116;
	private ImageView _vector_ek117;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_profile);

		


		vector_ek111 = (ImageView) findViewById(R.id.vector_ek111);
		user_profile_ek3 = (TextView) findViewById(R.id.user_profile_ek3);
		garage_doc_ek5 = (TextView) findViewById(R.id.garage_doc_ek5);
		rectangle_2_ek5 = (View) findViewById(R.id.rectangle_2_ek5);
		rectangle_3_ek2 = (View) findViewById(R.id.rectangle_3_ek2);
		rectangle_4_ek2 = (View) findViewById(R.id.rectangle_4_ek2);
		rectangle_5_ek5 = (View) findViewById(R.id.rectangle_5_ek5);
		rectangle_6_ek5 = (View) findViewById(R.id.rectangle_6_ek5);
		rectangle_7_ek3 = (View) findViewById(R.id.rectangle_7_ek3);
		enter_your_full_name = (TextView) findViewById(R.id.enter_your_full_name);
		enter_your_email = (TextView) findViewById(R.id.enter_your_email);
		phone_number = (TextView) findViewById(R.id.phone_number);
		enter_your_address = (TextView) findViewById(R.id.enter_your_address);
		enter_your_gender = (TextView) findViewById(R.id.enter_your_gender);
		what_is_your_date_of_birth_ = (TextView) findViewById(R.id.what_is_your_date_of_birth_);
		mapppp_removebg_preview_1 = (ImageView) findViewById(R.id.mapppp_removebg_preview_1);

		name = (ImageView) findViewById(R.id.name);
		post = (ImageView) findViewById(R.id.post);
		home_address = (ImageView) findViewById(R.id.home_address);
		toilet = (ImageView) findViewById(R.id.toilet);
		pay_date = (ImageView) findViewById(R.id.pay_date);
		_rectangle_8 = (View) findViewById(R.id._rectangle_8);
		update_profile = (TextView) findViewById(R.id.update_profile);

	
		
		_rectangle_8.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek114.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek116.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek117.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	