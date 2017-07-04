package com.sojex.weaponzhi.lottietest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;


public class MainActivity extends AppCompatActivity {
    private LottieAnimationView mLottieAnimationView, mLottieAnimationView1;
    private Button mButton, mButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.btn);
        mButton1 = (Button) findViewById(R.id.btn_right);

        mLottieAnimationView = (LottieAnimationView) findViewById(R.id.lav_test);
        mLottieAnimationView1 = (LottieAnimationView) findViewById(R.id.lav_test_right);

        mLottieAnimationView.loop(true);
        mLottieAnimationView1.loop(true);
        mLottieAnimationView1.setImageAssetsFolder("images3/");
        mLottieAnimationView1.useExperimentalHardwareAcceleration(true);
        mLottieAnimationView1.setAnimation("caishen.json");
        mLottieAnimationView.setImageAssetsFolder("images2/");
        mLottieAnimationView.useExperimentalHardwareAcceleration(true);
        mLottieAnimationView.setAnimation("text2.json", LottieAnimationView.CacheStrategy.Weak);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLottieAnimationView.getVisibility() == View.VISIBLE) {
                    mLottieAnimationView.setVisibility(View.GONE);
                    mLottieAnimationView.cancelAnimation();
                } else {
                    mLottieAnimationView.playAnimation();
                    mLottieAnimationView.setVisibility(View.VISIBLE);
                }
            }
        });

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLottieAnimationView1.getVisibility() == View.VISIBLE) {
                    mLottieAnimationView1.setVisibility(View.GONE);
                    mLottieAnimationView1.cancelAnimation();
                } else {
                    mLottieAnimationView1.playAnimation();
                    mLottieAnimationView1.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void nextActivity(View view){
        startActivity(new Intent(MainActivity.this,TestActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLottieAnimationView.cancelAnimation();
        mLottieAnimationView1.cancelAnimation();
    }
}
