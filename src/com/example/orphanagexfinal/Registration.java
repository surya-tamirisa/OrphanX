package com.example.orphanagexfinal;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		final EditText em=(EditText)findViewById(R.id.email	);
		final EditText ps=(EditText)findViewById(R.id.pass);
		final EditText nm=(EditText)findViewById(R.id.name);
		final EditText ph=(EditText)findViewById(R.id.phno);
		final EditText ad=(EditText)findViewById(R.id.addr);
		final EditText ned=(EditText)findViewById(R.id.need);
		final EditText ch=(EditText)findViewById(R.id.child);
		final EditText cty=(EditText)findViewById(R.id.city);
		Button reg=(Button)findViewById(R.id.button1);
		reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				
				final String name = nm.getText().toString(); 
				final String pass = ps.getText().toString(); 
				final String email = em.getText().toString(); 
				final String address = ad.getText().toString(); 
				final String need = ned.getText().toString(); 
				final int children =Integer.parseInt(ch.getText().toString()) ; 
				final String city = cty.getText().toString(); 
				final int phno = Integer.parseInt(ph.getText().toString()); 
				
				DatabaseHandler dbh =new DatabaseHandler(getApplicationContext());
				Orp o1=new Orp(email,pass,name,phno,address,children,city,need);
				dbh.addOrp(o1);
				Toast.makeText(getApplicationContext(), "Successfully Registered",Toast.LENGTH_SHORT).show();


				Intent it=new Intent(Registration.this,MainActivity.class);
				startActivity(it);
			}
		});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_registration, menu);
		return true;
	}

}
