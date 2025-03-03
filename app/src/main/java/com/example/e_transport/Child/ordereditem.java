package com.example.e_transport.Child;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.e_transport.Activity.Main.home_page2;
import com.example.e_transport.Adapter.OrderedItemaAdapter;
import com.example.e_transport.R;

import java.util.ArrayList;

public class ordereditem extends AppCompatActivity {
    TextView name1;
    RecyclerView r1;
    ArrayList<String> names=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordereditem);
        Intent i=getIntent();
        String selectedVehicledata=i.getStringExtra(home_page2.CKVH);
        names.add(selectedVehicledata);
        r1=(RecyclerView) findViewById(R.id.recyclerviewinorderitem);
        r1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        OrderedItemaAdapter o1=new OrderedItemaAdapter(names);
        r1.setAdapter(o1);

    }
}