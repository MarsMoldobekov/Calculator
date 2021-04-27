package com.example.calculator.ui.preferences;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.calculator.R;

public class MainPreference extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.main_preference, rootKey);
    }
}
