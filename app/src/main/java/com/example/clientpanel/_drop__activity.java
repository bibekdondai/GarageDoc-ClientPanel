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

public class _drop__activity extends AppCompatActivity implements OnMapReadyCallback {
	private final int FINE_PERMISSION_CODE = 1;

	private GoogleMap myMap;
	Location currentLocation;
	FusedLocationProviderClient fusedLocationProviderClient;
	TextView latLongTextView;
	Spinner mapTypeSpinner;
	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout._drop_);

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
					mapFragment.getMapAsync(_drop__activity.this);
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
