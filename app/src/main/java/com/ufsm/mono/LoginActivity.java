package com.ufsm.mono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText textInputLayoutEmail;
    TextInputEditText textInputLayoutPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputLayoutEmail = findViewById(R.id.editTextTextEmailAddress);
        textInputLayoutPassword = findViewById(R.id.editTextPassword);
    }

    public void loginClick(View view){
        if(textInputLayoutEmail.getText().toString().equals("")) {
            textInputLayoutEmail.setError("Informe seu e-mail");
            return;
        }

        if(textInputLayoutPassword.getText().toString().equals("")){

            TextInputLayout textInputLayout = findViewById(R.id.textInputLayoutPassword);
            textInputLayout.setEndIconActivated(false);
            textInputLayout.setEndIconVisible(false);

            textInputLayout.setError("Informe sua senha");
            return;
        }

        startActivity(new Intent(this, MainActivity.class));
    }
}