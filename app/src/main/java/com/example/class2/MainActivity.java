package com.example.class2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayId);

        // tool bar set up
        toolbar = findViewById(R.id.mToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        toolbar.setTitleTextColor(Color.WHITE);

        //Navigation set up

        navigationView = findViewById(R.id.navViewId);

        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.navigation_open, R.string.navigation_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(Color.WHITE);
        actionBarDrawerToggle.syncState();

        bottomNavigationView = findViewById(R.id.bottomNavId);
        BottomNavHelper.disabledShiftMode(bottomNavigationView);



        navigationView.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id==R.id.settingsId){

                    Toast.makeText(MainActivity.this, "Settings is clicked", Toast.LENGTH_SHORT).show();
                }

                else if (id == R.id.shareId){

//                    Toast.makeText(MainActivity.this, "Share is clicked", Toast.LENGTH_SHORT).show();

                    Snackbar snackbar = Snackbar.make(drawerLayout, "Share is clicked", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    snackbar.setAction("Okay", new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "Nothing happen", Toast.LENGTH_SHORT).show();


                        }
                    });
                }

                else if (id == R.id.logoutId){

                    Toast.makeText(MainActivity.this, "Logout is clicked", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });
    }


}
