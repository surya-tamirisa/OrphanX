package com.example.orphanagexfinal;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;




public class DispList extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_displist);
		Bundle bundle = getIntent().getExtras();
	    final String city = bundle.getString("city");
	//private static final int Orp = 0;
	ListView lv=(ListView) findViewById(R.id.list);
	DatabaseHandler db=new DatabaseHandler(getApplicationContext());
	List<Orp> list1 =db.getAllOrphanages(city);
	

	// get data from the table by the ListAdapter
	OrpAdapter customAdapter = new OrpAdapter(this, R.layout.row, list1);

	lv.setAdapter(customAdapter);
}}
