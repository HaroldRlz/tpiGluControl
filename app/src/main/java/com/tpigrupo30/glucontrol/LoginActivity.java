package com.tpigrupo30.glucontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tpigrupo30.glucontrol.View.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goContainer(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void goCreateAccount(View view){
        Intent intent = new Intent(this,CreateAccountActivity.class);
        startActivity(intent);
    }

}
