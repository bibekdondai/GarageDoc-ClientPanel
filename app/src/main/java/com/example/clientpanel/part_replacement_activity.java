
	 
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
import android.content.Intent;
import android.widget.ImageView;

public class part_replacement_activity extends Activity {

	
	private View _bg__part_replacement_ek2;
	private View rectangle_65_ek2;
	private TextView choose_parts_ek1;
	private View rectangle_68_ek2;
	private View rectangle_69_ek2;
	private View rectangle_70_ek2;
	private View rectangle_71_ek1;
	private View rectangle_66_ek2;
	private View rectangle_67_ek2;
	private View rectangle_72_ek1;
	private View rectangle_73_ek1;
	private View _rectangle_74_ek1;
	private TextView confirm_ek2;
	private ImageView vector_ek92;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.part_replacement);

		
		_bg__part_replacement_ek2 = (View) findViewById(R.id._bg__part_replacement_ek2);
		rectangle_65_ek2 = (View) findViewById(R.id.rectangle_65_ek2);
		choose_parts_ek1 = (TextView) findViewById(R.id.choose_parts_ek1);
		rectangle_68_ek2 = (View) findViewById(R.id.rectangle_68_ek2);
		rectangle_69_ek2 = (View) findViewById(R.id.rectangle_69_ek2);
		rectangle_70_ek2 = (View) findViewById(R.id.rectangle_70_ek2);
		rectangle_71_ek1 = (View) findViewById(R.id.rectangle_71_ek1);
		rectangle_66_ek2 = (View) findViewById(R.id.rectangle_66_ek2);
		rectangle_67_ek2 = (View) findViewById(R.id.rectangle_67_ek2);
		rectangle_72_ek1 = (View) findViewById(R.id.rectangle_72_ek1);
		rectangle_73_ek1 = (View) findViewById(R.id.rectangle_73_ek1);
		_rectangle_74_ek1 = (View) findViewById(R.id._rectangle_74_ek1);
		confirm_ek2 = (TextView) findViewById(R.id.confirm_ek2);
		vector_ek92 = (ImageView) findViewById(R.id.vector_ek92);
	
		
		_rectangle_74_ek1.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), services_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	