
	 
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
	
	