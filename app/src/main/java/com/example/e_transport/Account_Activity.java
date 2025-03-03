package com.example.e_transport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Account_Activity extends AppCompatActivity {
    Button logout,invitefriend,usermanualbtn,supportbtn;
    GoogleSignInClient mGoogleSignInClient;
    TextView name;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getSupportActionBar().hide();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        logout=findViewById(R.id.logout);
        name=findViewById(R.id.name);
        pic=findViewById(R.id.googleimg);
        invitefriend=findViewById(R.id.invite);
        usermanualbtn=findViewById(R.id.manual);
        supportbtn=findViewById(R.id.support);
        navView.setSelectedItemId(R.id.navigation_account);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        invitefriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey, I'm Inviting You to Use E-Transport App.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        supportbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account_Activity.this,Support.class));
            }
        });

        usermanualbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account_Activity.this,UseManual.class));
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount acct=GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null)
        {
            String personName=acct.getDisplayName();
            Uri personPhoto =acct.getPhotoUrl();
            name.setText(personName);
            Glide.with(this).load(String.valueOf(personPhoto)).into(pic);
        }

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        startActivity(new Intent(getApplicationContext(), Temp.class));
                        finish();
                        break;
                    case R.id.navigation_orders:
                        startActivity(new Intent(getApplicationContext(), home_page2.class));
                        finish();
                        break;
//                    case R.id.navigation_account:
//                        startActivity(new Intent(getApplicationContext(), Account_Activity.class));
//                        finish();
//                        break;
                }
                return false;
            }
        });
    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
//                        startActivity(new Intent(Account_Activity.this,MainActivity.class));
                        Intent intent=new Intent(Account_Activity.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        Toast.makeText(Account_Activity.this, "Signed Out", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                });
    }
}