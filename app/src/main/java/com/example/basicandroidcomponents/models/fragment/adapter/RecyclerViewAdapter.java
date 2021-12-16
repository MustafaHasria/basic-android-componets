package com.example.basicandroidcomponents.models.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicandroidcomponents.R;
import com.example.basicandroidcomponents.models.fragment.model.PersonInformationModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    //region Variable
    private List<PersonInformationModel> personInformationModels;
    Context mContext;
    RecyclerViewAdapterClickListener recyclerViewAdapterClickListener;
    //endregion

    //region Constructor
    public RecyclerViewAdapter(List<PersonInformationModel> personInformationModels, Context mContext, RecyclerViewAdapterClickListener recyclerViewAdapterClickListener) {
        this.personInformationModels = personInformationModels;
        this.mContext = mContext;
        this.recyclerViewAdapterClickListener=recyclerViewAdapterClickListener;
    }
    //endregion


    //region Adapter
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.item_for_recycler_view_to_fragment_model,parent,false);
        return new MyViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       // holder.recyclerItemRelativeLayout.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));
        holder.recyclerItemButtonShowProfile.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.left_to_right_animtion_recycler_view));
        holder.recyclerItemTextViewName.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.left_to_right_animtion_recycler_view));
        holder.recyclerItemImageViewPictureProfile.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.left_to_right_animtion_recycler_view));
        holder.recyclerItemImageViewBackgroundPictureProfile.setImageResource(personInformationModels.get(position).getBackgroundPictureProfile());
        holder.recyclerItemImageViewPictureProfile.setImageResource(personInformationModels.get(position).getPictureProfile());
        holder.recyclerItemTextViewName.setText(personInformationModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return personInformationModels.size();
    }

    //endregion

    //region Interface
    public interface RecyclerViewAdapterClickListener{
        void onItemToRecyclerViewButtonShowProfileClickListener(int position, PersonInformationModel personInformationsModel);
    }
    //endregion

    //region View holder
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //region Components
        RelativeLayout recyclerItemRelativeLayout;
        ImageView recyclerItemImageViewBackgroundPictureProfile;
        ImageView recyclerItemImageViewPictureProfile;
        TextView recyclerItemTextViewName;
        Button recyclerItemButtonShowProfile;
        //endregion
        public MyViewHolder(@NonNull View view) {
            super(view);
            recyclerItemRelativeLayout = view.findViewById(R.id.item_for_recycler_view_to_fragment_model_relative_layout);
            recyclerItemImageViewBackgroundPictureProfile = view.findViewById(R.id.item_for_recycler_view_to_fragment_model_image_view_background_picture_profile);
            recyclerItemImageViewPictureProfile = view.findViewById(R.id.item_for_recycler_view_to_fragment_model_image_view_picture_profile);
            recyclerItemTextViewName = view.findViewById(R.id.item_for_recycler_view_to_fragment_model_text_view_name);
            recyclerItemButtonShowProfile = view.findViewById(R.id.item_for_recycler_view_to_fragment_model_button_show_profile);
            recyclerItemButtonShowProfile.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            recyclerViewAdapterClickListener.onItemToRecyclerViewButtonShowProfileClickListener(getAdapterPosition(), personInformationModels.get(getAdapterPosition()));
        }
    }
    //endregion

}
