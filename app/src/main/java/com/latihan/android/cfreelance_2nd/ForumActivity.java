package com.latihan.android.cfreelance_2nd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.latihan.android.cfreelance_2nd.Model.Forum;

import java.util.ArrayList;

public class ForumActivity extends AppCompatActivity {

    private RecyclerView forumsRecyclerView;
    private ForumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        forumsRecyclerView = findViewById(R.id.forumsRecyclerView);
        adapter = new ForumAdapter(this);
        forumsRecyclerView.setAdapter(adapter);
        forumsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Forum> forums = new ArrayList<>();

        forums.add(new Forum("@AndikaPutra", "Help me with my exam please!", "I am Currently doing exam, and i dont know what's the solution", "https://media.cheggcdn.com/media/47b/47b04de1-ea8f-48fc-844b-88e215d44b0f/php2gXjh5.png"));
        forums.add(new Forum("@AlifFerdiansyah", "About public static final...", "", "https://martin-thoma.com/images/2012/04/latex-java-source-listings.png"));
        forums.add(new Forum("@AureliusElvin", "Why banana in javascript is weird?", "I am Currently doing exam, and i dont know what's the solution", "https://res.cloudinary.com/practicaldev/image/fetch/s--_50npOT6--/c_imagga_scale,f_auto,fl_progressive,h_420,q_auto,w_1000/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/fpb2nie6shwi236igmsg.jpg"));
        forums.add(new Forum("@MadeYoga", "How to debug this?", "I'm a beginner and don't know how programming works", "https://cdn.crunchify.com/wp-content/uploads/2014/09/Have-you-noticed-Race-Condition-in-Java-Multi-threading-Concurrency-Example.png"));
        forums.add(new Forum("@JasonJason", "Why programming is boring???", "Programming is just so boring for me", "https://www.tatti.in/wp-content/uploads/2020/06/Why-Choose-Programming-Language-1.jpg"));
        adapter.setForums(forums);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.navForumMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navHomeMenu:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navCategoryMenu:
                        startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navForumMenu:
                        return true;
                    case R.id.navCartMenu:
//                        startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
//                        overridePendingTransition(0,0);
                        Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
    }
}