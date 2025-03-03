package com.example.e_transport.Activity.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.e_transport.Fragment.AccountFragment;
import com.example.e_transport.Fragment.FragmentHome;
import com.example.e_transport.Fragment.MapFragment;
import com.example.e_transport.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        BottomNavigationView navView = (BottomNavigationView) findViewById(R.id.mBottomNavBar);
        if(savedInstanceState==null)
        {
            navView.setSelectedItemId(R.id.Home);
            replaceFragment(new FragmentHome());
        }
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.Home:
                        replaceFragment(new FragmentHome());
                        break;
                    case R.id.Map:
                        replaceFragment(new MapFragment());
                        break;
                    case R.id.Account:
                        replaceFragment(new AccountFragment());
                        break;
                }
                return true;
            }
        });

//        navView.setSelectedItemId(R.id.Orders);
//        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.Home:
//                    case R.id.Account:
//                        replaceFragment(new HomeFragment());
//                        break;
//                    case R.id.Orders:
//                        replaceFragment(new OrderFragment());
//                        break;
//                }
//                return true;
//            }
//        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        fragmentTransaction.replace(R.id.mFrameLayout,fragment);
        fragmentTransaction.commit();

    }
}