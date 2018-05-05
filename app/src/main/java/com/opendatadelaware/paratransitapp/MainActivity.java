package com.opendatadelaware.paratransitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.opendatadelaware.paratransitapp.home.HomeActivity;
import com.opendatadelaware.paratransitapp.userregistration.RegistrationActivity;

import org.json.JSONException;

public class MainActivity extends Activity{

    EditText emailEditText;
    EditText passwordEditText;
    Button registerButton;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.loginButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register(view);
            }
        });

    }

    public void signIn(View view) {
        Intent mainScreenIntent = new Intent(this, HomeActivity.class);
        startActivity(mainScreenIntent);
    }

    public void register(View view) {
        Intent registrationIntent = new Intent(this, RegistrationActivity.class);
        startActivity(registrationIntent);
    }

}
