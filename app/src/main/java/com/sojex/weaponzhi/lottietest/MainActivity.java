package com.sojex.weaponzhi.lottietest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;


public class MainActivity extends AppCompatActivity {
    private LottieAnimationView mLottieAnimationView;
    private Button mButton, mButton1;
    private LottieUtil mLottieUtil;
    private int a = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.btn);
        mButton1 = (Button) findViewById(R.id.btn_right);

        mLottieAnimationView = (LottieAnimationView) findViewById(R.id.lav_test);
        mLottieAnimationView.setScale(0.5f);
        mLottieUtil = new LottieUtil(mLottieAnimationView);
        mLottieUtil.setLoop(true);
        mLottieUtil.setAnimation("data1.json", "images1/");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLottieUtil.playAnimation();
            }
        });

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (a % 3) {
                    case 1:
                        mLottieUtil.replaceAnimation("data1.json","images1/");
                        break;
                    case 2:
                        mLottieUtil.replaceAnimation("data2.json","images2/");
                        break;
                    case 0:
                        mLottieUtil.replaceAnimation("data3.json","images3/");
                        break;
                }
                a++;
            }});
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void nextActivity(View view) {
        mLottieUtil.cancelAnimation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLottieAnimationView.cancelAnimation();
    }
}
