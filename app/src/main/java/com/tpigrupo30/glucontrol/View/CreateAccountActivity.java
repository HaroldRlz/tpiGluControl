package com.tpigrupo30.glucontrol.View;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tpigrupo30.glucontrol.MainActivity;
import com.tpigrupo30.glucontrol.R;
import com.tpigrupo30.glucontrol.User;
import com.tpigrupo30.glucontrol.View.fragment.HomeFragment;
import com.tpigrupo30.glucontrol.model.Glucometria;
import com.tpigrupo30.glucontrol.model.Meal;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CreateAccountActivity extends AppCompatActivity {

    RadioGroup radio_gender, radio_diabetes;
    RadioButton radioButtonG, radioButtonD;
    Button registerButton;
    TextInputEditText username_register, password_register, weight_register, icr_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        username_register = findViewById(R.id.username_register);
        password_register =  findViewById(R.id.password_register);
        radio_gender = findViewById(R.id.radio_gender);
        weight_register = findViewById(R.id.weight_register);
        icr_register =  findViewById(R.id.icr_register);
        radio_diabetes = findViewById(R.id.radio_diabetes);

        registerButton = findViewById(R.id.registerButton);


       }


    public void goHome(View view){


        String name = username_register.getText().toString();
        String pasword = password_register.getText().toString();

        int radioGenderId = radio_gender.getCheckedRadioButtonId();
        radioButtonG = findViewById(radioGenderId);
        String gender = radioButtonG.getText().toString();

        String weightText = weight_register.getText().toString();
        double weight = Double.parseDouble(weightText);
        String ICRText = icr_register.getText().toString();
        double ICR = Double.parseDouble(ICRText);

        int radioDiabetesId = radio_diabetes.getCheckedRadioButtonId();
        radioButtonD = findViewById(radioDiabetesId);
        String tipo = radioButtonD.getText().toString();

        ArrayList<Meal> mealList = new ArrayList<Meal>();
        ArrayList<Glucometria> glucoList = new ArrayList<Glucometria>();


        User usuario = new User(name, pasword, gender, weight, ICR, tipo, mealList,  glucoList);



        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("parametro", usuario);
        startActivity(intent);
    }




    public void checkButtonD(View v) {
        int radioDId = radio_diabetes.getCheckedRadioButtonId();

        radioButtonD = findViewById(radioDId);


    }

    public void checkButtonG(View v) {
        int radioGId = radio_gender.getCheckedRadioButtonId();

        radioButtonG = findViewById(radioGId);

    }

}
