package com.example.ibrahimbourzguicontole;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import EmployePackage.Employe;

public class modifier extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
EditText txtidMODIFIER,txtnomMODIFIER,txtprenomModifier;
TextView txtageModifier;
Button btnageMODIFIER,btnajouterMODIFIER,btnrechercherMODIFIER;
RadioButton rbMMODIFIER,rbfMODIFIER;
MyAdapter myAdapter;
ArrayList<Employe> arrayList;
 DatabaseHelper databaseHelper;
 ListView listeempModifier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);
        listeempModifier=findViewById(R.id.listempMODIFIER);
        txtidMODIFIER=findViewById(R.id.txtidMODIFIER);
        txtnomMODIFIER=findViewById(R.id.txtnomMODIFIER);
        txtprenomModifier=findViewById(R.id.txtprenomMODIFIER);
        txtageModifier=findViewById(R.id.txtageempMODIFIER);
        btnajouterMODIFIER=findViewById(R.id.btnajouterMODIFIER);
        btnageMODIFIER=findViewById(R.id.btnAgeMODIFIER);
        btnrechercherMODIFIER=findViewById(R.id.btnrechercherMODIFIER);
        databaseHelper=new DatabaseHelper(this);
        btnrechercherMODIFIER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList=new ArrayList<>();
                String IDEMP=txtidMODIFIER.getText().toString()+"";
                loadDataInListview(IDEMP);
            }
        });
        rbMMODIFIER=findViewById(R.id.rbMMODIFIER);
        rbfMODIFIER=findViewById(R.id.rbFMODIFIER);
        btnageMODIFIER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker= new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
    }
    private void loadDataInListview(String IDEMP) {
        arrayList=  databaseHelper.getone(IDEMP);
        myAdapter=new MyAdapter(this,arrayList);
        listeempModifier.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
    public void updatedata (View v)
    {
        String sexe="M" ;
        if (rbfMODIFIER.isChecked()){
            sexe="F";
        }
        if (txtidMODIFIER.length()==0||txtprenomModifier.length()==0 || txtnomMODIFIER.length()==0 || txtageModifier.length()==0){
            Toast.makeText(getApplicationContext(),"Veuillez remplir tout les champs",Toast.LENGTH_SHORT).show();
        }
        boolean result=databaseHelper.updatedata(Integer.parseInt(txtidMODIFIER.getText().toString()+""),txtnomMODIFIER.getText().toString(),txtprenomModifier.getText().toString(),txtageModifier.getText().toString(),sexe.toString());
        if (result){
            txtnomMODIFIER.setText(null);
            txtprenomModifier.setText(null);
            txtageModifier.setText(null);
            rbMMODIFIER.setChecked(true);
            Toast.makeText(getApplicationContext(),"Employe modifié",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"ERReur",Toast.LENGTH_LONG).show();
        }
    }
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString= DateFormat.getDateInstance().format(c.getTime());
        txtageModifier.setText(currentDateString);
    }
}
