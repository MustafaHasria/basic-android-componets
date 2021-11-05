package com.example.basicandroidcomponents.models.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.basicandroidcomponents.R;
import com.example.basicandroidcomponents.databinding.ActivityBotomNavigationBinding;
import com.example.basicandroidcomponents.models.bottomnavigation.Fragment.ViewPagerAdapter;
import com.example.basicandroidcomponents.models.bottomnavigation.animationviewpager.ZoomOutPageTransformer;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationActivity extends AppCompatActivity {
    //region Components
    ActivityBotomNavigationBinding binding;
    private ViewPager mainViewPager;
    private BottomNavigationView bottomNavigation;
    //endregion

    //region Variables
    ViewPagerAdapter viewPagerAdapter;
    //endregion

    //region Life Cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityBotomNavigationBinding.inflate(getLayoutInflater());
        //region Find view by id
        setContentView(binding.getRoot());

//        bottomNavigation = findViewById(R.id.bottom_navigation_bottom_navigation);
//        mainViewPager = findViewById(R.id.bottom_navigation_view_pager);

        //animation
        binding.bottomNavigationViewPager.setPageTransformer(true,new ZoomOutPageTransformer());
        //endregion
        setupViewPager();

        binding.bottomNavigationViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        binding.bottomNavigationBottomNavigation.getMenu().findItem(R.id.navigation_home).setChecked(true);
                        break;
                    case 1:
                        binding.bottomNavigationBottomNavigation.getMenu().findItem(R.id.navigation_category).setChecked(true);
                        break;
                    case 2:
                        binding.bottomNavigationBottomNavigation.getMenu().findItem(R.id.navigation_notifications).setChecked(true);
                        break;
                    case 3:
                        binding.bottomNavigationBottomNavigation.getMenu().findItem(R.id.navigation_profile).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        binding.bottomNavigationBottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    binding.bottomNavigationViewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_category:
                    binding.bottomNavigationViewPager.setCurrentItem(1);
                    break;
                case R.id.navigation_notifications:
                    binding.bottomNavigationViewPager.setCurrentItem(2);
                    break;
                case R.id.navigation_profile:
                    binding.bottomNavigationViewPager.setCurrentItem(3);
                    break;
            }
            return true;
        });
    }
    //endregion

    //region Setups
    private void setupViewPager() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.bottomNavigationViewPager.setAdapter(viewPagerAdapter);
    }
    //endregion
}