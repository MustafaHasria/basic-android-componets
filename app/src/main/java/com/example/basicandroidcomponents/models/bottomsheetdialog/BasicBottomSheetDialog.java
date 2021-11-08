package com.example.basicandroidcomponents.models.bottomsheetdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.basicandroidcomponents.R;
import com.example.basicandroidcomponents.databinding.ActivityBasicBottomSheetDialogBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BasicBottomSheetDialog extends AppCompatActivity {

    //regionComponent
    ActivityBasicBottomSheetDialogBinding binding;
    Button mainInfoButton;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityBasicBottomSheetDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mainInfoButton.setOnClickListener(view -> {

            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                    BasicBottomSheetDialog.this,R.style.BottomSheetDialogTheme);

            View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.basic_bottom_sheet_dialog,findViewById(R.id.bottom_sheet_dialog_linear_layout));

            bottomSheetDialog.setContentView(bottomSheetView);
            bottomSheetDialog.show();

            //for click buy button in bottom dialog
            bottomSheetView.findViewById(R.id.bottom_sheet_dialog_button).setOnClickListener(view1 ->
                    bottomSheetDialog.dismiss());

        });
    }
}