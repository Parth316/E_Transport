package com.example.e_transport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UseManual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_manual);
        getSupportActionBar().hide();
    }
}