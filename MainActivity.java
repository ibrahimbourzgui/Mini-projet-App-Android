package com.example.ibrahimbourzguicontole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnAjouter,btnAfficher,btnModifier,btnSupprimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAjouter=findViewById(R.id.btnajouter);
        btnAfficher=findViewById(R.id.btnafficher);
        btnModifier=findViewById(R.id.btnmodifier);
        btnSupprimer=findViewById(R.id.btnsupprimer);
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ajouter.class);
                startActivity(intent);
            }
        });
        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),afficher.class);
                startActivity(intent);
            }
        });
        btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),modifier.class);
                startActivity(intent);
            }
        });
        btnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),supprimer.class);
                startActivity(intent);
            }
        });
    }
}
