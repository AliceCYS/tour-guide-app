package com.utar.tourguideapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends Activity {

    private EditText username,password,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.inputUsername);
        password = (EditText)findViewById(R.id.inputPassword);
        email = (EditText) findViewById(R.id.inputEmail);
    }

    public void onReg(View v) {
        String user_name = username.getText().toString();
        String user_password = password.getText().toString();
        String user_email = email.getText().toString();

        String method = "Register";
        AuthenticationServer authenticationServer = new AuthenticationServer(this);
        authenticationServer.execute(method,user_name,user_email,user_password);
    }

    public void onCancel(View v) {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
    }

}
