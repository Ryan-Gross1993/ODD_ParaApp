package com.opendatadelaware.paratransitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

//    public void signIn(View view) {
//        Intent registrationIntent = new Intent(this, UserProfileActivity.class);
//
//        TextInputEditText usernameInput = (TextInputEditText) findViewById(R.id.usernameTextInputEditText);
//        String userName = usernameInput.getText().toString();
//        registrationIntent.putExtra("USERNAME", userName);
//        startActivity(registrationIntent);
//
//    }
//
//    public void toastMe(View view) {
//        Toast toast = Toast.makeText(this, "Login Button Clicked", Toast.LENGTH_SHORT);
//        toast.show();
//    }
}
