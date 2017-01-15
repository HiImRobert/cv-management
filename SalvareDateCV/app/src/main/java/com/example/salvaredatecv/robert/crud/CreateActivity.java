package com.example.salvaredatecv.robert.crud;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salvaredatecv.R;
import com.example.salvaredatecv.proiectandro.LoginActivity;
import com.example.salvaredatecv.proiectandro.MeniuActivity;


public class CreateActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText editWorkExperience;
    Button btnCreate, btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_create);
        databaseHelper = new DatabaseHelper(this);

        editWorkExperience = (EditText)findViewById(R.id.etWorkExperience);
        btnCreate = (Button)findViewById(R.id.bCreate);
        btnView = (Button)findViewById(R.id.bView);

        addData();
        viewAll();

        Button btnMeniu = (Button) findViewById(R.id.bMenu);
        Button btnLogout = (Button) findViewById(R.id.bLogout);
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

        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent t = new Intent(CreateActivity.this, ReadActivity.class);
                startActivity(t);
            }
        });
    }

    public void addData() {
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = databaseHelper.insertData(editWorkExperience.getText().toString());
                if (isInserted == true) Toast.makeText(CreateActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else Toast.makeText(CreateActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void viewAll() {
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor =  databaseHelper.getAllData();

                if (cursor.getCount() == 0) {
                    showMessage("Error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    buffer.append("Id: " + cursor.getString(0) + "\n");
                    buffer.append("Work Experience: " + cursor.getString(1) + "\n\n");
                }

                showMessage("Data", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
