package com.example.e_transport.Activity.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.e_transport.Activity.Admin.AdminLogin;
import com.example.e_transport.R;

public class SelectLogin extends AppCompatActivity {
    private Button AdminButton,UserButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login);
        getSupportActionBar().hide();
        AdminButton=findViewById(R.id.Admin);
        UserButton=findViewById(R.id.User);
        AdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AdminLogin.class));
            }
        });

        UserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}