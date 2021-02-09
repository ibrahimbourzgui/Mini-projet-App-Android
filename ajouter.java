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

public class ajouter extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
EditText txtnom,txtprenom;
TextView txtage;
RadioButton rbM,rbF;
Button btnAge,btnajouteremp;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
        txtnom=findViewById(R.id.txtnom);
        txtprenom=findViewById(R.id.txtprenom);
        txtage=findViewById(R.id.txtageemp);
        rbM=findViewById(R.id.rbM);
        rbF=findViewById(R.id.rbF);
        btnajouteremp=findViewById(R.id.btnajouteremp);
        btnAge=findViewById(R.id.btnAge);
        btnAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker= new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
        databaseHelper =new DatabaseHelper(this);

    }

    public void insert (View v)
    {
        String sexe="M" ;
        if (rbF.isChecked()){
            sexe="F";
        }
        if (txtprenom.length()==0 || txtnom.length()==0 || txtage.length()==0){
            Toast.makeText(getApplicationContext(),"Veuillez remplir tout les champs",Toast.LENGTH_SHORT).show();
        }
        boolean result=databaseHelper.insertData(txtnom.getText().toString(),txtprenom.getText().toString(),txtage.getText().toString(),sexe.toString());
        if (result){
            txtnom.setText(null);
            txtprenom.setText(null);
            txtage.setText(null);
            rbM.setChecked(true);
            Toast.makeText(getApplicationContext(),"Employe ajouté",Toast.LENGTH_LONG).show();
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
        txtage.setText(currentDateString);
    }

}
