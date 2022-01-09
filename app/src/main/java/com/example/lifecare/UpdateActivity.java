package com.example.lifecare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateActivity extends AppCompatActivity {
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
                ListAdapter adapter=new ListAdapter(UpdateActivity.this,patientlist);

                myListview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Member member =patientlist.get(position);
                showUpdateDialog(member.getName(),member.getEmails(),member.getUid(),member.getDob(),member.getPhone(),member.getPast(),member.getBlood(),member.getHeight(),member.getWeight(),member.getRecords());

                return false;
            }
        });

    }

    private void showUpdateDialog(String upname,String upemaill,String upid,String updob,String upphone,String uppast,String upblood,String upheight,String upweight,String uprec)
    {
        AlertDialog.Builder mDialog= new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        View mDialogView=inflater.inflate(R.layout.update_dialog,null);
        mDialog.setView(mDialogView);

        EditText updatename=mDialogView.findViewById(R.id.upname);
        EditText updateid=mDialogView.findViewById(R.id.upuid);
        EditText updatedob=mDialogView.findViewById(R.id.updob);
        EditText updateemail=mDialogView.findViewById(R.id.upemail);
        EditText updatephone=mDialogView.findViewById(R.id.upphone);
        EditText updatebloodgroup=mDialogView.findViewById(R.id.upblood);
        EditText updatepast=mDialogView.findViewById(R.id.uppast);
        EditText updateheight=mDialogView.findViewById(R.id.upheight);
        EditText updateweight=mDialogView.findViewById(R.id.upweight);
        EditText updaterecord=mDialogView.findViewById(R.id.uprecord);
        Button updatebutton=mDialogView.findViewById(R.id.upsubmit);
        mDialog.setTitle("Updating "+upname+" record");
        mDialog.show();

        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newname=updatename.getText().toString();
                String newemail=updateemail.getText().toString();
                String newuid=updateid.getText().toString();
                String newphone=updatephone.getText().toString();
                String newpast=updatepast.getText().toString();
                String newbloodgroup=updatebloodgroup.getText().toString();
                String newdob=updatedob.getText().toString();
                String newheight=updateheight.getText().toString();
                String newweight=updateweight.getText().toString();
                String newrecord=updaterecord.getText().toString();

                Member member=new Member();
                String idii=member.getUid();
                updateData(newname,newemail,newuid,newdob,newphone,newpast,newbloodgroup,newheight,newweight,newrecord);

                Toast.makeText(UpdateActivity.this,"Patient Record has been Updated",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void updateData(String upname,String upemaill,String upid,String updob,String upphone,String uppast,String upblood,String upheight,String upweight,String uprec)
    {
        Member member=new Member();
        DatabaseReference Dbreff=FirebaseDatabase.getInstance().getReference("member").child(upid);

        member.setName(upname);
        member.setEmails(upemaill);
        member.setUid(upid);
        member.setPast(updob);
        member.setBlood(upblood);
        member.setRecords(uprec);
        member.setDob(updob);
        member.setHeight(upheight);
        member.setWeight(upweight);
        member.setPhone(upphone);

        Dbreff.setValue(member);
    }
}