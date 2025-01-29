package com.example.spring_training_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView appName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.appName);

        AlphaAnimation fade = new AlphaAnimation(0f, 1f);
        fade.setDuration(4000);
        fade.setFillAfter(true);

        TranslateAnimation moveUp = new TranslateAnimation(0, 0, 4000, 0);
        moveUp.setDuration(4000);
        moveUp.setFillAfter(true);

        AnimationSet all = new AnimationSet(true);
        all.addAnimation(fade);
        all.addAnimation(moveUp);


        logo.startAnimation(all);
        appName.startAnimation(all);

        logo.startAnimation(fade);
        appName.startAnimation(fade);


        new Handler().postDelayed(() -> {
            startActivity(new Intent(MainActivity.this, HomePage.class));
        }, 4000);


    }
}