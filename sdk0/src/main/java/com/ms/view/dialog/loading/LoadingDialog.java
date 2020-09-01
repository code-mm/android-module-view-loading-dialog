package com.ms.view.dialog.loading;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;


/**
 * @author maohuawei created in 2018/11/13
 * <p>
 * 加载中
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class LoadingDialog extends Dialog {

    private static final String TAG = "LoadingDialog";

    private String mMessage;
    private boolean mCancelable = false;
    private boolean mCanceledOnTouchOutside = false;

    public LoadingDialog(@NonNull Context context, String message) {
        this(context, R.style.ComMsAppLoadingStyle, message);
    }

    public LoadingDialog(@NonNull Context context, int themeResId, String message) {
        super(context, themeResId);
        mMessage = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private TextView textViewLoadingText;
    private ProgressBar progressBar;

    private Drawable drawable;
    private Drawable wrappedDrawable;

    // 文字颜色
    private int textColor = Color.parseColor("#ffffff");
    // svg图片颜色
    private int imageColor = Color.parseColor("#ffffff");


    private int loadingDrawableId = R.drawable.com_ms_app_dialog_loading;


    private void initView() {
        setContentView(R.layout.com_ms_app_dialog_loading);
        // 设置窗口大小
        WindowManager windowManager = getWindow().getWindowManager();
        int screenWidth = windowManager.getDefaultDisplay().getWidth();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 1.0f;
        attributes.width = screenWidth / 4;
        attributes.height = attributes.width;
        getWindow().setAttributes(attributes);
        setCancelable(mCancelable);
        setCanceledOnTouchOutside(mCanceledOnTouchOutside);
        textViewLoadingText = findViewById(R.id.textViewLoadingText);
        progressBar = findViewById(R.id.progressBar);

        textViewLoadingText.setText(mMessage);
        textViewLoadingText.setTextColor(textColor);

        drawable = ContextCompat.getDrawable(getContext(), loadingDrawableId).mutate();
        wrappedDrawable = DrawableCompat.wrap(drawable);
        wrappedDrawable.setTint(imageColor);
        progressBar.setIndeterminateDrawable(drawable);
    }

    public void setDrawable(int drawableId) {
        loadingDrawableId = drawableId;
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    public void setmCancelable(boolean mCancelable) {
        this.mCancelable = mCancelable;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public void setmCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        this.mCanceledOnTouchOutside = canceledOnTouchOutside;
    }

    public void setTextColor(int color) {
        textColor = color;
    }

    public void setImageColor(int color) {
        imageColor = color;
    }

    private void fullScreenImmersive(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            view.setSystemUiVisibility(uiOptions);
        }
    }

    @Override
    public void show() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        super.show();
        fullScreenImmersive(getWindow().getDecorView());
        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }
}