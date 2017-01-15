package com.example.salvaredatecv;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.salvaredatecv.crud.CreateActivity;

public class MeniuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu);

        Button btnMeniu = (Button) findViewById(R.id.btn_meniu);
        Button btnLogout=(Button) findViewById(R.id.btn_Logout);
        Button btnAdaugaCV=(Button) findViewById(R.id.btn_AdaugaCV);
        Button btnCVulMeu=(Button) findViewById(R.id.btn_CVulMeu);
        Button btnAdaugaEmail=(Button) findViewById(R.id.btn_AdaugaEmail);
        Button btnProfil=(Button) findViewById(R.id.btn_profil);

        btnMeniu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               Intent t = new Intent(MeniuActivity.this, MeniuActivity.class);
                onRestart();
            }


        });


        btnLogout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view)
            {

                AlertDialog.Builder adb = new AlertDialog.Builder(MeniuActivity.this);
                adb.setMessage("Do you want to logout?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                android.os.Process.killProcess(android.os.Process.myPid());
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                AlertDialog alertDialog = adb.create();
                //alertDialog.setTitle("");
                alertDialog.show();


            }
        });
        btnAdaugaCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick( View view)
            {
                Intent t = new Intent(MeniuActivity.this, CreateActivity.class);
                startActivity(t);
            }
        });
        btnCVulMeu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent t = new Intent(MeniuActivity.this, ReadActivity.class);
                startActivity(t);
            }
        });
        btnAdaugaEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent t = new Intent(MeniuActivity.this, ListaEmailActivity.class);
                startActivity(t);
            }
        });
        btnProfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent t = new Intent(MeniuActivity.this, ProfilActivity.class);
                startActivity(t);
            }
        });

    }
    @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent t = new Intent(MeniuActivity.this, MeniuActivity.class);
        startActivity(t);
        finish();

    }
}
