package com.example.orphanagexfinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.SyncStateContract.Constants;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btnShowLocation;
    GPSTracker gps;
    TextView tv1;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1=(TextView)findViewById(R.id.textView3);
		findCity();
		 
		final Button log =(Button)findViewById(R.id.button1);
		final Button reg =(Button)findViewById(R.id.button2);
		final Button find =(Button)findViewById(R.id.button3);
	
		
		log.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent logs = new Intent(MainActivity.this, LoginActivity.class);
		        startActivity(logs);
			}
		});
		
		reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent regs = new Intent(MainActivity.this, Registration.class);
		        startActivity(regs);
				
			}
		});
		find.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//findCity();
				String city=tv1.getText().toString();
				Intent fin = new Intent(MainActivity.this, DispList.class);
				fin.putExtra("city", city);
					startActivity(fin);
				    
				
			}
		});
	}

	   @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.settings , menu);
	        return true;

	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {

	            case R.id.menu_settings:
	                Intent i = new Intent(this, SettingsActivity.class);
	                startActivity(i);
	                break;
	        }

	        return true;
	    }
	    
	   public void findCity()
	    {
	    	   gps = new GPSTracker(MainActivity.this);

	                    // check if GPS enabled
	                    if(gps.canGetLocation()){

	                        double latitude = gps.getLatitude();
	                        double longitude = gps.getLongitude();

	                     //Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
	                        try {
	                            Geocoder gcd = new Geocoder(getApplicationContext(), Locale.getDefault());
	                            List<Address> addresses = gcd.getFromLocation(latitude, longitude, 1);
	                            if (addresses.size() > 0)
	                                //Toast.makeText(getApplicationContext(),addresses.get(0).getLocality(),Toast.LENGTH_SHORT).show();
	                            tv1.setText(addresses.get(0).getLocality());
	                        }catch(Exception o){}
	                    }else{
	                        // can't get location
	                        // GPS or Network is not enabled
	                        // Ask user to enable GPS/network in settings
	                        gps.showSettingsAlert();
	                    }

	    }
	       
}
