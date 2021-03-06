package com.example.calculator.ui.preferences;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.R;

public class MainSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_settings);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new MainPreference())
                .commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}