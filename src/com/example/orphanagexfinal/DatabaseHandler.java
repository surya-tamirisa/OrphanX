package com.example.orphanagexfinal;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class DatabaseHandler extends SQLiteOpenHelper {
	 
	
    private static final int DATABASE_VERSION = 1;
    //String city_select="Secunderabad";
    // Database Name
    private static final String DATABASE_NAME = "orphanage";
 
    // Contacts table name
    public static final String TABLE_ORP = "orphan";
 
    // Contacts Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_PASSWORD = "pwd";
    public  static final String KEY_NAME = "name";
    public static final String KEY_PH_NO = "phone_number";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_CHILDREN = "children";
    public static final String KEY_CITY= "city";
    public static final String KEY_NEED= "need";
    //String city_select;
    //ProgressDialog pDialog;
    
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ORPHANAGE_TABLE = "CREATE TABLE " + TABLE_ORP + "("
                + KEY_ID + " TEXT," 
                + KEY_PASSWORD + " TEXT,"
        		+ KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT," 
                + KEY_ADDRESS + " TEXT,"
                + KEY_CHILDREN + " NUMERIC,"
                + KEY_CITY + " TEXT,"
                + KEY_NEED + " TEXT"
                + ")";
        db.execSQL(CREATE_ORPHANAGE_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORP);
 
        // Create tables again
        onCreate(db);
    }
    //TO ADD USER DATA INTO THE DB // REGISTRATION 
    public void addOrp(Orp orp1) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(KEY_ID, orp1.getID()); //ID
        values.put(KEY_NAME, orp1.getName()); // Name
        values.put(KEY_PASSWORD, orp1.getPassword()); // Password
        values.put(KEY_PH_NO, orp1.getPhoneNumber()); // Phone Number
        values.put(KEY_ADDRESS, orp1.getAddress()); // Address
        values.put(KEY_CHILDREN, orp1.getChildren()); //Children
        values.put(KEY_CITY, orp1.getCity()); // city
        values.put(KEY_NEED, orp1.getNeed()); // need
        // Inserting Row
        db.insert(TABLE_ORP, null, values);
        db.close(); // Closing database connection
    }
    
    public void edit(String need,int child,String id,String ps)
    {
    	SQLiteDatabase db = this.getWritableDatabase();
    	//UPDATE table SET
    	  //column1 = value1,
    	  //column2 = value2
    	//WHERE condition
    	//String qry="UPDATE " + TABLE_ORP + " SET " + KEY_NEED + " = \'" + need +"\' , " KEY_CHILDREN+ " = " + child + " WHERE " + KEY_ID + " = \'" +id +"\' AND + " + KEY_PASSWORD +  "= \'" + ps+"\' ;";
    	//db.update(table, values, whereClause, whereArgs)
    	
    	String strSQL = "UPDATE " + TABLE_ORP + " SET need = \'" + need + "\' , children = " + child + " WHERE id = \'" + id + "\';";
    	db.execSQL(strSQL);
    }
    
    
    //TO CHECK THE LOGIN INFO // LOGIN HELPER
    public int checkLogin(String id,String ps)
    {
    	
    	
    	//pDialog.setMessage("Logging in ...");
        //pDialog.show();
    	String qry="SELECT * FROM " + TABLE_ORP + " WHERE " + KEY_ID + " = \'" +id +"\' AND + " + KEY_PASSWORD +  "= \'" + ps+"\' ;";
    	
    	SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(qry, null);
        //pDialog.dismiss();
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    	
    }
   
    
    public List<Orp> getAllOrphanages(String city_now) {
        List<Orp> orpList = new ArrayList<Orp>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ORP + " WHERE city = \'" + city_now + "\' ;" ;
     
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
     
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Orp orpx = new Orp();
                //orpx.setID(Integer.parseInt(cursor.getString(0)));
                orpx.setName(cursor.getString(2));
                orpx.setPhoneNumber(cursor.getInt(3));
                orpx.setAddress(cursor.getString(4));
                orpx.setChildren(cursor.getInt(5));
                orpx.setNeed(cursor.getString(7));
                
                // Adding contact to list
                orpList.add(orpx);
            } while (cursor.moveToNext());
        }
     
        // return contact list
        return orpList;
        }
    
 // Getting contacts Count
    public int getOrphanCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ORP;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }

	
    
   /* public Cursor getCursor() {
        //String countQuery = "SELECT "+KEY_ID + ", " +KEY_NAME+", "+KEY_ADDRESS+", "+KEY_PH_NO+", "+KEY_CHILDREN+", "+KEY_NEED+" FROM " + TABLE_ORP;
        String countQuery = "SELECT  * FROM " + TABLE_ORP;
    	SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        return cursor;
    }*/
}