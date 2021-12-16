package com.example.basicandroidcomponents.models.recyclerview;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicandroidcomponents.R;
import com.example.basicandroidcomponents.databinding.ActivityMainBinding;
import com.example.basicandroidcomponents.databinding.ActivityRecyclerviewWithAnimationLeftToRightBinding;
import com.example.basicandroidcomponents.models.recyclerview.adapter.RecyclerViewWithAnimationAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewWithAnimationLeftToRightActivity extends AppCompatActivity implements RecyclerViewWithAnimationAdapter.RecyclerViewWithAnimationAdapterListeners {
    //region Components
    ActivityRecyclerviewWithAnimationLeftToRightBinding binding;
    RecyclerView recyclerviewWithAnimationLefToRightMainRecyclerView;
    RecyclerViewWithAnimationAdapter recyclerViewWithAnimationAdapter;
    FloatingActionButton recyclerviewWithAnimationLefToRightMainFloatingActionButton;
    ConstraintLayout recyclerviewWithAnimationLeftToRightMainConstraintLayout;
    //endregion

    //region Variables
    List<PersonInformation> personInformations;
    boolean isDark = false;
    //endregion

    //region Life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding= ActivityRecyclerviewWithAnimationLeftToRightBinding.inflate(getLayoutInflater());
        // let's make this activity on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());


        // load theme state

        isDark = getThemeStatePref();
        if(isDark)
        {
            // dark theme is on
            binding.recyclerviewWithAnimationLeftToRightMainConstraintLayout.setBackgroundColor(getResources().getColor(R.color.black));
        }

        else
        {
            // light theme is on
            binding.recyclerviewWithAnimationLeftToRightMainConstraintLayout.setBackgroundColor(getResources().getColor(R.color.white));
        }

        personInformations = new ArrayList<>();
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_female_1));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_female_2));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_female_3));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_female_4));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_female_5));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_female_6));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_female_7));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_female_8));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_male_1));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_male_3));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_male_4));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_male_5));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_female_6));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_female_7));
        personInformations.add(new PersonInformation("OnePlus 6T Camera Review:","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","6 july 1994",R.drawable.photo_female_8));

        //region Adapter Ini And setup
        recyclerViewWithAnimationAdapter = new RecyclerViewWithAnimationAdapter(this,personInformations,isDark, this);
        binding.recyclerviewWithAnimationLeftToRightMainRecyclerView.setAdapter(recyclerViewWithAnimationAdapter);
        binding.recyclerviewWithAnimationLeftToRightMainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //endregion

        binding.recyclerviewWithAnimationLeftToRightMainFloatingActionButton.setOnClickListener(v -> {
            isDark = !isDark ;
            if (isDark) {

                binding.recyclerviewWithAnimationLeftToRightMainConstraintLayout.setBackgroundColor(getResources().getColor(R.color.black));

            }
            else {
                binding.recyclerviewWithAnimationLeftToRightMainConstraintLayout.setBackgroundColor(getResources().getColor(R.color.white));
            }

            recyclerViewWithAnimationAdapter = new RecyclerViewWithAnimationAdapter(getApplicationContext(),personInformations,isDark, this);
            binding.recyclerviewWithAnimationLeftToRightMainRecyclerView.setAdapter(recyclerViewWithAnimationAdapter);
            saveThemeStatePref(isDark);




        });

    }
    //endregion

    //region methods
    private void saveThemeStatePref(boolean isDark) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark",isDark);
        editor.commit();
    }

    private boolean getThemeStatePref () {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark",false) ;
        return isDark;

    }

    //endregion

    //region Adapter click listeners
    @Override
    public void onListItemToRecyclerviewWithAnimationLeftToRightRelativeViewContainerClickListener(int position, PersonInformation personInformation) {
        Toast.makeText(this, personInformation.getTitle(), Toast.LENGTH_SHORT).show();
    }
    //endregion

}

