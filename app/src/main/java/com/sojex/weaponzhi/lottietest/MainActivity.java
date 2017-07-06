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
    private boolean a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.btn);
        mButton1 = (Button) findViewById(R.id.btn_right);

        mLottieAnimationView = (LottieAnimationView) findViewById(R.id.lav_test);
        mLottieUtil = new LottieUtil(mLottieAnimationView);
        mLottieUtil.setLoop(true);
        mLottieUtil.setAnimation("datadabaojianssss.json", "images6/");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLottieUtil.playAnimation();
            }
        });

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!a) {
                    mLottieUtil.replaceAnimation("text2.json", "images2/");
                    a = true;
                } else {
                    mLottieUtil.replaceAnimation("databaojian.json","images4/");
                    a = false;
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

    public void nextActivity(View view) {
        mLottieUtil.cancelAnimation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLottieAnimationView.cancelAnimation();
    }
}
