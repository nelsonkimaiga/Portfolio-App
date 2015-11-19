package com.example.kimaiga.porfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.fabric.sdk.android.Fabric;

/**
 * Created by moses on 11/17/15.
 */
public class BioActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "3ki3k32YOJcq1lWczLNulPWuR";
    private static final String TWITTER_SECRET = "H7tXpZPJ3CviTc0ZuJ1OE3WyYJjZ3zvhJCfA1Nr45wqDj0jc1G";


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
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
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
                        Intent b = new Intent(BioActivity.this, BlogActivity.class);
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
                        Intent c = new Intent(BioActivity.this, PortfolioActivity.class);
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
                        Intent d = new Intent(BioActivity.this, BlogActivity.class);
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
                        Intent e = new Intent(BioActivity.this, ContactsActivity.class);
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
                        Intent f = new Intent(BioActivity.this, HobbiesActivity.class);
                        startActivity(f);
                        break;
                }
            }
        });
    }
}