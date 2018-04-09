package com.utar.tourguideapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends Activity {

    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.login_username);
        password = (EditText)findViewById(R.id.login_password);
    }

    public void onLogin(View v) {

        String user_name = username.getText().toString();
        String user_password = password.getText().toString();
        String method = "Login";

        AuthenticationServer authenticationServer = new AuthenticationServer(this);
        authenticationServer.execute(method,user_name,user_password);
    }

    public void onSignUp(View v) {

        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
}
