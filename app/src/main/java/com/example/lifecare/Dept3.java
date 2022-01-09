package com.example.lifecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Dept3 extends AppCompatActivity {
    Button d1,d2,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept3);

        d1 = findViewById(R.id.a1);
        d2=findViewById(R.id.a2);
        logout=findViewById(R.id.l3);

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(Dept3.this, Formactions.class);
                startActivity(intToMain);
            }
        });

        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(Dept3.this, Formactions.class);
                startActivity(intToMain);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(Dept3.this, MainActivity.class);
                startActivity(intToMain);
            }
        });
    }
}