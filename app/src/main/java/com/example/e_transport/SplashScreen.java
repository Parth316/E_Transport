package com.example.e_transport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread thread = new Thread(){
            @Override
            public void run() {
                setPriority(5);
                try{
                sleep(500);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        };thread.start();

    }

}