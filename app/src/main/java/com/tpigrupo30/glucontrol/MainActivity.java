package com.tpigrupo30.glucontrol;

import android.app.Fragment;
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

        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);
        bottomBar.setDefaultTab(R.id.home);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId){
                    case R.id.home:
                        bottomBar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        bottomBar.setActiveTabColor(getResources().getColor(R.color.colorSecondaryDark));
                        bottomBar.setBadgeBackgroundColor(getResources().getColor(R.color.colorSecondary));
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment,"homeFrag")
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack("home").commit();
                        break;
                    case R.id.graphics:
                        bottomBar.setBackgroundColor(getResources().getColor(R.color.graph_Color));
                        bottomBar.setActiveTabColor(getResources().getColor(R.color.colorSecondaryDark));
                        bottomBar.setBadgeBackgroundColor(getResources().getColor(R.color.colorSecondary));
                        GraphicsFragment graphicsFragment = new GraphicsFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,graphicsFragment,"graphFrag")
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack("home").commit();
                        break;
                    case R.id.nutrition:
                        bottomBar.setBackgroundColor(getResources().getColor(R.color.nutrition_Color));
                        bottomBar.setActiveTabColor(getResources().getColor(R.color.colorSecondaryDark));
                        bottomBar.setBadgeBackgroundColor(getResources().getColor(R.color.colorSecondary));
                        NutritionFragment nutritionFragment = new NutritionFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,nutritionFragment,"nutritionFrag")
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .addToBackStack("home").commit();
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        android.support.v4.app.Fragment home = getSupportFragmentManager().findFragmentByTag("homeFrag");
        BottomBar bottomBarClose = (BottomBar) findViewById(R.id.bottombar);
        if(home instanceof HomeFragment && home.isVisible()){
            moveTaskToBack(true);
        }else {
            //getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment());
            //super.onBackPressed();
            //getSupportFragmentManager().popBackStack();
            bottomBarClose.selectTabWithId(R.id.home);
        }
    }
}
