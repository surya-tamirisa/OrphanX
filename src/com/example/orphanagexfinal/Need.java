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

public class Need extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_need);
		Bundle bundle = getIntent().getExtras();
		final String email = bundle.getString("id");
		final String ps = bundle.getString("pass");
		final EditText need1=(EditText)findViewById(R.id.editText1);
		final EditText cld1=(EditText)findViewById(R.id.editText2);
		final TextView tv1=(TextView)findViewById(R.id.textView1);
		final TextView tv2=(TextView)findViewById(R.id.textView2);
		final Button save=(Button)findViewById(R.id.button1);
		
		
	    save.setOnClickListener(new OnClickListener() {
		//Bundle bundle = getIntent().getExtras();
	//final String email = bundle.getString("id");
	//final String ps = bundle.getString("pass");
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			final String need=need1.getText().toString();
			final String cld=cld1.getText().toString();
		    final int child=Integer.parseInt(cld);
			DatabaseHandler dbh=new DatabaseHandler(getApplicationContext());
			dbh.edit(need,child,email,ps);
			Toast.makeText(getApplicationContext(), "Succesfully changed", 1000).show();
			//Toast.makeText(getApplicationContext(), cld, 1000).show();
			//Toast.makeText(getApplicationContext(), need, 1000).show();
			//Toast.makeText(getApplicationContext(), email, 1000).show();
			//Toast.makeText(getApplicationContext(), ps, 1000).show();
			dbh.edit(need, child, email, ps);
			Intent it=new Intent(Need.this,MainActivity.class);
			startActivity(it);
			
		}
	});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_need, menu);
		return true;
	}

}
