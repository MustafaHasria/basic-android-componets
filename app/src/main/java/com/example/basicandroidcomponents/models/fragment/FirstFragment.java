package com.example.basicandroidcomponents.models.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicandroidcomponents.R;
import com.example.basicandroidcomponents.models.fragment.adapter.RecyclerViewAdapter;
import com.example.basicandroidcomponents.models.fragment.model.PersonInformationModel;
import com.example.basicandroidcomponents.utility.AppConst;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements RecyclerViewAdapter.RecyclerViewAdapterClickListener {
    //region Component
    RecyclerView fragmentFirstRecyclerView;
    Button recyclerItemButtonShowProfile;
    //endregion

    //region Variable
    private List<PersonInformationModel> personInformationModels;
    RecyclerViewAdapter recyclerViewAdapter;
    //endregion

    //region life cycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        personInformationModels = new ArrayList<>();
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_1));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_2));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_3));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_4));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_5));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_6));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_7));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_female_1));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_female_2));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_female_3));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_female_4));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_female_5));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_female_6));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_4));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_4));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_1));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_2));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_5));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_female_7));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_female_7));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_female_7));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_1));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_6));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_female_7));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_male_7));
        personInformationModels.add(new PersonInformationModel("TAREK HENDI","Study At Cordoba University",R.drawable.image_background_for_recycler_view_in_fragment_model,R.drawable.photo_female_7));
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.first_fragment_in_fragment_model, container, false);

        fragmentFirstRecyclerView = view.findViewById(R.id.first_fragment_in_fragment_model_recycler_view);
        recyclerItemButtonShowProfile = view.findViewById(R.id.item_for_recycler_view_to_fragment_model_button_show_profile);


        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(personInformationModels,getContext(),this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        fragmentFirstRecyclerView.setLayoutManager(linearLayoutManager);
        fragmentFirstRecyclerView.setAdapter(recyclerViewAdapter);

        fragmentFirstRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        fragmentFirstRecyclerView.setAdapter(recyclerViewAdapter);

        return view;



    }
    //endregion

    //region Adapter click listeners
    @Override
    public void onItemToRecyclerViewButtonShowProfileClickListener(int position, PersonInformationModel personInformationsModel) {
        SecondFragment secondFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConst.NAME, personInformationsModel.getName());
        bundle.putString(AppConst.DESCRIPTION, personInformationsModel.getDescription());
        bundle.putInt(AppConst.PICTURE_PROFILE, personInformationsModel.getPictureProfile());

        secondFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_activity_for_fragment_model_frame_layout, secondFragment)
                .commit();
    }
    //endregion
}