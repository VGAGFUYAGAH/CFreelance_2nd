package com.latihan.android.cfreelance_2nd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);










        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.navHomeMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navHomeMenu:
//                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navCategoryMenu:
                        startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navForumMenu:
//                        startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
//                        overridePendingTransition(0,0);
                        Toast.makeText(getApplicationContext(), "OnGoing Project", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navCartMenu:
//                        startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
//                        overridePendingTransition(0,0);
                        Toast.makeText(getApplicationContext(), "OnGoing Project", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });

    }
}