package com.example.salvaredatecv.robert.crud;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.salvaredatecv.R;
import com.example.salvaredatecv.proiectandro.LoginActivity;
import com.example.salvaredatecv.proiectandro.MeniuActivity;

public class ReadActivity extends AppCompatActivity {

    public static TextView textViewWorkExperience;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_read);

        textViewWorkExperience = (TextView)findViewById(R.id.tvWorkExperience);

        //viewAll();

        Button btnMeniu = (Button) findViewById(R.id.bMenu);
        Button btnLogout = (Button) findViewById(R.id.bLogout);
        Button btnModifica = (Button) findViewById(R.id.bUpdate);
        Button btnDelete = (Button) findViewById(R.id.bDelete);

        btnMeniu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder adb = new AlertDialog.Builder(ReadActivity.this);
                adb.setMessage("Do you want to go back to Menu?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent t = new Intent(ReadActivity.this, MeniuActivity.class);
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
                AlertDialog.Builder adb = new AlertDialog.Builder(ReadActivity.this);
                adb.setMessage("Do you want to logout?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent t = new Intent(ReadActivity.this, LoginActivity.class);
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

        btnModifica.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                /*
                    ReadActivity textView > bd/json/xml > UpdateActivity editText
                 */

                Intent t = new Intent(ReadActivity.this, UpdateActivity.class);
                startActivity(t);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder adb = new AlertDialog.Builder(ReadActivity.this);
                adb.setMessage("Do you want to delete the CV?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                /*
                                    delete ReadActivity textView
                                 */
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

    public void viewAll() {
        Cursor cursor =  databaseHelper.getAllData();

        cursor.moveToLast();
        textViewWorkExperience.setText(cursor.getString(1));
    }
}
