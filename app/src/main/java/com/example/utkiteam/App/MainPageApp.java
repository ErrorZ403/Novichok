package com.example.utkiteam.App;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.utkiteam.Person.Person;
import com.example.utkiteam.R;
import com.example.utkiteam.onboarding.MainActivity;

public class MainPageApp extends AppCompatActivity {

    int mCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_app);

        ImageButton bt_home = findViewById(R.id.bt_home);
        bt_home.setImageResource(R.drawable.home_ch);
        ImageButton bt_list = findViewById(R.id.bt_list);
        ImageButton bt_profile = findViewById(R.id.bt_profile);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navController);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();


        int lvl;
        String name;
        int points;
        //Person person = new Person();


        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mCounter == 2) {

                    bt_home.setImageResource(R.drawable.home_ch);
                    bt_list.setImageResource(R.drawable.ic_list);

                    navController.navigate(R.id.action_pgrogressFragment_to_mapFragment);

                } else if (mCounter == 3) {

                    bt_home.setImageResource(R.drawable.home_ch);
                    bt_profile.setImageResource(R.drawable.ic_profile);

                    navController.navigate(R.id.action_profileFragment_to_mapFragment);

                }
                mCounter = 1;

            }
        });

        bt_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mCounter == 1) {

                    bt_list.setImageResource(R.drawable.list_ch);
                    bt_home.setImageResource(R.drawable.ic_home);

                    navController.navigate(R.id.action_mapFragment_to_pgrogressFragment);

                } else if (mCounter == 3) {

                    bt_list.setImageResource(R.drawable.list_ch);
                    bt_profile.setImageResource(R.drawable.ic_profile);

                    navController.navigate(R.id.action_profileFragment_to_pgrogressFragment);

                }
                mCounter = 2;

            }
        });

        bt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mCounter == 1) {

                    bt_profile.setImageResource(R.drawable.profile_ch);
                    bt_home.setImageResource(R.drawable.ic_home);

                    navController.navigate(R.id.action_mapFragment_to_profileFragment);

                } else if (mCounter == 2) {

                    bt_profile.setImageResource(R.drawable.profile_ch);
                    bt_list.setImageResource(R.drawable.ic_list);

                    navController.navigate(R.id.action_pgrogressFragment_to_profileFragment);

                }
                mCounter = 3;

            }
        });


    }
}