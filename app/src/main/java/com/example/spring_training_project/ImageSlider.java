package com.example.spring_training_project;

import android.os.Bundle;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ImageSlider extends AppCompatActivity {

    private ViewPager2 viewPager;

    private TabLayout tabLayout;

    private Switch autoSlide;

    private int[] images = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10
    };



    private  android.os.Handler sliderHandler = new android.os.Handler();

    private final Runnable sliderRunnable = new Runnable() {
        @Override


        public void run() {
            int currentPage = viewPager.getCurrentItem();
            int totalPages = images.length;

            if (currentPage == totalPages - 1) {
                viewPager.setCurrentItem(0);
            } else {
                viewPager.setCurrentItem(currentPage + 1);
            }


            sliderHandler.postDelayed(this, 3000);
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_slider);

        autoSlide = findViewById(R.id.autoSlide);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);



        ImageSliderAdapter adapter = new ImageSliderAdapter(images);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
        }).attach();


        autoSlide.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                startAutoSlide();
            } else {
                stopAutoSlide();
            }
        });
    }



    private void startAutoSlide() {

        sliderHandler.removeCallbacks(sliderRunnable);


        sliderHandler.postDelayed(sliderRunnable, 1000);
    }

    private void stopAutoSlide() {

        sliderHandler.removeCallbacks(sliderRunnable);
    }




    @Override
    protected void onResume() {
        super.onResume();
        if (autoSlide.isChecked()) {
            startAutoSlide();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopAutoSlide();
    }
}