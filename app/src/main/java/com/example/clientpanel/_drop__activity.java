
	 
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

public class _drop__activity extends Activity {

	
	private View _bg____drop__ek2;
	private View rectangle_2_ek3;
	private View rectangle_27;
	private View rectangle_28_ek1;
	private View rectangle_29_ek1;
	private TextView choose_from_map_ek1;
	private TextView confirm_location_ek1;
	private TextView address_street_name_ek1;
	private ImageView maps_removebg_preview_1_ek1;
	private TextView home_ek12;
	private TextView notification_ek19;
	private TextView call_ek13;
	private TextView setting_ek12;
	private ImageView vector_ek82;
	private ImageView vector_ek83;
	private ImageView _vector_ek84;
	private ImageView vector_ek85;
	private ImageView _vector_ek86;
	private ImageView _vector_ek87;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout._drop_);

		
//		_bg____drop__ek2 = (View) findViewById(R.id._bg____drop__ek2);
		rectangle_2_ek3 = (View) findViewById(R.id.rectangle_2_ek3);
		rectangle_27 = (View) findViewById(R.id.rectangle_27);
		rectangle_28_ek1 = (View) findViewById(R.id.rectangle_28_ek1);
		rectangle_29_ek1 = (View) findViewById(R.id.rectangle_29_ek1);
		choose_from_map_ek1 = (TextView) findViewById(R.id.choose_from_map_ek1);
		confirm_location_ek1 = (TextView) findViewById(R.id.confirm_location_ek1);
		address_street_name_ek1 = (TextView) findViewById(R.id.address_street_name_ek1);
//		maps_removebg_preview_1_ek1 = (ImageView) findViewById(R.id.maps_removebg_preview_1_ek1);
//		home_ek12 = (TextView) findViewById(R.id.home_ek12);
//		notification_ek19 = (TextView) findViewById(R.id.notification_ek19);
//		call_ek13 = (TextView) findViewById(R.id.call_ek13);
//		setting_ek12 = (TextView) findViewById(R.id.setting_ek12);
		vector_ek82 = (ImageView) findViewById(R.id.vector_ek82);
//		vector_ek83 = (ImageView) findViewById(R.id.vector_ek83);
//		_vector_ek84 = (ImageView) findViewById(R.id._vector_ek84);
		vector_ek85 = (ImageView) findViewById(R.id.vector_ek85);
		_vector_ek86 = (ImageView) findViewById(R.id._vector_ek86);
		_vector_ek87 = (ImageView) findViewById(R.id._vector_ek87);
	
		
		_vector_ek84.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek86.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek87.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	