package com.example.lifecare;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {
    ListView myListview;
    List<Member> patientlist;
    DatabaseReference patientlistDbREf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewrecord);
        myListview=findViewById(R.id.mylistview);
        patientlist=new ArrayList<>();
        patientlistDbREf= FirebaseDatabase.getInstance().getReference("member");
        patientlistDbREf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              patientlist.clear();


                for(DataSnapshot studentDatasnap:dataSnapshot.getChildren()){
                    Member member= studentDatasnap.getValue(Member.class);
                    patientlist.add(member);


                }
                ListAdapter adapter=new ListAdapter(ViewActivity.this,patientlist);

                myListview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}