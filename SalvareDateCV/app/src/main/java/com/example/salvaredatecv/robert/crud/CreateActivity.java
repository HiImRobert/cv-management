package com.example.salvaredatecv.robert.crud;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.salvaredatecv.R;
import com.example.salvaredatecv.proiectandro.LoginActivity;
import com.example.salvaredatecv.proiectandro.MeniuActivity;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_create);

        Button btnMeniu = (Button) findViewById(R.id.bMenu);
        Button btnLogout = (Button) findViewById(R.id.bLogout);
        Button btnCreate = (Button) findViewById(R.id.bCreate);
        Button btnCancel = (Button) findViewById(R.id.bCancel);

        btnMeniu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder adb = new AlertDialog.Builder(CreateActivity.this);
                adb.setMessage("Do you want to go back to Menu?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent t = new Intent(CreateActivity.this, MeniuActivity.class);
                                startActivity(t);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                AlertDialog alertDialog = adb.create();
                alertDialog.setTitle("Warning");
                alertDialog.show();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder adb = new AlertDialog.Builder(CreateActivity.this);
                adb.setMessage("Do you want to logout?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent t = new Intent(CreateActivity.this, LoginActivity.class);
                                startActivity(t);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                AlertDialog alertDialog = adb.create();
                alertDialog.setTitle("Warning");
                alertDialog.show();
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                /*
                    CreateActivity editText > bd/json/xml > ReadActivity textView
                 */

                Intent t = new Intent(CreateActivity.this, ReadActivity.class);
                startActivity(t);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent t = new Intent(CreateActivity.this, MeniuActivity.class);
                startActivity(t);
            }
        });

    }
}
