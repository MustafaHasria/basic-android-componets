package com.example.basicandroidcomponents.models.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.basicandroidcomponents.R;
import com.example.basicandroidcomponents.models.bottomnavigation.BottomNavigationActivity;
import com.example.basicandroidcomponents.models.bottomnavigation.Fragment.ViewPagerAdapter;
import com.example.basicandroidcomponents.models.main.adapter.MyExpandableListAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //region Components
    ExpandableListView expandableListView;
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
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.elvMobiles);

        createGroupList();
        createCollection();
        expandableListAdapter = new MyExpandableListAdapter(this, mobileCollection, groupList);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;

            @Override
            public void onGroupExpand(int i) {
                if (lastExpandedPosition != -1 && i != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });
        expandableListView.setOnChildClickListener((expandableListView, view, i, i1, l) -> {
            String selected = expandableListAdapter.getChild(i, i1).toString();
            switch (selected) {
                case "Basic":
                    Intent intent = new Intent(this, BottomNavigationActivity.class);
                    startActivity(intent);
            }
            return true;
        });
    }
    //endregion


    //region methods
    private void createCollection() {
        String[] bottomNavigationSub = {"Basic"};
        mobileCollection = new HashMap<String, List<String>>();

        for (String group : groupList) {
            if (group.equals("Bottom Navigation")) {
                loadChild(bottomNavigationSub);
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
    }
    //endregion
}