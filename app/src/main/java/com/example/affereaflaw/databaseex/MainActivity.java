package com.example.affereaflaw.databaseex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtId, edtName, edtKelas, edtTelp, edtNo;
    Button btnAdd, btnDelete, btnUpdate;
    ListView lstPersons;
    List<Person> data = new ArrayList<>();
    DataBaseHelper dtb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dtb = new DataBaseHelper(this);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        lstPersons = (ListView)findViewById(R.id.list);
        edtId = (EditText)findViewById(R.id.edtId);
        edtName = (EditText)findViewById(R.id.edtName);
        edtKelas = (EditText)findViewById(R.id.edtKelas);
        edtTelp = (EditText)findViewById(R.id.edtTelp);
        edtNo = (EditText)findViewById(R.id.edtNo);

        //load data
        refreshData();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person(Integer.parseInt(edtId.getText().toString()),edtName.getText().toString(),edtKelas.getText().toString(),edtTelp.getText().toString(),edtNo.getText().toString());
                dtb.addPerson(person);
                refreshData();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person(Integer.parseInt(edtId.getText().toString()),edtName.getText().toString(),edtKelas.getText().toString(),edtTelp.getText().toString(),edtNo.getText().toString());
                dtb.updatePerson(person);
                refreshData();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person(Integer.parseInt(edtId.getText().toString()),edtName.getText().toString(),edtKelas.getText().toString(),edtTelp.getText().toString(),edtNo.getText().toString());
                dtb.deletePerson(person);
                refreshData();
            }
        });


    }

    private void refreshData(){
        data = dtb.getAllPerson();
        PersonAdapter adapter = new PersonAdapter(MainActivity.this,data,edtId,edtName,edtKelas,edtTelp,edtNo);
        lstPersons.setAdapter(adapter);
    }
}
