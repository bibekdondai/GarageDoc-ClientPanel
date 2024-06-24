
	 
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

public class add_bike_scooter_activity extends Activity {

	
	private View _bg__add_bike_scooter_ek2;
	private TextView ca_ek1;
	private View rectangle_1_ek5;
	private TextView garage_doc_ek2;
	private View rectangle_93_ek1;
	private View rectangle_94;
	private View rectangle_95;
	private View rectangle_96;
	private TextView yamaha_alpha;
	private TextView yamaha_fascino;
	private TextView yamaha_mt_15;
	private TextView yamaha_fzs;
	private TextView home_ek8;
	private TextView notification_ek15;
	private TextView call_ek9;
	private TextView setting_ek8;
	private ImageView vector_ek58;
	private ImageView vector_ek59;
	private ImageView _vector_ek60;
	private ImageView vector_ek61;
	private ImageView _vector_ek62;
	private ImageView _vector_ek63;
	private ImageView _back_arrow_ek1;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_bike_scooter);

		
		_bg__add_bike_scooter_ek2 = (View) findViewById(R.id._bg__add_bike_scooter_ek2);
		rectangle_1_ek5 = (View) findViewById(R.id.rectangle_1_ek5);
		garage_doc_ek2 = (TextView) findViewById(R.id.garage_doc_ek2);
		rectangle_93_ek1 = (View) findViewById(R.id.rectangle_93_ek1);

		yamaha_alpha = (TextView) findViewById(R.id.yamaha_alpha);

		vector_ek58 = (ImageView) findViewById(R.id.vector_ek58);
		vector_ek59 = (ImageView) findViewById(R.id.vector_ek59);
		_vector_ek60 = (ImageView) findViewById(R.id._vector_ek60);
		vector_ek61 = (ImageView) findViewById(R.id.vector_ek61);
		_vector_ek62 = (ImageView) findViewById(R.id._vector_ek62);
		_vector_ek63 = (ImageView) findViewById(R.id._vector_ek63);
		_back_arrow_ek1 = (ImageView) findViewById(R.id._back_arrow_ek1);
	
		
		_vector_ek60.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek62.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek63.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_back_arrow_ek1.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), vehicle_info_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	