package com.example.e_transport.Activity.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.e_transport.Activity.Main.home_page2;
import com.example.e_transport.R;

public class ActivityDetail extends AppCompatActivity{
    TextView selectedVehicleName,selectedvehiclePrice,selectedVehicleDesciption;
    ImageView selectedVehicleImage;
    private Button orderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();

        orderButton=findViewById(R.id.orderButton);
        selectedVehicleName=findViewById(R.id.vehicleName);
        selectedVehicleImage=findViewById(R.id.vehicleImage);
        selectedvehiclePrice=findViewById(R.id.vehcleprice);
        selectedVehicleDesciption=findViewById(R.id.vehicledescription);

        Intent desc=getIntent();
        Intent name=getIntent();
        Intent img=getIntent();
        Intent price=getIntent();

        String vehiclePrice=price.getStringExtra("VehiclePrice");
        String nme=name.getStringExtra("VehicleName");
        String description=desc.getStringExtra("VehicleDescription");
        Integer simg=img.getIntExtra("VehicleImage",0);

        selectedVehicleName.setText(nme);
        selectedVehicleImage.setImageResource(simg);
        selectedvehiclePrice.setText(vehiclePrice);
        selectedVehicleDesciption.setText(description);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent passData=new Intent(getApplicationContext(), home_page2.class);
                passData.putExtra("ActivityDetail.name",nme);
                passData.putExtra("ActivityDetail.vehicleprice",vehiclePrice);
                startActivity(passData);

            }
        });

    }
}