package com.example.salvaredatecv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private static EditText username, email, telefon, localitate, parola, confirmaparola;
    private static Button signup;
    private static TextView login;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username=(EditText)findViewById(R.id.editText_username);
        email=(EditText)findViewById(R.id.editText_email);
        telefon=(EditText)findViewById(R.id.editText_telefon);
        localitate=(EditText)findViewById(R.id.editText_localitate);
        parola=(EditText)findViewById(R.id.editText_parola);
        confirmaparola=(EditText)findViewById(R.id.editText_confirmap);
        signup=(Button)findViewById(R.id.button_singup);
        signup.setOnClickListener(this);
        login=(TextView)findViewById(R.id.textView_login1);
        login.setOnClickListener(this);
    }
    @Override
    public void onClick (View v){

        switch(v.getId()){
            case R.id.button_singup:
                checkValidation();
                break;
            case R.id.textView_login1:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
    private void checkValidation() {
        String getUsername=username.getText().toString();
        String getEmail=email.getText().toString();
        String getTelefon=telefon.getText().toString();
        String getLocalitate=localitate.getText().toString();
        String getParola=parola.getText().toString();
        String getConfirmaparola=confirmaparola.getText().toString();
        if (getUsername.equals("") || getUsername.length() == 0
                || getEmail.equals("") || getEmail.length() == 0
                || getTelefon.equals("") || getTelefon.length() == 0
                || getLocalitate.equals("") || getLocalitate.length() == 0
                || getParola.equals("") || getParola.length() == 0
                || getConfirmaparola.equals("")
                || getConfirmaparola.length() == 0)
            Toast.makeText(getApplicationContext(), "Toate campurile trebuie completate!", Toast.LENGTH_SHORT).show();
        else if (!getConfirmaparola.equals(getParola)) Toast.makeText(getApplicationContext(), "Parolele nu corespund!", Toast.LENGTH_SHORT).show();
        else Toast.makeText(getApplicationContext(), "Sign up!", Toast.LENGTH_SHORT).show();
    }
}