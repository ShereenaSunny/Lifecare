package com.example.lifecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Button btnLogout, dept1,dept2,dept3;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogout = findViewById(R.id.logout);
        dept1= findViewById(R.id.dept1);
        dept2= findViewById(R.id.dept2);
        dept3= findViewById(R.id.dept3);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intToMain);
            }
        });

        dept1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(HomeActivity.this, Dept1.class);
                startActivity(intToMain);
            }
        });

        dept2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intToMain = new Intent(HomeActivity.this, Dept2.class);
                startActivity(intToMain);
            }
        });

        dept3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intToMain = new Intent(HomeActivity.this, Dept3.class);
                startActivity(intToMain);
            }
        });
    }
}