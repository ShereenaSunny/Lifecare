package com.example.lifecare;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Form extends AppCompatActivity {
    EditText name, emails, uid, dob, phone, past, blood, height, weight, records;
    Button submit,delbutton;
    DatabaseReference reff;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        name=(EditText)findViewById(R.id.name);
        emails=(EditText)findViewById(R.id.emails);
        uid=(EditText)findViewById(R.id.uid);
        dob=(EditText)findViewById(R.id.dob);
        phone=(EditText)findViewById(R.id.phone);
        past=(EditText)findViewById(R.id.past);
        blood=(EditText)findViewById(R.id.blood);
        height=(EditText)findViewById(R.id.height);
        weight=(EditText)findViewById(R.id.weight);
        records=(EditText)findViewById(R.id.records);
        submit=(Button)findViewById(R.id.submit);
        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("member");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                member.setName(name.getText().toString().trim());
                member.setEmails(emails.getText().toString().trim());
                member.setUid(uid.getText().toString().trim());
                member.setPast(past.getText().toString().trim());
                member.setBlood(blood.getText().toString().trim());
                member.setRecords(records.getText().toString().trim());
                member.setDob(dob.getText().toString().trim());
                member.setHeight(height.getText().toString().trim());
                member.setWeight(weight.getText().toString().trim());
                member.setPhone(phone.getText().toString().trim());

                String uidd= uid.getText().toString().trim();

                reff.child(uidd).setValue(member);

                Toast.makeText(Form.this, "ADDED SUCCESSFULLY", Toast.LENGTH_SHORT).show();

            }
        });

        }
    }
