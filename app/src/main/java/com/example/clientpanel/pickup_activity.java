//
//
//	/*
//	 *	This content is generated from the API File Info.
//	 *	(Alt+Shift+Ctrl+I).
//	 *
//	 *	@desc
//	 *	@file 		extra_page_
//	 *	@date 		Monday 17th of June 2024 06:12:58 PM
//	 *	@title 		Page 1
//	 *	@author
//	 *	@keywords
//	 *	@generator 	Export Kit v1.3.figma
//	 *
//	 */
//
//
//	package com.example.clientpanel;
//import android.app.Activity;
//import android.os.Bundle;
//
//
//import android.view.View;
//import android.widget.TextView;
//import android.widget.ImageView;
//import android.content.Intent;
//
//public class pickup_activity extends Activity {
//
//
//	private View _bg__pickup_ek2;
//	private View rectangle_2_ek4;
//	private View rectangle_28_ek2;
//	private View rectangle_29_ek2;
//	private TextView confirm_location_ek2;
//	private ImageView maps_removebg_preview_1_ek2;
//	private TextView choose_from_map_ek2;
//	private ImageView rectangle_32;
//	private TextView address_street_name_ek2;
//	private TextView home_ek13;
//	private TextView notification_ek20;
//	private TextView call_ek14;
//	private TextView setting_ek13;
//	private ImageView vector_ek93;
//	private ImageView vector_ek94;
//	private ImageView _vector_ek95;
//	private ImageView vector_ek96;
//	private ImageView _vector_ek97;
//	private ImageView _vector_ek98;
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.pickup);
//
//
//		_bg__pickup_ek2 = (View) findViewById(R.id._bg__pickup_ek2);
//		rectangle_2_ek4 = (View) findViewById(R.id.rectangle_2_ek4);
//		rectangle_28_ek2 = (View) findViewById(R.id.rectangle_28_ek2);
//		rectangle_29_ek2 = (View) findViewById(R.id.rectangle_29_ek2);
//		confirm_location_ek2 = (TextView) findViewById(R.id.confirm_location_ek2);
//
//		choose_from_map_ek2 = (TextView) findViewById(R.id.choose_from_map_ek2);
////		address_street_name_ek2 = (TextView) findViewById(R.id.address_street_name_ek2);
//
//		_vector_ek95 = (ImageView) findViewById(R.id.vector_ek46);
//		vector_ek96 = (ImageView) findViewById(R.id.vector_ek49);
//		_vector_ek97 = (ImageView) findViewById(R.id._vector_ek50);
//		_vector_ek98 = (ImageView) findViewById(R.id._vector_ek51);
//
//
//		_vector_ek95.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				Intent nextScreen = new Intent(getApplicationContext(), landing_home_page_1_activity.class);
//				startActivity(nextScreen);
//
//
//			}
//		});
//
//
//		_vector_ek97.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				Intent nextScreen = new Intent(getApplicationContext(), settings_activity.class);
//				startActivity(nextScreen);
//
//
//			}
//		});
//
//
//		_vector_ek98.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
//				startActivity(nextScreen);
//
//
//			}
//		});
//
//
//		//custom code goes here
//
//	}
//}
//


package com.example.clientpanel;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class pickup_activity extends AppCompatActivity implements OnMapReadyCallback {
	private final int FINE_PERMISSION_CODE = 1;

	private GoogleMap myMap;
	Location currentLocation;
	FusedLocationProviderClient fusedLocationProviderClient;
	TextView latLongTextView;
	Spinner mapTypeSpinner;
	private static final String TAG = "pickup.xml";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pickup);

		latLongTextView = findViewById(R.id.lat_long_text);
		mapTypeSpinner = findViewById(R.id.map_type_spinner);
		fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

		setupMapTypeSpinner();
		getLastLocation();
	}

	private void setupMapTypeSpinner() {
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.map_types, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mapTypeSpinner.setAdapter(adapter);
		mapTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				if (myMap != null) {
					switch (position) {
						case 0:
							myMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
							break;
						case 1:
							myMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
							break;
						case 2:
							myMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
							break;
						case 3:
							myMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
							break;
						default:
							myMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
							break;
					}
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// Do nothing
			}
		});
	}

	private void getLastLocation() {
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, FINE_PERMISSION_CODE);
			return;
		}
		Task<Location> task = fusedLocationProviderClient.getLastLocation();
		task.addOnSuccessListener(new OnSuccessListener<Location>() {
			@Override
			public void onSuccess(Location location) {
				if (location != null) {
					currentLocation = location;
					SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
					mapFragment.getMapAsync(pickup_activity.this);
				}
			}
		});
	}

	@Override
	public void onMapReady(@NonNull GoogleMap googleMap) {
		myMap = googleMap;
		LatLng currentLatLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
		myMap.addMarker(new MarkerOptions().position(currentLatLng).title("My Location"));


		float zoomLevel = 15.0f;
		myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, zoomLevel));

		String latLongText = "Latitude: " + currentLocation.getLatitude() + ", Longitude: " + currentLocation.getLongitude();
		latLongTextView.setText(latLongText);

		Log.d(TAG, latLongText);
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == FINE_PERMISSION_CODE) {
			if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				getLastLocation();
			} else {
				Toast.makeText(this, "Location Permission is denied. Please allow it.", Toast.LENGTH_SHORT).show();
			}
		}
	}
}
