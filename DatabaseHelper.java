package com.example.ibrahimbourzguicontole;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import EmployePackage.Employe;

public class DatabaseHelper extends SQLiteOpenHelper {
     public DatabaseHelper (Context context) {super(context,"employe.db",null,1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("create table employe (idEmploye integer primary key autoincrement, nom char(12),prenom char(12),datenaiss char(25),sexe char(5))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("drop table if exists employe");
     onCreate(db);
    }
    public boolean insertData (String nom,String prenom, String datenaiss, String sexe)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("nom",nom);
        contentValues.put("prenom",prenom);
        contentValues.put("datenaiss",datenaiss);
        contentValues.put("sexe",sexe);
        long result=db.insert("employe",null,contentValues);
        if (result==-1) return false;
        else
            return true;
    }
    public ArrayList<Employe> getAlldata(){
         ArrayList<Employe> arrayList= new  ArrayList<>();
         SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from employe",null);
        while (cursor.moveToNext()){
            int idEmploye= cursor.getInt(0);
            String nom=cursor.getString(1);
            String prenom=cursor.getString(2);
            String datenaiss=cursor.getString(3);
            String sexe=cursor.getString(4);
            Employe employe= new Employe(idEmploye,nom,prenom,datenaiss,sexe);
            arrayList.add(employe);
        }
        return arrayList;
    }
    public ArrayList<Employe> getone(String ID) {
        ArrayList<Employe> arrayList1 = new ArrayList<>();
        SQLiteDatabase db1 = getWritableDatabase();
        Cursor cursor1 = db1.rawQuery("select * from employe where idEmploye="+ID.toString()+""+" ", null);
        while (cursor1.moveToNext()) {
            int idEmploye = cursor1.getInt(0);
            String nom = cursor1.getString(1);
            String prenom = cursor1.getString(2);
            String datenaiss = cursor1.getString(3);
            String sexe = cursor1.getString(4);
            Employe employe = new Employe(idEmploye, nom, prenom, datenaiss, sexe);
            arrayList1.add(employe);
        }
        return arrayList1;
    }

    public boolean updatedata (int IDEMP,String nom,String prenom, String datenaiss, String sexe)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("idEmploye",IDEMP);
        contentValues.put("nom",nom);
        contentValues.put("prenom",prenom);
        contentValues.put("datenaiss",datenaiss);
        contentValues.put("sexe",sexe);
        long result=db.update("employe",contentValues,"idEmploye=?",new String[]{IDEMP+""});
        if (result==-1) return false;
        else
            return true;
    }
    public  Integer deletedata (int idsup)
    {
        SQLiteDatabase db=getWritableDatabase();
        return db.delete("employe","idEmploye=?",new String[]{idsup+""});
    }
  /* public void deletemp(int id){
       SQLiteDatabase db=this.getWritableDatabase();
       db.delete("employe","idEmploye=?",new String[]{String.valueOf(id)});
   }*/
}

