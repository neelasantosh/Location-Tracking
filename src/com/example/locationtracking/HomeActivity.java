package com.example.locationtracking;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends Activity implements LocationListener
{
	TextView textLoc;
	Button buttonMap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		textLoc = (TextView) findViewById(R.id.textView1);
		buttonMap = (Button) findViewById(R.id.button1);
		
		LocationManager locM=(LocationManager) getSystemService(LOCATION_SERVICE);
		
		//set location listener
		locM.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 1000, HomeActivity.this);
	}
	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		double lat = location.getLatitude();
		double lon = location.getLongitude();
		textLoc.setText(lat + "," +lon);
		buttonMap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentBrowse = new Intent();
				intentBrowse.setAction("android.intent.action.VIEW");
				
				//pass url to browser
				 String data="https://www.google.co.in/maps/@"+textLoc.getText().toString()+",13z";
				 Uri u= Uri.parse(data);
				 intentBrowse.setData(u);
				
				
				startActivity(intentBrowse);
			}
		});
		
	}
	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
}
