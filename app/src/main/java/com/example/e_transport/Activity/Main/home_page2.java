package com.example.e_transport.Activity.Main;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_transport.R;
import com.example.e_transport.Wora.UserOrders;
import com.example.e_transport.Child.ordereditem;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;


public class home_page2 extends AppCompatActivity {

    RecyclerView recyclerView;
    Button continuebtninhomepage2, logout,applybtn,getestprice;
    EditText edt, weight, paddress, daddress, ppincode, dpincode, date, mobile, pickuppoint, droppoint,offer,km;
    DatePickerDialog datePickerDialog;
    public static final String CKVH = "com.order.msg";
    DatabaseReference databaseReference;
    CheckBox checkBox;
    RadioButton paytm,phonepe,cod;
    TextView appliedOffer,estprice;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);
        weight = findViewById(R.id.weight);
        continuebtninhomepage2 = findViewById(R.id.continuebtninhomepage2);
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
        estprice=findViewById(R.id.estPrice);
        getestprice=findViewById(R.id.getEstPriceBtn);
        km=findViewById(R.id.km);
        getSupportActionBar().hide();

        cod.setChecked(true);
        paytm.setEnabled(false);
        phonepe.setEnabled(false);

        getestprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent price=getIntent();
                String distance=km.getText().toString().trim();
                String vehiclePrice=price.getStringExtra("ActivityDetail.vehicleprice");

                    if(distance.equals(""))
                    {
                        Toast.makeText(home_page2.this, "Enter Distance", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        estprice.setText(""+Integer.parseInt(distance)*Integer.parseInt(vehiclePrice));
                    }

            }
        });

        continuebtninhomepage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent theIntent=getIntent();
                String selectedName= theIntent.getStringExtra("ActivityDetail.name");

                String ppoint = pickuppoint.getText().toString().trim();
                String dpoint = droppoint.getText().toString().trim();
                String upickupAddress = paddress.getText().toString().trim();
                String udropAddress = daddress.getText().toString().trim();
                String uweight = weight.getText().toString().trim();
                String udate = date.getText().toString().trim();
                String mobileno = mobile.getText().toString().trim();
                    UserOrders userOrders = new UserOrders(upickupAddress, udropAddress, mobileno, uweight, udate, ppoint, dpoint,selectedName);
                    databaseReference.push().setValue(userOrders);
                    Intent i = new Intent(getApplicationContext(), ordereditem.class);
                    startActivity(i);
            }
        });

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

            databaseReference = FirebaseDatabase.getInstance().getReference().child("User");




        //RecyclerView Horizontal Scrolling List
//        Integer[] img = {R.drawable.vone, R.drawable.vtwo, R.drawable.vthree, R.drawable.vfour, R.drawable.vfive,R.drawable.vsix,R.drawable.veight,R.drawable.vnine,R.drawable.vten,R.drawable.vtweleve};
//        String[] arr = {"Bolero", "Heavy Truck", "Van", "Tempo", "Truck"};
//        String[] detail = {"10 Rs/Km", "20 Rs/Km", "16 Rs/Km", "26 Rs/Km","12 Rs/km","40 Rs/km","30 Rs/km","50 Rs/km","60 Rs/km","45 Rs/km"};
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        MyAdapter adapter = new MyAdapter(getQuantityData(), detail, img,this);
//        recyclerView.setAdapter(adapter);


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




//    @Override
//    public void onQuantityChangeListener(ArrayList<String> arrayList, String pos) {
//        continuebtninhomepage2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//            }
//        });
//    }

}

