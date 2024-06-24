
	 
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

public class services_activity extends Activity {

	
	private View _bg__services_ek2;
	private View rectangle_1_ek7;
	private TextView garage_doc_ek3;
	private View rectangle_55;
	private View rectangle_57;
	private TextView part_replacement_ek3;
	private View rectangle_56;
	private View rectangle_58;
	private TextView full_servicing;
	private TextView oil_change;
	private TextView part_maintainence_ek3;
	private View rectangle_59;
	private TextView submit;
	private TextView text_ek28;
	private TextView text_ek29;
	private TextView text_ek30;
	private TextView text_ek31;
	private TextView text_ek32;
	private TextView text_ek34;
	private TextView text_ek35;
	private TextView text_ek36;
	private TextView text_ek37;
	private TextView text_ek38;
	private TextView text_ek39;
	private TextView text_ek40;
	private TextView hhhh_ek2;
	private TextView text_ek41;
	private TextView home_ek14;
	private TextView notification_ek21;
	private TextView call_ek15;
	private TextView setting_ek14;
	private ImageView vector_ek99;
	private ImageView vector_ek100;
	private ImageView _vector_ek101;
	private ImageView vector_ek102;
	private ImageView _vector_ek103;
	private ImageView _vector_ek104;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.services);

		
		_bg__services_ek2 = (View) findViewById(R.id._bg__services_ek2);
		rectangle_1_ek7 = (View) findViewById(R.id.rectangle_1_ek7);
		garage_doc_ek3 = (TextView) findViewById(R.id.garage_doc_ek3);
		rectangle_55 = (View) findViewById(R.id.rectangle_55);
		rectangle_57 = (View) findViewById(R.id.rectangle_57);
		part_replacement_ek3 = (TextView) findViewById(R.id.part_replacement_ek3);
		rectangle_56 = (View) findViewById(R.id.rectangle_56);
		rectangle_58 = (View) findViewById(R.id.rectangle_58);
		full_servicing = (TextView) findViewById(R.id.full_servicing);
		oil_change = (TextView) findViewById(R.id.oil_change);
		part_maintainence_ek3 = (TextView) findViewById(R.id.part_maintainence_ek3);
		rectangle_59 = (View) findViewById(R.id.rectangle_59);
		submit = (TextView) findViewById(R.id.submit);

		vector_ek99 = (ImageView) findViewById(R.id.vector_ek99);
		vector_ek100 = (ImageView) findViewById(R.id.vector_ek100);
		_vector_ek101 = (ImageView) findViewById(R.id._vector_ek101);
		vector_ek102 = (ImageView) findViewById(R.id.vector_ek102);
		_vector_ek103 = (ImageView) findViewById(R.id._vector_ek103);
		_vector_ek104 = (ImageView) findViewById(R.id._vector_ek104);
	
		
		_vector_ek101.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek103.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek104.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	