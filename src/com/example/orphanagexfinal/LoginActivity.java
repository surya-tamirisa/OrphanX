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

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		final TextView tve=(TextView)findViewById(R.id.textView1);
		final TextView tvp=(TextView)findViewById(R.id.textView2);
		final EditText emailt=(EditText)findViewById(R.id.editText1);
		final EditText passt=(EditText)findViewById(R.id.editText2);
		final Button log=(Button)findViewById(R.id.button1);
		
		
		 
		
		log.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				final String email = emailt.getText().toString(); 
				final String pass = passt.getText().toString();
				DatabaseHandler dbh =new DatabaseHandler(getApplicationContext());
				int res=dbh.checkLogin(email,pass);
				//Toast.makeText(getApplicationContext(), email  + " " + pass, 1000).show();
				if(res==1)
				{
					Toast.makeText(getApplicationContext(), "Succesful", 1000).show();
					Intent it=new Intent(LoginActivity.this,Need.class);
					it.putExtra("id",email);
					it.putExtra("pass",pass);
				    startActivity(it);
				}
				
				else
				{
					Toast.makeText(getApplicationContext(), "Failed", 1000).show();
				}
			}
		});
		
		
	        
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

}
