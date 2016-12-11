package com.example.salvaredatecv.proiectandro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salvaredatecv.R;

public class AiUitatParolaActivity extends AppCompatActivity implements View.OnClickListener {
    private static EditText email;
    private static TextView inapoi, trimite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_uitat_parola);
        email=(EditText)findViewById(R.id.editText_mail);
        inapoi=(TextView)findViewById(R.id.textView_inapoi);
        inapoi.setOnClickListener(this);
        trimite=(TextView)findViewById(R.id.textView_trimite);
        trimite.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.textView_inapoi:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.textView_trimite:
                submitButtonTask();
                break;
        }
    }
    private void submitButtonTask() {
        String getEmail = email.getText().toString();
        if (getEmail.equals("") || getEmail.length() == 0)
            Toast.makeText(getApplicationContext(), "Scrieti email-ul!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), "Reseteaza parola!", Toast.LENGTH_SHORT).show();
    }
}