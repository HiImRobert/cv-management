package com.example.salvaredatecv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SchimbareParola extends AppCompatActivity implements View.OnClickListener{

    private static EditText actuala, noua, reintrodu;
    private static TextView aiuitat;
    private static Button salveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schimbare_parola);

        actuala = (EditText) findViewById(R.id.editText_actuala);
        noua = (EditText) findViewById(R.id.editText_noua);
        reintrodu = (EditText) findViewById(R.id.editText_confirmap);

        aiuitat = (TextView) findViewById(R.id.textView15);
        aiuitat.setOnClickListener(this);

        salveaza = (Button) findViewById(R.id.button_salveaza);
        salveaza.setOnClickListener(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView15:
                startActivity(new Intent(SchimbareParola.this, AiUitatParolaActivity.class));
                break;
            case R.id.button_salveaza:
                //  checkValidation();
                Toast.makeText(getApplicationContext(), "Parola a fost schimbata!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ProfilActivity.class));
                break;

        }
    }

    private void checkValidation() {

        String getActuala=actuala.getText().toString();
        String getNoua=noua.getText().toString();
        String getReintrodu=reintrodu.getText().toString();

        if (getActuala.equals("") || getActuala.length() == 0
                || getNoua.equals("") || getNoua.length() == 0
                || getReintrodu.equals("") || getReintrodu.length() == 0)

            Toast.makeText(getApplicationContext(), "Toate campurile trebuie completate!", Toast.LENGTH_SHORT).show();
        else
        if (!getReintrodu.equals(getNoua)) Toast.makeText(getApplicationContext(), "Parolele nu corespund!", Toast.LENGTH_SHORT).show();
        else Toast.makeText(getApplicationContext(), "Parola a fost schimbata!", Toast.LENGTH_SHORT).show();

    }


}
