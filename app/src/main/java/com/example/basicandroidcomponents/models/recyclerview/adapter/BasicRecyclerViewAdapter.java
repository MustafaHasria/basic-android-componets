package com.example.basicandroidcomponents.models.recyclerview.adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicandroidcomponents.R;
import com.example.basicandroidcomponents.models.recyclerview.PersonInformation;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class BasicRecyclerViewAdapter extends RecyclerView.Adapter<BasicRecyclerViewAdapter.RViewHolder> {

    //region Variable
    Context mContext;
    public List<PersonInformation> personInformation;
    BasicRecyclerViewAdapterClickListeners basicRecyclerViewAdapterClickListeners;
    //endregion

    //region Constructor
    public BasicRecyclerViewAdapter(Context mContext, List<PersonInformation> personInformation, BasicRecyclerViewAdapterClickListeners basicRecyclerViewAdapterClickListeners) {
        this.mContext = mContext;
        this.personInformation = personInformation;
        this.basicRecyclerViewAdapterClickListeners = basicRecyclerViewAdapterClickListeners;
    }
    //endregion

    //region Adapter
    @NonNull
    @Override
    public RViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.list_item_to_basic_recycler_view, viewGroup, false);
        return new RViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolder holder, int position) {
        holder.itemToRecyclerViewTextViewTitle.setText(personInformation.get(position).getTitle());
        holder.itemToRecyclerViewTextViewContent.setText(personInformation.get(position).getContent());
        holder.itemToRecyclerViewImageViewUser.setImageResource(personInformation.get(position).getUserPhoto());
    }

    @Override
    public int getItemCount() {
        return personInformation.size();
    }
    //endregion

    //region Interface
    public interface BasicRecyclerViewAdapterClickListeners {
        void onItemToRecyclerViewImageViewUserClickListener(PersonInformation personInformation );
    }
    //endregion

    //region View holder
    public class RViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //region Components
        TextView itemToRecyclerViewTextViewTitle;
        TextView itemToRecyclerViewTextViewContent;
        ImageView itemToRecyclerViewImageViewUser;
        RelativeLayout itemToRecyclerViewRelativeLayout;
        //endregion

        public RViewHolder(@NonNull View itemView) {
            super(itemView);
            itemToRecyclerViewTextViewTitle = itemView.findViewById(R.id.item_to_recycler_view_text_view_title);
            itemToRecyclerViewTextViewContent = itemView.findViewById(R.id.item_to_recycler_view_text_view_content);
            itemToRecyclerViewImageViewUser = itemView.findViewById(R.id.item_to_recycler_view_image_view_user);
            itemToRecyclerViewRelativeLayout = itemView.findViewById(R.id.item_to_recycler_view_relative_layout);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            basicRecyclerViewAdapterClickListeners.onItemToRecyclerViewImageViewUserClickListener(personInformation.get(getAdapterPosition()));
        }
    }
    //endregion
}
