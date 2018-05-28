package com.tpigrupo30.glucontrol;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tpigrupo30.glucontrol.View.fragment.GraphicsFragment;
import com.tpigrupo30.glucontrol.model.Glucometria;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class add_gluco extends AppCompatActivity {
    User usuario;
    Button addGlucoButton;
    TextInputEditText valorGlucoEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        //User usuario = (User)getIntent().getExtras().getSerializable("parametro");
    }
}
      //  usuario = (User)getIntent().getExtras().getSerializable("parametro");

        //valorGlucoEditText = (TextInputEditText) findViewById(R.id.valorGlucoEditText);
        //addGlucoButton = (Button) findViewById(R.id.addGlucoButton);





    /*
    public void backGluco(View view) {

        double valorGluco = Double.parseDouble(String.valueOf(valorGlucoEditText.getText()));
        ArrayList<Glucometria> arrayListGluco = usuario.getGlucoList();
        arrayListGluco.add(new Glucometria(valorGluco));

        usuario.setGlucoList(arrayListGluco);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("parametro", usuario);
        startActivity(intent);

    }

}
*/