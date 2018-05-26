
package com.tpigrupo30.glucontrol;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tpigrupo30.glucontrol.View.CreateAccountActivity;
import com.tpigrupo30.glucontrol.model.Glucometria;
import com.tpigrupo30.glucontrol.model.Meal;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText username_login, password_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username_login = findViewById(R.id.username_login);
        password_login = findViewById(R.id.password_login);


    }

    public void goContainer(View view) {

        String name = username_login.getText().toString();
        String pasword = password_login.getText().toString();

        ArrayList<Meal> mealList = new ArrayList<Meal>();




        ArrayList<Glucometria> glucoList = new ArrayList<Glucometria>();
        glucoList.add(new Glucometria(180));
        glucoList.add(new Glucometria(100));
        glucoList.add(new Glucometria(90));
        glucoList.add(new Glucometria(110));

        User usuario = new User("psuarez", "pasword", "Masculino", 65, 5, "Tipo 2", mealList, glucoList);



        if (name.equals("psuarez") && pasword.equals("pasword")) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("parametro", usuario);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Contraseña Incorrecta",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void goCreateAccount(View view) {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

}