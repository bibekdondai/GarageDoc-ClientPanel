
	 
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

public class pickup_activity extends Activity {

	
	private View _bg__pickup_ek2;
	private View rectangle_2_ek4;
	private View rectangle_28_ek2;
	private View rectangle_29_ek2;
	private TextView confirm_location_ek2;
	private ImageView maps_removebg_preview_1_ek2;
	private TextView choose_from_map_ek2;
	private ImageView rectangle_32;
	private TextView address_street_name_ek2;
	private TextView home_ek13;
	private TextView notification_ek20;
	private TextView call_ek14;
	private TextView setting_ek13;
	private ImageView vector_ek93;
	private ImageView vector_ek94;
	private ImageView _vector_ek95;
	private ImageView vector_ek96;
	private ImageView _vector_ek97;
	private ImageView _vector_ek98;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.pickup);

		
		_bg__pickup_ek2 = (View) findViewById(R.id._bg__pickup_ek2);
		rectangle_2_ek4 = (View) findViewById(R.id.rectangle_2_ek4);
		rectangle_28_ek2 = (View) findViewById(R.id.rectangle_28_ek2);
		rectangle_29_ek2 = (View) findViewById(R.id.rectangle_29_ek2);
		confirm_location_ek2 = (TextView) findViewById(R.id.confirm_location_ek2);

		choose_from_map_ek2 = (TextView) findViewById(R.id.choose_from_map_ek2);
		rectangle_32 = (ImageView) findViewById(R.id.rectangle_32);
		address_street_name_ek2 = (TextView) findViewById(R.id.address_street_name_ek2);

		_vector_ek95 = (ImageView) findViewById(R.id._vector_ek95);
		vector_ek96 = (ImageView) findViewById(R.id.vector_ek96);
		_vector_ek97 = (ImageView) findViewById(R.id._vector_ek97);
		_vector_ek98 = (ImageView) findViewById(R.id._vector_ek98);
	
		
		_vector_ek95.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek97.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek98.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	