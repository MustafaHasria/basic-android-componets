package com.example.basicandroidcomponents.models.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicandroidcomponents.R;
import com.example.basicandroidcomponents.models.recyclerview.PersonInformation;

import java.util.List;

public class RecyclerViewWithAnimationAdapter extends RecyclerView.Adapter<RecyclerViewWithAnimationAdapter.ViewHolder> {
    //region Variable
    Context mContext;
    List<PersonInformation> personInformations;
    boolean isDark = false;
    RecyclerViewWithAnimationAdapterListeners recyclerViewWithAnimationAdapterListeners;
    //endregion

    //region Constructor
    public RecyclerViewWithAnimationAdapter(Context context, List<PersonInformation> personInformations, boolean isDark, RecyclerViewWithAnimationAdapterListeners recyclerViewWithAnimationAdapterListeners) {
        this.mContext = context;
        this.personInformations = personInformations;
        this.isDark = isDark;
        this.recyclerViewWithAnimationAdapterListeners = recyclerViewWithAnimationAdapterListeners;
    }
    //endregion

    //region Adapter
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.list_item_to_recyclerview_with_animation_left_to_right, viewGroup, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.listItemToRecyclerviewWithAnimationLeftToRightImageView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_to_right_animtion_recycler_view));
        holder.listItemToRecyclerviewWithAnimationLeftToRightRelativeViewContainer.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_to_right_2_animtion_recycler_view));
        holder.listItemToRecyclerViewWithAnimationLeftToRightTextViewTitle.setText(personInformations.get(position).getTitle());
        holder.listItemToRecyclerViewWithAnimationLeftToRightTextViewContent.setText(personInformations.get(position).getContent());
        holder.listItemToRecyclerViewWithAnimationLeftToRightTextViewDate.setText(personInformations.get(position).getDate());
        holder.listItemToRecyclerviewWithAnimationLeftToRightImageView.setImageResource(personInformations.get(position).getUserPhoto());
    }

    @Override
    public int getItemCount() {
        return personInformations.size();
    }
    //endregion

    //region Interface
    public interface RecyclerViewWithAnimationAdapterListeners {
        void onListItemToRecyclerviewWithAnimationLeftToRightRelativeViewContainerClickListener(int position, PersonInformation personInformation);
    }
    //endregion

    //region View holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView listItemToRecyclerViewWithAnimationLeftToRightTextViewTitle;
        TextView listItemToRecyclerViewWithAnimationLeftToRightTextViewContent;
        TextView listItemToRecyclerViewWithAnimationLeftToRightTextViewDate;
        ImageView listItemToRecyclerviewWithAnimationLeftToRightImageView;
        RelativeLayout listItemToRecyclerviewWithAnimationLeftToRightRelativeViewContainer;
        ConstraintLayout listItemToRecyclerviewWithAnimationLeftToRightConstraintMainContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listItemToRecyclerViewWithAnimationLeftToRightTextViewTitle = itemView.findViewById(R.id.list_item_to_recyclerview_with_animation_left_to_right_text_view_title);
            listItemToRecyclerViewWithAnimationLeftToRightTextViewContent = itemView.findViewById(R.id.list_item_to_recyclerview_with_animation_left_to_right_text_view_content);
            listItemToRecyclerViewWithAnimationLeftToRightTextViewDate = itemView.findViewById(R.id.list_item_to_recyclerview_with_animation_left_to_right_text_view_date);
            listItemToRecyclerviewWithAnimationLeftToRightImageView = itemView.findViewById(R.id.list_item_to_recyclerview_with_animation_left_to_right_image_view);
            listItemToRecyclerviewWithAnimationLeftToRightRelativeViewContainer = itemView.findViewById(R.id.list_item_to_recyclerview_with_animation_left_to_right_relative_layout_container);
            listItemToRecyclerviewWithAnimationLeftToRightConstraintMainContainer = itemView.findViewById(R.id.list_item_to_recyclerview_with_animation_left_to_right_constraint_main_container);
            if (isDark) {
                setDarkTheme();
            }

            listItemToRecyclerviewWithAnimationLeftToRightConstraintMainContainer.setOnClickListener(this);
        }

        private void setDarkTheme() {
            listItemToRecyclerviewWithAnimationLeftToRightRelativeViewContainer.setBackgroundResource(R.drawable.background_for_recycler_view_item_dark_theme);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.list_item_to_recyclerview_with_animation_left_to_right_constraint_main_container:
                    recyclerViewWithAnimationAdapterListeners.onListItemToRecyclerviewWithAnimationLeftToRightRelativeViewContainerClickListener(getAdapterPosition(), personInformations.get(getAdapterPosition()));
            }
        }
    }
    //endregion
}
