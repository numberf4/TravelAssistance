package com.number4.travelassistance.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.number4.travelassistance.R;
import com.number4.travelassistance.ui.home.HomeFragment;
import com.number4.travelassistance.ui.map.MapActivity;
import com.number4.travelassistance.ui.map.MapFragment;
import com.number4.travelassistance.ui.notes.NotesFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private Fragment activeFragment;
    private HomeFragment homeFragment = new HomeFragment();
    private MapFragment mapFragment = new MapFragment();
    private NotesFragment notesFragment = new NotesFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.clContainer,homeFragment).commit();
        fragmentManager.beginTransaction().add(R.id.clContainer,mapFragment).hide(mapFragment).commit();
        fragmentManager.beginTransaction().add(R.id.clContainer,notesFragment).hide(notesFragment).commit();
        activeFragment = homeFragment;
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit();
                        activeFragment=homeFragment;
                        return true;
                    case R.id.navigation_map:
                        Intent intent = new Intent(MainActivity.this, MapActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.navigation_notes:
                        fragmentManager.beginTransaction().hide(activeFragment).show(notesFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

}