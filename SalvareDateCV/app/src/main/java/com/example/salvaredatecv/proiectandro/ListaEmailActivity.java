package com.example.salvaredatecv.proiectandro;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.salvaredatecv.R;

import java.util.ArrayList;
import java.util.List;

public class ListaEmailActivity extends AppCompatActivity {
private ListView listViewEmailClass;
private  EmailListAdapter adapter;
private List<EmailClass> arrayListEmailClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_email);


         listViewEmailClass=(ListView)findViewById(R.id.listView_Email);
        arrayListEmailClass=new ArrayList<>();

        Button btnMeniu = (Button) findViewById(R.id.btn_meniu);
        Button btnLogout=(Button) findViewById(R.id.btn_Logout);
        Button btnAdaugaEmail=(Button) findViewById(R.id.btn_AdaugaEmail);

        btnMeniu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent t = new Intent(ListaEmailActivity.this, MeniuActivity.class);
                startActivity(t);
            }
        });

        btnLogout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view)
            {
                AlertDialog.Builder adb = new AlertDialog.Builder(ListaEmailActivity.this);
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
                alertDialog.show();


            }
        });

        btnAdaugaEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText text = (EditText)findViewById(R.id.editText_Email);
                String email = text.getText().toString();
                arrayListEmailClass.add(new EmailClass(1,email));
                adapter=new EmailListAdapter(getApplicationContext(),arrayListEmailClass);
                listViewEmailClass.setAdapter(adapter);
                text.setText(null);


                AlertDialog.Builder adb = new AlertDialog.Builder(ListaEmailActivity.this);
                adb.setMessage("E-mailul a fost adaugat!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                AlertDialog alertDialog = adb.create();
                //alertDialog.setTitle("");
                alertDialog.show();
                  //trebuie facuta verificarea formei de e-mail, de exp @ceva...TO BE CONTINUED

            }

        });
    }

}
