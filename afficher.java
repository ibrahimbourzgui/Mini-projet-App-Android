package com.example.ibrahimbourzguicontole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import EmployePackage.Employe;

public class afficher extends AppCompatActivity {
ListView listempAFFICHER;
MyAdapter myAdapter;
ArrayList<Employe> arrayList;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher);
        listempAFFICHER=findViewById(R.id.listempAFFICHER);
        databaseHelper=new DatabaseHelper(this);
        arrayList=new ArrayList<>();
        loadDataInListview();

    }

    private void loadDataInListview() {
        arrayList=  databaseHelper.getAlldata();
        myAdapter=new MyAdapter(this,arrayList);
        listempAFFICHER.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}
