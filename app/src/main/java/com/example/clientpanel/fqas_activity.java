
	 
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

public class fqas_activity extends Activity {

	
	private View _bg__fqas_ek2;
	private View rectangle_5_ek3;
	private View rectangle_7_ek2;
	private TextView will_i_receive_reminders_for_upcoming_services_;
	private View rectangle_6_ek3;
	private TextView can_i_manage_multiple_vehicles_with_one_account__;
	private TextView faqs;
	private TextView can_i_cancel_a_service_order_;
	private TextView home_ek3;
	private TextView notification_ek10;
	private TextView call_ek4;
	private TextView setting_ek3;
	private ImageView vector_ek19;
	private ImageView vector_ek20;
	private ImageView _vector_ek21;
	private ImageView vector_ek22;
	private ImageView _vector_ek23;
	private ImageView vector_ek24;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.fqas);

		
//		_bg__fqas_ek2 = (View) findViewById(R.id._bg__fqas_ek2);
		rectangle_5_ek3 = (View) findViewById(R.id.rectangle_5_ek3);
		rectangle_7_ek2 = (View) findViewById(R.id.rectangle_7_ek2);
		will_i_receive_reminders_for_upcoming_services_ = (TextView) findViewById(R.id.will_i_receive_reminders_for_upcoming_services_);
		rectangle_6_ek3 = (View) findViewById(R.id.rectangle_6_ek3);
		can_i_manage_multiple_vehicles_with_one_account__ = (TextView) findViewById(R.id.can_i_manage_multiple_vehicles_with_one_account__);
		faqs = (TextView) findViewById(R.id.faqs);
		can_i_cancel_a_service_order_ = (TextView) findViewById(R.id.can_i_cancel_a_service_order_);
//		home_ek3 = (TextView) findViewById(R.id.home_ek3);
//		notification_ek10 = (TextView) findViewById(R.id.notification_ek10);
//		call_ek4 = (TextView) findViewById(R.id.call_ek4);
//		setting_ek3 = (TextView) findViewById(R.id.setting_ek3);
//		vector_ek19 = (ImageView) findViewById(R.id.vector_ek19);
//		vector_ek20 = (ImageView) findViewById(R.id.vector_ek20);
		_vector_ek21 = (ImageView) findViewById(R.id._vector_ek21);
		vector_ek22 = (ImageView) findViewById(R.id.vector_ek22);
		_vector_ek23 = (ImageView) findViewById(R.id._vector_ek23);
//		vector_ek24 = (ImageView) findViewById(R.id.vector_ek24);
	
		
		_vector_ek21.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek23.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	