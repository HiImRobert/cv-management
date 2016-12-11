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

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_update);

        Button btnMeniu = (Button) findViewById(R.id.bMenu);
        Button btnLogout = (Button) findViewById(R.id.bLogout);
        Button btnSave = (Button) findViewById(R.id.bSave);
        Button btnCancel = (Button) findViewById(R.id.bCancel);

        btnMeniu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder adb = new AlertDialog.Builder(UpdateActivity.this);
                adb.setMessage("Do you want to go back to Menu?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                /*
                                    UpdateActivity editText > bd/json/xml > ReadActivity textView
                                 */

                                Intent t = new Intent(UpdateActivity.this, MeniuActivity.class);
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
                AlertDialog.Builder adb = new AlertDialog.Builder(UpdateActivity.this);
                adb.setMessage("Do you want to logout?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent t = new Intent(UpdateActivity.this, LoginActivity.class);
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

        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent t = new Intent(UpdateActivity.this, ReadActivity.class);
                startActivity(t);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder adb = new AlertDialog.Builder(UpdateActivity.this);
                adb.setMessage("Do you want to save the CV?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent t = new Intent(UpdateActivity.this, ReadActivity.class);
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
    }
}
