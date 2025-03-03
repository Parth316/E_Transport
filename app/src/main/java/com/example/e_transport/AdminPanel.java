package com.example.e_transport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdminPanel extends AppCompatActivity {
    ImageView users,orders;
    ProgressDialog progressDialog=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_admin_panel);
        orders=findViewById(R.id.ordersinadmin);
        users=findViewById(R.id.userinadmin);
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showProgressBar();

                startActivity(new Intent(getApplicationContext(),UserList.class));

                }
        });
        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),home_page2.class));
            }
        });
    }
//
//    private void showProgressBar() {
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setCancelable(true);
//        progressDialog.setMessage("Loading...");
//        progressDialog.setProgress(0);
//        progressDialog.setMax(100);
//        progressDialog.show();
//    }
}