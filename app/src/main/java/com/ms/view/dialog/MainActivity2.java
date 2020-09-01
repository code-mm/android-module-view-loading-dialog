package com.ms.view.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.ms.view.dialog.loading.BasisDialog;
import com.ms.view.dialog.loading.progress.UIProgressDialog;

public class MainActivity2 extends AppCompatActivity {
    protected UIProgressDialog baseDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        baseDialog = new UIProgressDialog.MaterialBuilder(this)
                .setBackgroundColor(Color.parseColor("#ffffff"))
                .setTextColor(Color.parseColor("#F58533"))
                .setLoadingColor(Color.parseColor("#F58533"))
                .create();


    }

    public void open(View view) {


        baseDialog.show();

    }
}