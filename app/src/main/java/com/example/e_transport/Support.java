package com.example.e_transport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Support extends AppCompatActivity {
    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        getSupportActionBar().hide();
        ratingBar=findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                switch((int) rating){
                    case 1:
                        Toast.makeText(Support.this, "Sorry to hear that", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        Toast.makeText(Support.this, "We will try harder", Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        Toast.makeText(Support.this, "Good", Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        Toast.makeText(Support.this, "Great", Toast.LENGTH_SHORT).show();
                        break;

                    case 5:
                        Toast.makeText(Support.this, "Excellent! Thank You", Toast.LENGTH_SHORT).show();
                        break;

                }

            }
        });
    }
}