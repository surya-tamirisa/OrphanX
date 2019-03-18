package com.example.orphanagexfinal;

import java.util.List;

import android.content.ClipData.Item;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class OrpAdapter extends ArrayAdapter<Orp> {

    public OrpAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public OrpAdapter(Context context, int resource, List<Orp> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.row, null);
        }

        Orp p = getItem(position);

        if (p != null) {
            TextView name = (TextView) v.findViewById(R.id.name);
            TextView address = (TextView) v.findViewById(R.id.address);
            TextView phno= (TextView) v.findViewById(R.id.phno);
            TextView children= (TextView) v.findViewById(R.id.children);
            TextView need= (TextView) v.findViewById(R.id.need);
            
                name.setText(p.getName());
                address.setText("Address :"+p.getAddress());
                phno.setText(String.valueOf("Phone :"+p.getPhoneNumber()));
                children.setText("No of Children :"+String.valueOf(p.getChildren()));
                need.setText("Need :"+p.getNeed());
        }
            
            
        

        return v;
    }

}