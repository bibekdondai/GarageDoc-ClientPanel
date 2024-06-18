
	 
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

public class receipt_activity extends Activity {

	
	private View _bg__receipt_ek2;
	private TextView _10_59;
	private ImageView wi_fi;
	private ImageView empty_battery;
	private ImageView signal;
	private View rectangle_84;
	private View rectangle_86;
	private View rectangle_87;
	private View rectangle_89;
	private TextView name_;
	private View rectangle_90;
	private View rectangle_91;
	private TextView drop_vehicle_to_my_location_;
	private View rectangle_88;
	private TextView receipt_ek3;
	private TextView bill_no_;
	private TextView date_;
	private TextView vehicle_name_;
	private TextView home_ek10;
	private TextView notification_ek17;
	private TextView call_ek11;
	private TextView setting_ek10;
	private ImageView vector_ek70;
	private ImageView vector_ek71;
	private ImageView _vector_ek72;
	private ImageView vector_ek73;
	private ImageView _vector_ek74;
	private ImageView _vector_ek75;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.receipt);

		
		_bg__receipt_ek2 = (View) findViewById(R.id._bg__receipt_ek2);
		_10_59 = (TextView) findViewById(R.id._10_59);
		wi_fi = (ImageView) findViewById(R.id.wi_fi);
		empty_battery = (ImageView) findViewById(R.id.empty_battery);
		signal = (ImageView) findViewById(R.id.signal);
		rectangle_84 = (View) findViewById(R.id.rectangle_84);
		rectangle_86 = (View) findViewById(R.id.rectangle_86);
		rectangle_87 = (View) findViewById(R.id.rectangle_87);
		rectangle_89 = (View) findViewById(R.id.rectangle_89);
		name_ = (TextView) findViewById(R.id.name_);
		rectangle_90 = (View) findViewById(R.id.rectangle_90);
		rectangle_91 = (View) findViewById(R.id.rectangle_91);
		drop_vehicle_to_my_location_ = (TextView) findViewById(R.id.drop_vehicle_to_my_location_);
		rectangle_88 = (View) findViewById(R.id.rectangle_88);
		receipt_ek3 = (TextView) findViewById(R.id.receipt_ek3);
		bill_no_ = (TextView) findViewById(R.id.bill_no_);
		date_ = (TextView) findViewById(R.id.date_);
		vehicle_name_ = (TextView) findViewById(R.id.vehicle_name_);
		home_ek10 = (TextView) findViewById(R.id.home_ek10);
		notification_ek17 = (TextView) findViewById(R.id.notification_ek17);
		call_ek11 = (TextView) findViewById(R.id.call_ek11);
		setting_ek10 = (TextView) findViewById(R.id.setting_ek10);
		vector_ek70 = (ImageView) findViewById(R.id.vector_ek70);
		vector_ek71 = (ImageView) findViewById(R.id.vector_ek71);
		_vector_ek72 = (ImageView) findViewById(R.id._vector_ek72);
		vector_ek73 = (ImageView) findViewById(R.id.vector_ek73);
		_vector_ek74 = (ImageView) findViewById(R.id._vector_ek74);
		_vector_ek75 = (ImageView) findViewById(R.id._vector_ek75);
	
		
		_vector_ek72.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek74.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek75.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	