/*
 * This content is generated from the API File Info.
 * (Alt+Shift+Ctrl+I).
 *
 * @desc
 * @file        extra_page_
 * @date        Monday 17th of June 2024 06:12:58 PM
 * @title       Page 1
 * @author
 * @keywords
 * @generator   Export Kit v1.3.figma
 *
 */

package com.example.clientpanel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class starting_page_activity extends Activity {

	private View _bg__starting_page_ek2;
	private View line_16;
	private TextView _enter_your_mail;
	private View line_17;
	private TextView get_started_with;
	private ImageView ellipse_1;
	private TextView garage_doc_ek7;
	private ImageView black_and_white_modern_typographic_simple_virus_apparel_logo__1__1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting_page);

		// Initialize views
		_bg__starting_page_ek2 = findViewById(R.id._bg__starting_page_ek2);
		line_16 = findViewById(R.id.line_16);
		_enter_your_mail = findViewById(R.id._enter_your_mail);
		line_17 = findViewById(R.id.line_17);
		get_started_with = findViewById(R.id.get_started_with);
		ellipse_1 = findViewById(R.id.ellipse_1);
		garage_doc_ek7 = findViewById(R.id.garage_doc_ek7);
		black_and_white_modern_typographic_simple_virus_apparel_logo__1__1 = findViewById(R.id.black_and_white_modern_typographic_simple_virus_apparel_logo__1__1);

		// Set click listener for entering email
		_enter_your_mail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(starting_page_activity.this, signin_1_activity.class);

				startActivity(intent);

			}
		});

		// Custom code can be added here as needed
	}
}
