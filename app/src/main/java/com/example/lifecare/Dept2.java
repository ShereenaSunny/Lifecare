package com.example.lifecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Dept2 extends AppCompatActivity {
    Button doc1,doc2,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept2);
        doc1 = findViewById(R.id.doc1);
        doc2=findViewById(R.id.doc2);
        logout=findViewById(R.id.l2);

        doc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(Dept2.this, Formactions.class);
                startActivity(intToMain);
            }
        });

        doc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMain = new Intent(Dept2.this, Formactions.class);
                startActivity(intToMain);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(Dept2.this, MainActivity.class);
                startActivity(intToMain);
            }
        });
    }
}