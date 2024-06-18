
	 
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

public class landing_home_page_1_activity extends Activity {

	
	private View _bg__landing_home_page_1_ek2;
	private View rectangle_1_ek10;
	private TextView hi;
	private TextView garage_doc_ek6;
	private View rectangle_37;
	private ImageView repair_removebg_preview_1;
	private TextView services_ek3;
	private ImageView vector_ek118;
	private TextView emergency;
	private ImageView vector_ek119;
	private ImageView vector_ek120;
	private ImageView vector_ek121;
	private TextView add_vehicles_ek1;
	private TextView bookings;
	private TextView home_ek17;
	private TextView notification_ek24;
	private TextView call_ek18;
	private TextView setting_ek17;
	private ImageView vector_ek122;
	private ImageView vector_ek123;
	private ImageView vector_ek124;
	private ImageView vector_ek125;
	private ImageView _vector_ek126;
	private ImageView _vector_ek127;
	private ImageView vector_ek128;
	private ImageView vector_ek129;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.landing_home_page_1);

		
		_bg__landing_home_page_1_ek2 = (View) findViewById(R.id._bg__landing_home_page_1_ek2);
		rectangle_1_ek10 = (View) findViewById(R.id.rectangle_1_ek10);
		hi = (TextView) findViewById(R.id.hi);
		garage_doc_ek6 = (TextView) findViewById(R.id.garage_doc_ek6);
		rectangle_37 = (View) findViewById(R.id.rectangle_37);
		repair_removebg_preview_1 = (ImageView) findViewById(R.id.repair_removebg_preview_1);
		services_ek3 = (TextView) findViewById(R.id.services_ek3);
		vector_ek118 = (ImageView) findViewById(R.id.vector_ek118);
		emergency = (TextView) findViewById(R.id.emergency);
		vector_ek119 = (ImageView) findViewById(R.id.vector_ek119);
		vector_ek120 = (ImageView) findViewById(R.id.vector_ek120);
		vector_ek121 = (ImageView) findViewById(R.id.vector_ek121);
		add_vehicles_ek1 = (TextView) findViewById(R.id.add_vehicles_ek1);
		bookings = (TextView) findViewById(R.id.bookings);
		home_ek17 = (TextView) findViewById(R.id.home_ek17);
		notification_ek24 = (TextView) findViewById(R.id.notification_ek24);
		call_ek18 = (TextView) findViewById(R.id.call_ek18);
		setting_ek17 = (TextView) findViewById(R.id.setting_ek17);
		vector_ek122 = (ImageView) findViewById(R.id.vector_ek122);
		vector_ek123 = (ImageView) findViewById(R.id.vector_ek123);
		vector_ek124 = (ImageView) findViewById(R.id.vector_ek124);
		vector_ek125 = (ImageView) findViewById(R.id.vector_ek125);
		_vector_ek126 = (ImageView) findViewById(R.id._vector_ek126);
		_vector_ek127 = (ImageView) findViewById(R.id._vector_ek127);
		vector_ek128 = (ImageView) findViewById(R.id.vector_ek128);
		vector_ek129 = (ImageView) findViewById(R.id.vector_ek129);
	
		
		_vector_ek126.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_vector_ek127.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	