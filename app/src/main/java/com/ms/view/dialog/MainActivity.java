package com.ms.view.dialog;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ms.view.dialog.loading.LoadingDialog;

public class MainActivity extends AppCompatActivity {

    LoadingDialog dialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new LoadingDialog(this, "加载中...");
        dialog.setmCancelable(false);
        dialog.setmCanceledOnTouchOutside(false);

        dialog.setImageColor(Color.parseColor("#ffffff"));
        dialog.setTextColor(Color.parseColor("#ffffff"));
        dialog.setDrawable(R.drawable.app_dialog_loading);
    }

    public void showDialog(View view) {
        dialog.show();
    }
}
