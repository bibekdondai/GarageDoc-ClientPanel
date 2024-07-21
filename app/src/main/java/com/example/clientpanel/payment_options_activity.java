
	 
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

public class payment_options_activity extends Activity {

	
	private View _bg__payment_options_ek3;
	private View rectangle_1_ek6;
	private TextView payment_methods;
	private View rectangle_2_ek2;
	private View rectangle_3_ek1;
	private View rectangle_4_ek1;
	private View rectangle_5_ek4;
	private View rectangle_6_ek4;
	private TextView esewa;
	private ImageView esewa_logo_1;
	private TextView khalti;
	private ImageView khalti_ek1;
	private TextView ime_pay;
	private ImageView ime_pay_ek1;
	private TextView bank;
	private ImageView bank_ek1;
	private TextView cash_on_delivery;
	private ImageView cash_on_delivery_ek1;
	private View rectangle_26_ek1;
	private TextView next_ek1;
	private ImageView _back_arrow_ek2;
	private TextView home_ek9;
	private TextView notification_ek16;
	private TextView call_ek10;
	private TextView setting_ek9;
	private ImageView vector_ek64;
	private ImageView vector_ek65;
	private ImageView _vector_ek66;
	private ImageView vector_ek67;
	private ImageView _vector_ek68;
	private ImageView _vector_ek69;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment_options);

		

		rectangle_1_ek6 = (View) findViewById(R.id.rectangle_1_ek6);
		payment_methods = (TextView) findViewById(R.id.payment_methods);
		rectangle_2_ek2 = (View) findViewById(R.id.rectangle_2_ek2);
		rectangle_3_ek1 = (View) findViewById(R.id.rectangle_3_ek1);
		rectangle_4_ek1 = (View) findViewById(R.id.rectangle_4_ek1);
		rectangle_5_ek4 = (View) findViewById(R.id.rectangle_5_ek4);
		rectangle_6_ek4 = (View) findViewById(R.id.rectangle_6_ek4);
		esewa = (TextView) findViewById(R.id.esewa);
		esewa_logo_1 = (ImageView) findViewById(R.id.esewa_logo_1);
		khalti = (TextView) findViewById(R.id.khalti);
		khalti_ek1 = (ImageView) findViewById(R.id.khalti_ek1);
		ime_pay = (TextView) findViewById(R.id.ime_pay);
		ime_pay_ek1 = (ImageView) findViewById(R.id.ime_pay_ek1);
		bank = (TextView) findViewById(R.id.bank);
		bank_ek1 = (ImageView) findViewById(R.id.bank_ek1);
		cash_on_delivery = (TextView) findViewById(R.id.cash_on_delivery);
		cash_on_delivery_ek1 = (ImageView) findViewById(R.id.cash_on_delivery_ek1);

		_back_arrow_ek2 = (ImageView) findViewById(R.id._back_arrow_ek2);

		vector_ek64 = (ImageView) findViewById(R.id.vector_ek64);

		vector_ek67 = (ImageView) findViewById(R.id.vector_ek67);
		_vector_ek68 = (ImageView) findViewById(R.id._vector_ek68);
		_vector_ek69 = (ImageView) findViewById(R.id._vector_ek69);
	
		
		_back_arrow_ek2.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), details_to_be_filled_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek66.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek68.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek69.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	