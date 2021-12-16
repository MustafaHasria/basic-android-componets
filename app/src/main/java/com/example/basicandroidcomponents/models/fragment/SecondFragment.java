package com.example.basicandroidcomponents.models.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.basicandroidcomponents.R;


public class SecondFragment extends Fragment {

    //region Component
    private View view;
    ImageView secondFragmentImageViewPersonPicture;
    TextView secondFragmentTextViewName,secondFragmentTextViewDescription;
    //endregion

    //region life cycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.second_fragment_in_fragment_model, container, false);

        secondFragmentImageViewPersonPicture = view.findViewById(R.id.second_fragment_in_fragment_model_image_view_person_picture);
        secondFragmentTextViewName = view.findViewById(R.id.second_fragment_in_fragment_model_text_view_name);
        secondFragmentTextViewDescription = view.findViewById(R.id.second_fragment_in_fragment_model_text_view_description);

        return view;
    }
    //endregion
}