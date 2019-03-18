package com.example.orphanagexfinal;

public class Orp {
	//private variables
    String _id;
    String _password;
    String _name;
    int _phone_number;
    String _address;
    int _children;
    String _city;
    String _need;
     
    // Empty constructor
    public Orp(){
         
    }
        
    // constructor
    public Orp(String _id,String _password,String name, int _phone_number, String _address,int _children,String _city,String _need){
        this._name = name;
        this._phone_number = _phone_number;
        this._address=_address;
        this._children=_children;
        this._city=_city;
        this._need=_need;
        this._id=_id;
        this._password=_password;
        
    }
 // getting ID
    public String getID(){
        return this._id;
    }
     
    // setting id
    public void setID(String id){
        this._id = id;
    }
   
    // getting name
    public String getName(){
        return this._name;
    }
     
    // setting name
    public void setName(String name){
        this._name = name;
    }
   
     
    // getting phone number
    public int getPhoneNumber(){
        return this._phone_number;
    }
     
    // setting phone number
    public void setPhoneNumber(int phone_number){
        this._phone_number = phone_number;
    }
    
    // getting address
    public String getAddress(){
        return this._address;
    }
     
    // setting address
    public void setAddress(String address){
        this._address = address;
    }
    
 // getting children
    public int getChildren(){
        return this._children;
    }
     
    // setting children
    public void setChildren(int children){
        this._children = children;
    }
    
 // getting city
    public String getCity(){
        return this._city;
    }
     
    // setting children
    public void setCity(String city){
        this._city = city;
    }
    
 // getting need
    public String getNeed(){
        return this._need;
    }
     
    // setting Need
    public void setNeed(String need){
        this._need = need;
    }
    
 // getting need
    public String getPassword(){
        return this._password;
    }
     
    // setting Need
    public void setPassword(String password){
        this._password = password;
    }


}
