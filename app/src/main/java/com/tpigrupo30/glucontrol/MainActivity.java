package com.tpigrupo30.glucontrol;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.tpigrupo30.glucontrol.View.fragment.GraphicsFragment;
import com.tpigrupo30.glucontrol.View.fragment.HomeFragment;
import com.tpigrupo30.glucontrol.View.fragment.NutritionFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User usuario = (User)getIntent().getExtras().getSerializable("parametro");

        Toast.makeText(this, usuario.getName(),
                Toast.LENGTH_SHORT).show();

        getIntent().putExtra("parameter",usuario);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);
        bottomBar.setDefaultTab(R.id.home);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId){
                    case R.id.home:
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.graphics:
                        GraphicsFragment graphicsFragment = new GraphicsFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,graphicsFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.nutrition:
                        NutritionFragment nutritionFragment = new NutritionFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,nutritionFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                }
            }
        });
    }
}
