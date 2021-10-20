package com.example.basicandroidcomponents.models.main.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.basicandroidcomponents.R;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    //region Variables
    private Context context;
    private Map<String, List<String>> mobileCollection;
    private List<String> groupList;
    //endregion

    public MyExpandableListAdapter(Context context, Map<String, List<String>> mobileCollection, List<String> groupList) {
        this.context = context;
        this.mobileCollection = mobileCollection;
        this.groupList = groupList;
    }

    @Override
    public int getGroupCount() {
        return mobileCollection.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return Objects.requireNonNull(mobileCollection.get(groupList.get(i))).size();
    }

    @Override
    public Object getGroup(int i) {
        return groupList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return Objects.requireNonNull(mobileCollection.get(groupList.get(i))).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String mobileName = getGroup(i).toString();
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.group_item, null);
        }
        TextView item = view.findViewById(R.id.mobile);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(mobileName);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String model = getChild(i, i1).toString();
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.child_item, null);
        }
        TextView item = view.findViewById(R.id.model);
        item.setText(model);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
