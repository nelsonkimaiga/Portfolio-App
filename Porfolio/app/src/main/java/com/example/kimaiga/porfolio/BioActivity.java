package com.example.kimaiga.porfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by moses on 11/17/15.
 */
public class BioActivity extends AppCompatActivity {

    LinearLayout bio;
    LinearLayout portfolio;
    LinearLayout blog;
    LinearLayout contacts;
    LinearLayout hobbies;


    private static final long RIPPLE_DURATION = 250;


    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.root)
    FrameLayout root;
    @InjectView(R.id.content_hamburger)
    View contentHamburger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bio_activity_layout);
        ButterKnife.inject(this);


        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine_menu_layout, null);
        root.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();

        bio = (LinearLayout) findViewById(R.id.bio_group);
        portfolio = (LinearLayout) findViewById(R.id.portfolio_group);
        blog = (LinearLayout) findViewById(R.id.blog_group);
        contacts = (LinearLayout) findViewById(R.id.contacts_group);
        hobbies = (LinearLayout) findViewById(R.id.hobbies_group);

        bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.bio_group:
                        Intent b = new Intent(BioActivity.this, BioActivity.class);
                        startActivity(b);
                        break;
                }
            }
        });


        portfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.portfolio_group:
                        Intent c = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(c);
                        break;
                }
            }
        });


        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.blog_group:
                        Intent d = new Intent(MainActivity.this, BlogActivity.class);
                        startActivity(d);
                        break;
                }
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.contacts_group:
                        Intent e = new Intent(MainActivity.this, ContactsActivity.class);
                        startActivity(e);
                        break;
                }
            }
        });

        hobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.hobbies_group:
                        Intent f = new Intent(MainActivity.this, HobbiesActivity.class);
                        startActivity(f);
                        break;
                }
            }
        });
    }
}