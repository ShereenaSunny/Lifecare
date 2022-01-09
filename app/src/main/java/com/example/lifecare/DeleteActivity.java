package com.example.lifecare;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteActivity extends AppCompatActivity {
    EditText rollnumbe;
    Button deletebutton;
    DatabaseReference reff;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.del);

        deletebutton=findViewById(R.id.show);

        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference("member");
        deletebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                rollnumbe=findViewById(R.id.uidd);
                String id= rollnumbe.getText().toString().trim();
                deletestudent(id);
            }
        });
    }

    private void deletestudent(String id) {
        DatabaseReference reff=FirebaseDatabase.getInstance().getReference("member").child(id);
        reff.removeValue();
        Toast.makeText(DeleteActivity.this,"STUDENT DELETED SUCCESSFULLY",Toast.LENGTH_LONG).show();
    }


}