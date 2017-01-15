package com.example.salvaredatecv.crud;

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
import com.example.salvaredatecv.LoginActivity;
import com.example.salvaredatecv.MeniuActivity;


public class CreateActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText editWorkExperience, editId;
    Button btnCreate, btnRead, btnUpdate, btnDelete;
    Button btnMenu, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_create);

        databaseHelper = new DatabaseHelper(this);

        editWorkExperience = (EditText)findViewById(R.id.editTextWorkExperience);
        editId = (EditText)findViewById(R.id.editTextId);

        btnCreate = (Button)findViewById(R.id.bCreate);
        btnRead = (Button)findViewById(R.id.bRead);
        btnUpdate = (Button)findViewById(R.id.bUpdate);
        btnDelete = (Button)findViewById(R.id.bDelete);

        btnMenu = (Button) findViewById(R.id.bMenu);
        btnLogout = (Button) findViewById(R.id.bLogout);

        createData();
        readData();
        updateData();
        deleteData();

        menu();
        logout();

    }

    public void menu() {
        btnMenu.setOnClickListener(new View.OnClickListener() {
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
    }

    public void logout() {
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
    }

    public void createData() {
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = databaseHelper.insertData(editWorkExperience.getText().toString());
                if (isInserted == true) Toast.makeText(CreateActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else Toast.makeText(CreateActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void readData() {
        btnRead.setOnClickListener(new View.OnClickListener() {
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

    public void updateData() {
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdated = databaseHelper.updateData(
                        editId.getText().toString(),
                        editWorkExperience.getText().toString()
                );

                if (isUpdated == true) Toast.makeText(CreateActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                else Toast.makeText(CreateActivity.this, "Data Not Updated", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void deleteData() {

    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
