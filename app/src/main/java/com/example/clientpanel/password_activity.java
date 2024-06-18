
	 
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
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;

public class password_activity extends Activity {

	
	private View _bg__password_ek2;
	private ImageView ellipse_4;
	private View _rectangle_24_ek1;
	private TextView login;
	private TextView forgot_password__;
	private View line_14;
	private TextView password_ek4;
	private TextView enter_your_password_for_login;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.password);

		
		_bg__password_ek2 = (View) findViewById(R.id._bg__password_ek2);
		ellipse_4 = (ImageView) findViewById(R.id.ellipse_4);
		_rectangle_24_ek1 = (View) findViewById(R.id._rectangle_24_ek1);
		login = (TextView) findViewById(R.id.login);
		forgot_password__ = (TextView) findViewById(R.id.forgot_password__);
		line_14 = (View) findViewById(R.id.line_14);
		password_ek4 = (TextView) findViewById(R.id.password_ek4);
		enter_your_password_for_login = (TextView) findViewById(R.id.enter_your_password_for_login);
	
		
		_rectangle_24_ek1.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), info_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	