package com.example.basicandroidcomponents;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.basicandroidcomponents.Fragment.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    //region Components
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

        //region Find view by id
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.main_bottom_navigation);
        mainViewPager = findViewById(R.id.main_view_pager);
        //endregion

        setupViewPager();

        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        bottomNavigation.getMenu().findItem(R.id.navigation_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigation.getMenu().findItem(R.id.navigation_category).setChecked(true);
                        break;
                    case 2:
                        bottomNavigation.getMenu().findItem(R.id.navigation_notifications).setChecked(true);
                        break;
                    case 3:
                        bottomNavigation.getMenu().findItem(R.id.navigation_profile).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mainViewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_category:
                    mainViewPager.setCurrentItem(1);
                    break;
                case R.id.navigation_notifications:
                    mainViewPager.setCurrentItem(2);
                    break;
                case R.id.navigation_profile:
                    mainViewPager.setCurrentItem(3);
                    break;
            }
            return true;
        });
    }
    //endregion

    //region Setups
    private void setupViewPager() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mainViewPager.setAdapter(viewPagerAdapter);
    }
    //endregion
}