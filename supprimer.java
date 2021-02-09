package com.example.ibrahimbourzguicontole;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class supprimer extends AppCompatActivity {
EditText txtsupprimer;
Button btnsupprimer;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer);
        txtsupprimer=findViewById(R.id.txtsupprimer);
        btnsupprimer=findViewById(R.id.btnsupprimer);
      db=  new DatabaseHelper(this);
    }
    public void deletedata(View v){

        if (txtsupprimer.length()>0){
        AlertDialog.Builder alertBuilder=new AlertDialog.Builder(this);
        alertBuilder.setTitle("Confirmation").setMessage("êtes-vous sûr de vouloir supprimer cet employé").setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int lignesupprimer= db.deletedata( Integer.parseInt((txtsupprimer.getText()+"")));
                if (lignesupprimer>0){
                    Toast.makeText(getApplicationContext(),"Employé supprimé",Toast.LENGTH_LONG).show();
                    txtsupprimer.setText(null);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Employé introuvable",Toast.LENGTH_LONG).show();
                }
            }
        }) .setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog=alertBuilder.create();
        dialog.show();
            }
    else
            Toast.makeText(getApplicationContext(),"Entrer l'ID de l'employé",Toast.LENGTH_LONG).show();}

    }


