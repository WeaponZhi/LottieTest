package com.sojex.weaponzhi.lottietest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private LottieAnimationView mLottieAnimationView;
    private boolean isPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLottieAnimationView = (LottieAnimationView) findViewById(R.id.lav_test);
        mLottieAnimationView.setImageAssetsFolder("images/");
        mLottieAnimationView.useExperimentalHardwareAcceleration(true);
        mLottieAnimationView.setAnimation("data.json");
        mLottieAnimationView.loop(true);
        mLottieAnimationView.playAnimation();
//        mLottieAnimationView.enableMergePathsForKitKatAndAbove(true);

        mLottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        mLottieAnimationView.playAnimation();
        super.onResume();
    }

    /**
     * 测试 lo
     */
    @Override
    protected void onStop() {
        mLottieAnimationView.cancelAnimation();
        super.onStop();
    }
}
