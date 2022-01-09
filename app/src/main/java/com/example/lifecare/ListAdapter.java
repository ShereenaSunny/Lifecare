package com.example.lifecare;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter {
    private Activity mContext;
    List<Member> patientlist;
    public ListAdapter(Activity mContext,List<Member> patientlist){
        super(mContext,R.layout.view,patientlist);
        this.mContext=mContext;
        this.patientlist=patientlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.view,null,true);

        TextView tvname= listItemView.findViewById(R.id.tvname);
        TextView tvemail= listItemView.findViewById(R.id.tvemail);
        TextView tvuid= listItemView.findViewById(R.id.tvuid);
        TextView tvdob= listItemView.findViewById(R.id.tvdob);
        TextView tvphone= listItemView.findViewById(R.id.tvphone);
        TextView tvpaststill= listItemView.findViewById(R.id.tvpastill);
        TextView tvblood= listItemView.findViewById(R.id.tvblood);
        TextView tvheight= listItemView.findViewById(R.id.tvheight);
        TextView tvweight= listItemView.findViewById(R.id.tvweight);
        TextView tvrecords= listItemView.findViewById(R.id.tvrecords);

      Member Member=patientlist.get(position);


        tvname.setText(Member.getName());
        tvemail.setText(Member.getEmails());
        tvuid.setText(Member.getUid());
        tvdob.setText(Member.getDob());
        tvphone.setText(Member.getPhone());
        tvpaststill.setText(Member.getPast());
        tvblood.setText(Member.getBlood());
        tvheight.setText(Member.getHeight());
        tvweight.setText(Member.getWeight());
        tvrecords.setText(Member.getRecords());


        return listItemView;



    }
}
