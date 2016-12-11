package com.example.salvaredatecv.proiectandro;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.salvaredatecv.R;

import java.util.List;

/**
 * Created by Mada on 09.12.2016.
 */

public class EmailListAdapter extends BaseAdapter {
    private Context context;
    private List<EmailClass> listaEmailClass;

    public EmailListAdapter(Context context, List<EmailClass> listaEmailClass) {
        this.context = context;
        this.listaEmailClass = listaEmailClass;
    }

    @Override
    public int getCount() {
        return listaEmailClass.size();
    }

    @Override
    public Object getItem(int position) {
        return listaEmailClass.get(position);
    }

    @Override
    public long getItemId(int position) {

       return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context,R.layout.lista_email,null);
        TextView textViewEmail=(TextView)v.findViewById(R.id.textView_email);

        //seteaza text pt TextView
        textViewEmail.setText(listaEmailClass.get(position).getEmail());


        //seteaza id pt Email in Tag
        v.setTag(listaEmailClass.get(position).getId());
        return v;
    }
}
