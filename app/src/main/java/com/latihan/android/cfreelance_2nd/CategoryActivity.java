package com.latihan.android.cfreelance_2nd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.latihan.android.cfreelance_2nd.Model.Category;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoriesRecyclerView;
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        categoriesRecyclerView = findViewById(R.id.categoriesRecyclerView);

        adapter = new CategoryAdapter(this);
        categoriesRecyclerView.setAdapter(adapter);
        categoriesRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Category> categories = new ArrayList<>();

        categories.add(new Category("Mobile Application", "https://safogroup.cz/wp-content/uploads/2016/07/webAPP.jpg"));
        categories.add(new Category("Web Programming", "https://miro.medium.com/max/600/0*npRqA-IodJWs4jae.jpg"));
        categories.add(new Category("Game Application", "https://images.macrumors.com/t/thJ025jE773VDQf0WyYC9L8uKpc=/1600x900/smart/article-new/2020/12/apple-top-apps-games-2020.jpg"));
        categories.add(new Category("Chat Bot", "https://image.freepik.com/free-vector/chat-robot-head-monogram-logo-chatbot-logo-design-template_72830-26.jpg"));
        adapter.setCategories(categories);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.navCategoryMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()){
                    case R.id.navHomeMenu:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navCategoryMenu:
//                        startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
//                        overridePendingTransition(0,0);
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