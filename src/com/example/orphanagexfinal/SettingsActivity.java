package com.example.orphanagexfinal;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.util.StringBuilderPrinter;

public class SettingsActivity extends PreferenceActivity {




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);

        /*ListPreference listPreference = (ListPreference) findPreference("city");
        CharSequence currText = listPreference.getEntry();
        String currValue = listPreference.getValue();*/


    }
}