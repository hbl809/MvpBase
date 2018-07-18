package com.hbl.mvpbase.ui.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hbl.mvpbase.R;
import com.hbl.mvpbase.base.BaseActivity;
import com.hbl.mvpbase.ui.main.activity.MainActivity;
import com.hbl.mvpbase.util.ImageLoader;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;


public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.iv_welcome_bg)
    ImageView ivWelcomeBg;
    @BindView(R.id.tv_welcome_author)
    TextView tvWelcomeAuthor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
         super.onCreate(savedInstanceState);

         StatusBarUtil.setColor(this, getResources().getColor(R.color.colorBackground));
    }

    @Override
    protected int getLayout() {

        return R.layout.activity_welcome;
    }

    @Override
    protected void initEventAndData() {

        new Handler().postDelayed(new Runnable() {
            public void run() {
                jumpToMain();
            }
        }, 2000);
    }


    @Override
    protected void onViewCreated() {
        ImageLoader.load(this, R.mipmap.bg_about, ivWelcomeBg);
        ivWelcomeBg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100)
                .start();
        //tvWelcomeAuthor.setText("欢迎");

    }

    public void jumpToMain() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }


    @Override
    protected void onDestroy() {
        Glide.clear(ivWelcomeBg);
        super.onDestroy();
    }
}
