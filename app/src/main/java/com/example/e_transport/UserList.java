package com.example.e_transport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {
    RecyclerView uRecyclerView;
    DatabaseReference database;
    UserAdapter userAdapter;
    ArrayList<User> mlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        getSupportActionBar().hide();

        uRecyclerView=findViewById(R.id.userrecyclerviewinadminpanel);
        database= FirebaseDatabase.getInstance().getReference("User");
        uRecyclerView.setHasFixedSize(true);
        uRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mlist =new ArrayList<>();
        userAdapter=new UserAdapter(this,mlist);
        uRecyclerView.setAdapter(userAdapter);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    User user=dataSnapshot.getValue(User.class);
                    mlist.add(user);

                }
                userAdapter.notifyDataSetChanged();
                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}