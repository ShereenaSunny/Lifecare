package com.example.lifecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Dept1 extends AppCompatActivity {
    Button doctor1,doctor2,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept1);
        doctor1 = findViewById(R.id.doctor1);
        doctor2=findViewById(R.id.doctor2);
        logout=findViewById(R.id.l1);

        doctor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(Dept1.this, Formactions.class);
                startActivity(intToMain);
            }
        });

        doctor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(Dept1.this, Formactions.class);
                startActivity(intToMain);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(Dept1.this, MainActivity.class);
                startActivity(intToMain);
            }
        });
    }
}