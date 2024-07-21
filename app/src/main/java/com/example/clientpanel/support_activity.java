
	 
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

public class support_activity extends Activity {

	
	private View _bg__support_ek2;
	private View rectangle_1_ek1;
	private TextView support_ek3;
	private View rectangle_67;
	private ImageView rectangle_68;
	private ImageView rectangle_69;
	private ImageView rectangle_70;
	private ImageView people;
	private ImageView call_ek1;
	private ImageView encrypt;
	private ImageView terms_and_conditions;
	private TextView about_us;
	private TextView terms_and_condition;
	private TextView contact_us;
	private TextView privacy_policy;
	private ImageView _back_arrow;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.support);

		

		rectangle_1_ek1 = (View) findViewById(R.id.rectangle_1_ek1);
		support_ek3 = (TextView) findViewById(R.id.support_ek3);
		rectangle_67 = (View) findViewById(R.id.rectangle_67);
		rectangle_68 = (ImageView) findViewById(R.id.rectangle_68);
		rectangle_69 = (ImageView) findViewById(R.id.rectangle_69);
		rectangle_70 = (ImageView) findViewById(R.id.rectangle_70);
		people = (ImageView) findViewById(R.id.people);
		call_ek1 = (ImageView) findViewById(R.id.call_ek1);
		encrypt = (ImageView) findViewById(R.id.encrypt);
		terms_and_conditions = (ImageView) findViewById(R.id.terms_and_conditions);
		about_us = (TextView) findViewById(R.id.about_us);
		terms_and_condition = (TextView) findViewById(R.id.terms_and_condition);
		contact_us = (TextView) findViewById(R.id.contact_us);
		privacy_policy = (TextView) findViewById(R.id.privacy_policy);
		_back_arrow = (ImageView) findViewById(R.id._back_arrow);
	
		
		_back_arrow.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), vehicle_info_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	