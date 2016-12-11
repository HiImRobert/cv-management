package com.example.salvaredatecv.proiectandro;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.salvaredatecv.R;
import com.example.salvaredatecv.robert.crud.ReadActivity;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        Button btnMeniu = (Button) findViewById(R.id.btn_Meniu);
        Button btnLogout=(Button) findViewById(R.id.btn_logout);
        Button btnSchimbareParola=(Button) findViewById(R.id.btn_schimbareParola);

        btnMeniu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent t = new Intent(ProfilActivity.this, MeniuActivity.class);
                startActivity(t);

                //  t.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);



            }


        });


        btnLogout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view)
            {

                AlertDialog.Builder adb = new AlertDialog.Builder(ProfilActivity.this);
                adb.setMessage("Do you want to logout?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent t = new Intent(ProfilActivity.this, LoginActivity.class);
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
        btnSchimbareParola.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Intent t = new Intent(ProfilActivity.this,....class);
                //startActivity(t);
            }
        });



        EditText editTextUsername = (EditText)findViewById(R.id.editText_username);
         editTextUsername.setText("user");
        EditText editTextNume = (EditText)findViewById(R.id.editText_nume);
        editTextNume.setText("Popescu");
        EditText editTextPrenume = (EditText)findViewById(R.id.editText_prenume);
        editTextPrenume.setText("Ion");
        EditText editTextEmail = (EditText)findViewById(R.id.editText_email);
        editTextEmail.setText("asdf@yahoo.com");
        EditText editTextLocalitate= (EditText)findViewById(R.id.editText_localitate);
        editTextLocalitate.setText("Bucuresti");
        EditText editTextVarsta= (EditText)findViewById(R.id.editText_telefon);
        editTextVarsta.setText("34");


    }
}
