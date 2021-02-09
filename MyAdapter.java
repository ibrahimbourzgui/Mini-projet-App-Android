package com.example.ibrahimbourzguicontole;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import EmployePackage.Employe;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Employe> arrayList;
    public MyAdapter(Context context,ArrayList<Employe> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.mycstomafficher,null);
            TextView txtidA=(TextView) convertView.findViewById(R.id.txtidA);
            TextView txtnomA=(TextView) convertView.findViewById(R.id.txtnomA);
            TextView txtprenomA=(TextView) convertView.findViewById(R.id.txtprenomA);
            TextView txtdatenaissA=(TextView) convertView.findViewById(R.id.txtdatnaissA);
            TextView txtsexe=(TextView) convertView.findViewById(R.id.txtsexeA);
            Employe employe= arrayList.get(position);
            txtidA.setText(String.valueOf(employe.getIdEmploye()));
            txtnomA.setText(employe.getNom());
            txtprenomA.setText(employe.getPrenom());
            txtdatenaissA.setText(employe.getDatenaiss());
            txtsexe.setText(employe.getSexe());
        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}
