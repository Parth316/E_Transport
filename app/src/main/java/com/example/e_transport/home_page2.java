package com.example.e_transport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;


public class home_page2 extends AppCompatActivity implements QuntityListener{

    RecyclerView recyclerView;
    Button continuebtninhomepage2, logout,applybtn;
    EditText edt, weight, paddress, daddress, ppincode, dpincode, date, mobile, pickuppoint, droppoint,offer;
    DatePickerDialog datePickerDialog;
    public static final String CKVH = "com.order.msg";
    DatabaseReference databaseReference;
    CheckBox checkBox;
    RadioButton paytm,phonepe,cod;
    TextView appliedOffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);
        recyclerView = findViewById(R.id.recyclerview);
        weight = findViewById(R.id.weight);
        continuebtninhomepage2 = findViewById(R.id.continuebtninhomepage2);
        logout = findViewById(R.id.logout);
        paddress = findViewById(R.id.pickupaddress);
        daddress = findViewById(R.id.dropaddress);
        ppincode = findViewById(R.id.pickuppincode);
        dpincode = findViewById(R.id.droppincode);
        date = findViewById(R.id.date);
        mobile = findViewById(R.id.mobilenoinhomepage2);
        pickuppoint = findViewById(R.id.pickuppoint);
        droppoint = findViewById(R.id.droppoint);
        checkBox = (CheckBox) findViewById(R.id.vehicleselection);
        offer=findViewById(R.id.Offer);
        applybtn=findViewById(R.id.applybtn);
        paytm=findViewById(R.id.paytm);
        phonepe=findViewById(R.id.phonepe);
        cod=findViewById(R.id.cod);
        appliedOffer=findViewById(R.id.appliedoffer);
        getSupportActionBar().hide();

        cod.setChecked(true);
        paytm.setEnabled(false);
        phonepe.setEnabled(false);
        appliedOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appliedOffer.setText("");
                appliedOffer.setVisibility(View.GONE);
            }
        });
        applybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String off;
                off = offer.getText().toString();
                if (off.equals("5off") || off.equals("10off")||off.equals("15off"))
                {
                    offer.setText("");
                    appliedOffer.setVisibility(View.VISIBLE);
                    appliedOffer.setText(off);
                    Toast.makeText(home_page2.this, "Offer Applied", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(home_page2.this, "Not Valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference().child("User").child("orders");
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                insertVehicleData();
////                startActivity(new Intent(getApplicationContext(),UserList.class));
//            }
//        });


//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(home_page2.this,ordereditem.class);
//                startActivity(intent);
//            }
//        });


//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//        Intent i=getIntent();
//        String vname=i.getStringExtra(MyAdapter.MSG11);
//        startActivity(i);

//        BottomNavigationView navView = (BottomNavigationView) findViewById(R.id.navBar);
//        navView.setSelectedItemId(R.id.Orders);
//        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
////                    case R.id.Orders:
////                       startActivity(new Intent(getApplicationContext(),home_page2.class));
////                        finish();
////                        break;
//                    case R.id.Home:
//                        startActivity(new Intent(getApplicationContext(), Temp.class));
//                        finish();
//                        break;
//                    case R.id.Account:
//                        startActivity(new Intent(getApplicationContext(), Account_Activity.class));
//                        finish();
//                        break;
//                }
//                return true;
//            }
//        });


        //RecyclerView Horizontal Scrolling List
        Integer[] img = {R.drawable.vone, R.drawable.vtwo, R.drawable.vthree, R.drawable.vfour, R.drawable.vfive,R.drawable.vsix,R.drawable.veight,R.drawable.vnine,R.drawable.vten,R.drawable.vtweleve};
//        String[] arr = {"Bolero", "Heavy Truck", "Van", "Tempo", "Truck"};
        String[] detail = {"10 Rs/Km", "20 Rs/Km", "16 Rs/Km", "26 Rs/Km","12 Rs/km","40 Rs/km","30 Rs/km","50 Rs/km","60 Rs/km","45 Rs/km"};
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        MyAdapter adapter = new MyAdapter(getQuantityData(), detail, img,this);
        recyclerView.setAdapter(adapter);


        edt = findViewById(R.id.date);
        //Calendar
        Calendar calendar = Calendar.getInstance();
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);

        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(home_page2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edt.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }

        });
    }



    private ArrayList<String> getQuantityData() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Bolero");
        arrayList.add("Mini Truck");
        arrayList.add("Heavy Truck");
        arrayList.add("Truck");
        arrayList.add("Tempo");
        arrayList.add("Tata Sumo");
        arrayList.add("Eicher");
        arrayList.add("Industrial Truck");
        arrayList.add("16 Wheeler");
        arrayList.add("Turbo Truck");
        return arrayList;
    }

    @Override
    public void onQuantityChangeListener(ArrayList<String> arrayList, String pos) {
        continuebtninhomepage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ppoint = pickuppoint.getText().toString().trim();
                String dpoint = droppoint.getText().toString().trim();
                String upickupAddress = paddress.getText().toString().trim();
                String udropAddress = daddress.getText().toString().trim();
                String uweight = weight.getText().toString().trim();
                String udate = date.getText().toString().trim();
                String mobileno = mobile.getText().toString().trim();
                
                    UserOrders userOrders = new UserOrders(upickupAddress, udropAddress, mobileno, uweight, udate, ppoint, dpoint, pos);
                    databaseReference.push().setValue(userOrders);
                    Intent i = new Intent(getApplicationContext(), ordereditem.class);

                    i.putExtra(CKVH, pos);
                    Toast.makeText(home_page2.this, pos, Toast.LENGTH_SHORT).show();
                    startActivity(i);


            }
        });
    }
}

