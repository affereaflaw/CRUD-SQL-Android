package com.example.affereaflaw.databaseex;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Affe Reaflaw on 7/19/2017.
 */
public class PersonAdapter extends BaseAdapter {
    Activity activity;
    List<Person> lstPersons;
    LayoutInflater inflater;
    EditText edtId, edtName, edtKelas, edtTelp, edtNo;

    public PersonAdapter(Activity activity, List<Person> lstPersons, EditText edtId, EditText edtName, EditText edtKelas, EditText edtTelp, EditText edtNo) {
        this.activity = activity;
        this.lstPersons = lstPersons;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.edtId = edtId;
        this.edtName = edtName;
        this.edtKelas = edtKelas;
        this.edtTelp = edtTelp;
        this.edtNo = edtNo;
    }

    @Override
    public int getCount() {
        return lstPersons.size();
    }

    @Override
    public Object getItem(int position) {
        return lstPersons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lstPersons.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = inflater.inflate(R.layout.row,null);
        final TextView txtRowId, txtRowName, txtRowKelas, txtRowTelp, txtRowNo;
        txtRowId = (TextView)rowView.findViewById(R.id.txtRowId);
        txtRowName = (TextView)rowView.findViewById(R.id.txtRowName);
        txtRowKelas = (TextView)rowView.findViewById(R.id.txtRowKelas);
        txtRowTelp = (TextView)rowView.findViewById(R.id.txtRowTelp);
        txtRowNo = (TextView)rowView.findViewById(R.id.txtRowNo);

        txtRowId.setText(""+lstPersons.get(position).getId());
        txtRowName.setText(""+lstPersons.get(position).getName());
        txtRowKelas.setText(""+lstPersons.get(position).getKelas());
        txtRowTelp.setText(""+lstPersons.get(position).getTelp());
        txtRowNo.setText(""+lstPersons.get(position).getNo());
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtId.setText(""+txtRowId.getText());
                edtName.setText(""+txtRowName.getText());
                edtKelas.setText(""+txtRowKelas.getText());
                edtTelp.setText(""+txtRowTelp.getText());
                edtNo.setText(""+txtRowNo.getText());
            }
        });
        return rowView;
    }
}
