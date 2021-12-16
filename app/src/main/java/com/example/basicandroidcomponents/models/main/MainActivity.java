package com.example.basicandroidcomponents.models.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basicandroidcomponents.databinding.ActivityMainBinding;
import com.example.basicandroidcomponents.models.bottomnavigation.BottomNavigationActivity;
import com.example.basicandroidcomponents.models.bottomsheetdialog.BasicBottomSheetDialog;
import com.example.basicandroidcomponents.models.bottomsheetdialog.MapModernBottomSheetDialog;
import com.example.basicandroidcomponents.models.fragment.MainActivityFragment;
import com.example.basicandroidcomponents.models.main.adapter.MyExpandableListAdapter;
import com.example.basicandroidcomponents.models.recyclerview.BasicRecyclerViewActivity;
import com.example.basicandroidcomponents.models.recyclerview.RecyclerViewWithAnimationLeftToRightActivity;
import com.example.basicandroidcomponents.models.steppers.MainActivitySteppers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //region Components
    ActivityMainBinding binding;
    ExpandableListView mainExpandable;
    //endregion

    //region Variables
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> mobileCollection;
    ExpandableListAdapter expandableListAdapter;
    //endregion

    //region life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());

        // let's make this activity on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());

       // expandableListView = findViewById(R.id.elvMobiles);

        createGroupList();
        createCollection();
        expandableListAdapter = new MyExpandableListAdapter(this, mobileCollection, groupList);
        binding.mainExpandable.setAdapter(expandableListAdapter);
        binding.mainExpandable.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;

            @Override
            public void onGroupExpand(int i) {
                if (lastExpandedPosition != -1 && i != lastExpandedPosition) {
                    binding.mainExpandable.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });
        binding.mainExpandable.setOnChildClickListener((expandableListView, view, i, i1, l) -> {
            String selected = expandableListAdapter.getChild(i, i1).toString();

            if ("Basic Bottom Navigation Activity".equals(selected)) {
                Intent intent = new Intent(this, BottomNavigationActivity.class);
                startActivity(intent);
            }
            else if ("Basic Bottom Sheet Dialog".equals(selected))
            {
                Intent intent = new Intent(this, BasicBottomSheetDialog.class);
                startActivity(intent);
            }
            else if ("Map Bottom Sheet Dialog".equals(selected))
            {
                Intent intent = new Intent(this, MapModernBottomSheetDialog.class);
                startActivity(intent);
            }
            else if ("Wizard Color".equals(selected))
            {
                Intent intent = new Intent(this, MainActivitySteppers.class);
                startActivity(intent);
            }
            else if ("Animation Left To Right".equals(selected))
            {
                Intent intent = new Intent(this, RecyclerViewWithAnimationLeftToRightActivity.class);
                startActivity(intent);
            }
            else if ("Basic".equals(selected))
            {
                Intent intent = new Intent(this, BasicRecyclerViewActivity.class);
                startActivity(intent);
            }
            else if ("Basic Fragments".equals(selected))
            {
                Intent intent = new Intent(this, MainActivityFragment.class);
                startActivity(intent);
            }
            return true;
        });
    }

    //endregion

    //region methods
    private void createCollection() {
        String[] bottomNavigationSub = {"Basic Bottom Navigation Activity"};
        String[] bottomSheetSub = {"Basic Bottom Sheet Dialog","Map Bottom Sheet Dialog"};
        String[] steppersSub = {"Wizard Color"};
        String[] RecyclerView = {"Animation Left To Right","Basic"};
        String[] Fragment = {"Basic Fragments"};
        mobileCollection = new HashMap<>();

        for (String group : groupList) {
            if (group.equals("Bottom Navigation")) {
                loadChild(bottomNavigationSub);
            }
            else if (group.equals("Bottom Sheet"))
            {
                loadChild(bottomSheetSub);
            }
            else if (group.equals("Steppers"))
            {
                loadChild(steppersSub);
            }
            else if (group.equals("Recycler View"))
            {
                loadChild(RecyclerView);
            }
            else if (group.equals("Fragment"))
            {
                loadChild(Fragment);
            }
            mobileCollection.put(group, childList);
        }
    }

    private void loadChild(String[] mobileModels) {
        childList = new ArrayList<>();
//        for(String model : mobileModels){
//            childList.add(model);
//        }
        // we refactor the above function
        Collections.addAll(childList, mobileModels);

    }

    private void createGroupList() {
        groupList = new ArrayList<>();
        groupList.add("Bottom Navigation");
        groupList.add("Bottom Sheet");
        groupList.add("Steppers");
        groupList.add("Recycler View");
        groupList.add("Fragment");
    }


    private void saveThemeStatePref(boolean isDark) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark",isDark);
        editor.commit();
    }

    private boolean getThemeStatePref() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark",false) ;
        return isDark;
    }
    //endregion
}