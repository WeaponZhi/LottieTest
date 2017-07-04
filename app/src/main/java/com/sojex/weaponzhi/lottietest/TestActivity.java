package com.sojex.weaponzhi.lottietest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

/**
 * Created by admin on 2017/7/4.
 */

public class TestActivity extends AppCompatActivity {
    private LottieAnimationView mLottieAnimationView;
    private boolean isPlay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mLottieAnimationView = (LottieAnimationView) findViewById(R.id.lav_test1);
        mLottieAnimationView.setImageAssetsFolder("images2/");
        mLottieAnimationView.useExperimentalHardwareAcceleration(true);
        mLottieAnimationView.setAnimation("text2.json", LottieAnimationView.CacheStrategy.Weak);
        mLottieAnimationView.loop(true);


//        mLottieAnimationView.enableMergePathsForKitKatAndAbove(true);

        mLottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        mLottieAnimationView.resumeAnimation();
        super.onResume();
    }

    /**
     * 测试 Lottie 的内存回收机制
     */

    @Override
    protected void onDestroy() {
        mLottieAnimationView.cancelAnimation();
        super.onDestroy();
    }
}
