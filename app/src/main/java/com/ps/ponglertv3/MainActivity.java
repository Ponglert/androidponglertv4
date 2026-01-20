package com.ps.ponglertv3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        Fragment homefragment = new HomeFragment();
        Fragment profilefragment = new ProfileFragment();
        Fragment settingfragment = new SettingFragment();

        setCurrentFragment(homefragment);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if(id == R.id.home){
                setCurrentFragment(homefragment);
                return true;
            }
            else if(id == R.id.profile){
                setCurrentFragment(profilefragment);
                return true;
            }
            else if(id == R.id.settings){
                setCurrentFragment(settingfragment);
                return true;
            }
            return false;
        });
    }

    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit();
    }
}