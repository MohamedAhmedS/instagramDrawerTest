package com.instagramdrawertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class RevealActivity extends AppCompatActivity {

    MainActivity.RevealAnimation mRevealAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal);

        Intent intent = this.getIntent();   //get the intent to recieve the x and y coords, that you passed before

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.root_layout); //there you have to get the root layout of your second activity
        mRevealAnimation = new MainActivity.RevealAnimation(rootLayout, intent, this);
    }

    @Override
    public void onBackPressed()
    {
        mRevealAnimation.unRevealActivity();
    }
}