
	 
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

public class extra_page__activity extends Activity {

	
	private View _bg__extra_page__ek2;
	private View rectangle_1;
	private View rectangle_2;
	private View rectangle_3;
	private View rectangle_4;
	private View rectangle_5;
	private View rectangle_6;
	private TextView customer_care;
	private TextView payment_options;
	private TextView reviews;
	private TextView delete_account;
	private View rectangle_26;
	private TextView next;
	private TextView _986238999;
	private ImageView order_history;
	private ImageView customer_support;
	private ImageView popular;
	private ImageView contacts;
	private TextView service_history;
	private ImageView _card_payment;
	private TextView log_out;
	private ImageView vector;
	private TextView home;
	private TextView notification;
	private TextView call;
	private TextView setting;
	private ImageView vector_ek1;
	private ImageView vector_ek2;
	private ImageView _vector_ek3;
	private ImageView vector_ek4;
	private ImageView _vector_ek5;
	private ImageView _vector_ek6;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.extra_page_);

		
		rectangle_1 = (View) findViewById(R.id.rectangle_1);

		customer_care = (TextView) findViewById(R.id.customer_care);
		payment_options = (TextView) findViewById(R.id.payment_options);
		reviews = (TextView) findViewById(R.id.reviews);
		delete_account = (TextView) findViewById(R.id.delete_account);


		_986238999 = (TextView) findViewById(R.id._986238999);
		order_history = (ImageView) findViewById(R.id.order_history);
		customer_support = (ImageView) findViewById(R.id.customer_support);
		popular = (ImageView) findViewById(R.id.popular);
		contacts = (ImageView) findViewById(R.id.contacts);
		service_history = (TextView) findViewById(R.id.service_history);
		_card_payment = (ImageView) findViewById(R.id._card_payment);
		log_out = (TextView) findViewById(R.id.log_out);
		vector = (ImageView) findViewById(R.id.vector);
		home = (TextView) findViewById(R.id.home);
		notification = (TextView) findViewById(R.id.notification);
		call = (TextView) findViewById(R.id.call);
		setting = (TextView) findViewById(R.id.setting);
		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);

		vector_ek4 = (ImageView) findViewById(R.id.vector_ek4);
		_vector_ek5 = (ImageView) findViewById(R.id._vector_ek5);
		_vector_ek6 = (ImageView) findViewById(R.id._vector_ek6);
	
		
		_card_payment.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), payment_options_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek3.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek5.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek6.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	