package com.example.salvaredatecv.proiectandro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salvaredatecv.R;
import com.example.salvaredatecv.proiectandro.AiUitatParolaActivity;
import com.example.salvaredatecv.proiectandro.SignUpActivity;

import org.w3c.dom.Text;

import static android.R.attr.password;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static EditText email, parola;
    private static Button login;
    private static TextView uitatparola, signup;
    private static CheckBox arataparola;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.editText_email);
        parola = (EditText) findViewById(R.id.editText_parola);
        login = (Button) findViewById(R.id.Login_btn);
        uitatparola = (TextView) findViewById(R.id.textView4);


        signup = (TextView) findViewById(R.id.textView5);
        arataparola = (CheckBox) findViewById(R.id.checkBox);
        arataparola
                .setOnCheckedChangeListener(new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton button,
                                                 boolean isChecked) {

                        if (isChecked) {

                            arataparola.setText(R.string.hide_pwd);

                            parola.setInputType(InputType.TYPE_CLASS_TEXT);
                            parola.setTransformationMethod(HideReturnsTransformationMethod
                                    .getInstance());
                        } else {
                            arataparola.setText(R.string.arata_parola);


                            parola.setInputType(InputType.TYPE_CLASS_TEXT
                                    | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            parola.setTransformationMethod(PasswordTransformationMethod
                                    .getInstance());

                        }

                    }
                });

        login.setOnClickListener(this);
        signup.setOnClickListener(this);
        uitatparola.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.Login_btn:
                checkValidation();
                break;

            case R.id.textView5:
                startActivity(new Intent(this, SignUpActivity.class));
                break;

            case R.id.textView4:
                startActivity(new Intent(this, AiUitatParolaActivity.class));
                break;

        }



    }

    private void checkValidation() {

        String getEmail = email.getText().toString();
        String getParola = parola.getText().toString();

        if (getEmail.equals("") || getEmail.length() == 0
                || getParola.equals("") || getParola.length() == 0) {
            Toast.makeText(getApplicationContext(), "Scrie email-ul si parola!", Toast.LENGTH_SHORT).show();
        } else //Toast.makeText(getApplicationContext(), "Login!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MeniuActivity.class));

    }
}



