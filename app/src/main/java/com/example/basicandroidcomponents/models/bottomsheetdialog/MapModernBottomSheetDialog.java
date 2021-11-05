package com.example.basicandroidcomponents.models.bottomsheetdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.basicandroidcomponents.R;
import com.example.basicandroidcomponents.databinding.ActivityMapModernBottomSheetDialogBinding;

public class MapModernBottomSheetDialog extends AppCompatActivity
{
    //region Component
    ActivityMapModernBottomSheetDialogBinding binding;
    Button yes , no;
    Dialog dialog;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityMapModernBottomSheetDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //yes=findViewById(R.id.yes);
        //no=findViewById(R.id.no);

        binding.yes.setOnClickListener(view -> {

            ShowDialog("yes","Basic Android Component","Thank For Watching");

        });

        binding.no.setOnClickListener(view ->
        {
            ShowSadDialog("no","Basic Android Component","Thank For Watching");
        });

    }

    private void ShowSadDialog(String no, String t3, String t4) {
        Button backs;
        TextView tv3 , tv4;
        LottieAnimationView status2;
        dialog = new Dialog(MapModernBottomSheetDialog.this);
        dialog.setContentView(R.layout.bottom_sheet_no);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        window.getAttributes().windowAnimations=R.style.DialogAnimation;
        backs=dialog.findViewById(R.id.backs);
        tv3=dialog.findViewById(R.id.t3);
        tv4=dialog.findViewById(R.id.t4);
        status2=dialog.findViewById(R.id.animation_view2);
        tv3.setText(t3);
        tv4.setText(t4);


        if (no.equals("no"))
        {
            status2.setAnimation(R.raw.sad);
            tv3.setTextColor(getResources().getColor(R.color.green));
            backs.setBackgroundResource(R.drawable.no_button_background);
        }

        backs.setOnClickListener(view -> {

            dialog.dismiss();
        });

        dialog.setCancelable(true);
        window.setLayout(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }


    private void ShowDialog(String yes, String t1, String t2) {
        Button back;
        TextView tv1 , tv2;
        LottieAnimationView status;

        dialog = new Dialog(MapModernBottomSheetDialog.this);
        dialog.setContentView(R.layout.bottom_sheet_ok);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        window.getAttributes().windowAnimations=R.style.DialogAnimation;

        back=dialog.findViewById(R.id.back);
        tv1=dialog.findViewById(R.id.t1);
        tv2=dialog.findViewById(R.id.t2);
        status=dialog.findViewById(R.id.animation_view);

        tv1.setText(t1);
        tv2.setText(t2);

        if (yes.equals("Yes"))
        {
            status.setAnimation(R.raw.ok_happy);
            tv1.setTextColor(getResources().getColor(R.color.green));
            back.setBackgroundResource(R.drawable.yes_button_background);

        }

        back.setOnClickListener(view -> {

            dialog.dismiss();

        });

        dialog.setCancelable(true);
        window.setLayout(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }
}