package com.example.basicandroidcomponents.models.steppers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.basicandroidcomponents.R;
import com.example.basicandroidcomponents.databinding.ActivityMainSteppersBinding;

public class MainActivitySteppers extends AppCompatActivity {

    //region component
    ActivityMainSteppersBinding binding;
    TextView[] dots;
    //endregion

    //region Variables
    ViewPagerAdapter viewPagerAdapter;
    //endregion


    //region life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainSteppersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.activityMainSteppersButtonBack.setOnClickListener(v -> {

            if (getitem(0) > 0){

                binding.activityMainSteppersViewPagerSlide.setCurrentItem(getitem(-1),true);
            }

        });

        binding.activityMainSteppersButtonNext.setOnClickListener(v -> {

            if (getitem(0) < 3)
                binding.activityMainSteppersViewPagerSlide.setCurrentItem(getitem(1),true);
            else {

                Intent i = new Intent(MainActivitySteppers.this,MainScreen.class);
                startActivity(i);
                finish();

            }

        });

        binding.activityMainSteppersButtonSkip.setOnClickListener(v -> {


            Intent i = new Intent(MainActivitySteppers.this,MainScreen.class);
            startActivity(i);
            finish();

        });


        viewPagerAdapter = new ViewPagerAdapter(this);
        binding.activityMainSteppersViewPagerSlide.setAdapter(viewPagerAdapter);

        setUpindicator(0);
        binding.activityMainSteppersViewPagerSlide.addOnPageChangeListener(viewListener);
    }
    //endregion
    //region methods
    public void setUpindicator(int position){

        dots = new TextView[4];
        binding.activityMainSteppersLinearLayout.removeAllViews();

        for (int i = 0 ; i < dots.length ; i++){

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));
            binding.activityMainSteppersLinearLayout.addView(dots[i]);

        }

        dots[position].setTextColor(getResources().getColor(R.color.active,getApplicationContext().getTheme()));

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            setUpindicator(position);

            if (position > 0)
            {
                binding.activityMainSteppersButtonBack.setVisibility(View.VISIBLE);
            }

            else
            {
                binding.activityMainSteppersButtonBack.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state)
        {

        }
    };

    private int getitem(int i){

        return binding.activityMainSteppersViewPagerSlide.getCurrentItem() + i;
    }
    //endregion
}