package com.example.basicandroidcomponents.models.fragment;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basicandroidcomponents.R;

public class MainActivityFragment extends AppCompatActivity {

    //region Components
    public TextView mainActivityForFragmentModelTextView;
    //endregion

    //region Life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();

        setContentView(R.layout.main_activity_for_fragment_model);
        mainActivityForFragmentModelTextView = findViewById(R.id.main_activity_for_fragment_model_text_view);

        setFirstFragmentInMainActivity();
    }
    //endregion

    //region methods
    private void setFirstFragmentInMainActivity() {
        // FirstFragment mainFragment = new FirstFragment();
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.add(R.id.main_activity_frame_layout,mainFragment);
        //fragmentTransaction.commit();
        getSupportFragmentManager()
                .beginTransaction()
//                .disallowAddToBackStack()
                .replace(R.id.main_activity_for_fragment_model_frame_layout,new FirstFragment())
                .commit();
    }
    //endregion
}