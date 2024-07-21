
	 
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


import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;

public class details_to_be_filled_activity extends Activity {


	private View _bg__details_to_be_filled_ek2;
	private View signal_ek1;
	private TextView ca_ek2;
	private TextView vehicle_details_;
	private View line_19;
	private TextView vehicle_number_;
	private TextView text;
	private TextView text_ek1;
	private TextView text_ek2;
	private TextView text_ek3;
	private TextView text_ek4;
	private TextView text_ek6;
	private TextView text_ek7;
	private TextView text_ek9;
	private TextView text_ek10;
	private TextView text_ek12;
	private TextView hhhh;
	private TextView text_ek13;
	private TextView text_ek14;
	private TextView text_ek15;
	private TextView text_ek16;
	private TextView text_ek17;
	private TextView text_ek18;
	private TextView text_ek20;
	private TextView text_ek21;
	private TextView text_ek23;
	private TextView text_ek24;
	private TextView text_ek26;
	private TextView hhhh_ek1;
	private TextView text_ek27;
	private View rectangle_80;
	private View line_20;
	private View rectangle_80_ek1;
	private View rectangle_76_ek1;
	private View rectangle_81;
	private View rectangle_82;
	private TextView cancelled_ek1;
	private TextView pending_ek1;
	private TextView process_ek1;
	private TextView delivered_ek1;
	private View rectangle_92;
	private ImageView image_1;
	private TextView add_part_name___services;
	private TextView changes_to_be_made_from_showroom_side;
	private View _rectangle_60_ek1;
	private TextView pay;
	private TextView home_ek11;
	private TextView notification_ek18;
	private TextView call_ek12;
	private TextView setting_ek11;
	private ImageView vector_ek76;
	private ImageView vector_ek77;
	private ImageView _vector_ek78;
	private ImageView vector_ek79;
	private ImageView _vector_ek80;
	private ImageView _vector_ek81;


	// Inside details_to_be_filled Activity
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details_to_be_filled);

		// Retrieve the TableLayout
		TableLayout upperTable = findViewById(R.id.upper_table);

		// Get data from Intent
		Intent intent = getIntent();
		String[] partNames = intent.getStringArrayExtra("partNames");
		String[] prices = intent.getStringArrayExtra("prices");
		String[] remarks = intent.getStringArrayExtra("remarks");

		// Add rows dynamically
		for (int i = 0; i < partNames.length; i++) {
			TableRow row = new TableRow(this);

			TextView partNameTextView = new TextView(this);
			partNameTextView.setPadding(8, 8, 8, 8);
			partNameTextView.setText(partNames[i]);

			TextView priceTextView = new TextView(this);
			priceTextView.setPadding(8, 8, 8, 8);
			priceTextView.setText(prices[i]);

			TextView remarksTextView = new TextView(this);
			remarksTextView.setPadding(8, 8, 8, 8);
			remarksTextView.setText(remarks[i]);

			row.addView(partNameTextView);
			row.addView(priceTextView);
			row.addView(remarksTextView);

			upperTable.addView(row);
		}
	}
}

