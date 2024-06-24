package com.example.clientpanel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class more_option_activity extends BottomSheetDialogFragment {
	private TextView _add_bike;
	private TextView _add_scooter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Set the dialog's background to transparent
		getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		View rootView = inflater.inflate(R.layout.more_option, container, false);

		_add_bike = rootView.findViewById(R.id._add_bike);
		_add_scooter = rootView.findViewById(R.id._add_scooter);

		_add_bike.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), vehicle_info_activity.class);
				startActivity(intent);
				dismiss(); // Dismiss the bottom sheet after starting the activity
			}
		});

		_add_scooter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), vehicle_info_activity.class);
				startActivity(intent);
				dismiss(); // Dismiss the bottom sheet after starting the activity
			}
		});

		rootView.findViewById(R.id.dismiss).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss(); // Dismiss the bottom sheet
			}
		});

		return rootView;
	}
}
