package com.sojex.weaponzhi.lottietest;

import android.animation.Animator;
import android.animation.ValueAnimator;

import com.airbnb.lottie.LottieAnimationView;

/**
 * LottieUtil LottieUtil 工具类，适合单一替换型动画
 * author:张冠之
 * time: 2017/7/5 15:09
 * e-mail: guanzhi.zhang@sojex.cn
 */

public class LottieUtil {
    private LottieAnimationView mLottieAnimationView;

    /**
     * 构造方法
     * 默认开启硬件加速
     * @param view
     */
    public LottieUtil(LottieAnimationView view) {
        mLottieAnimationView = view;
        mLottieAnimationView.useExperimentalHardwareAcceleration();
    }

    /**
     * 设置动画资源文件
     * @param fileName
     */
    public void setAnimation(String fileName) {
        mLottieAnimationView.setAnimation(fileName, LottieAnimationView.CacheStrategy.Weak);
    }

    /**
     * 设置带动画资源文件
     * @param fileName
     * @param imageFolder
     */
    public void setAnimation(String fileName, String imageFolder) {
        setAnimation(fileName);
        mLottieAnimationView.setImageAssetsFolder(imageFolder);
    }

    /**
     * 替换现有的动画
     * @param fileName
     */
    public void replaceAnimation(String fileName) {
        cancelAnimation();
        setAnimation(fileName);
        mLottieAnimationView.setProgress(0);
    }

    public void replaceAnimation(String fileName, String imageFolder) {
        cancelAnimation();
        setAnimation(fileName, imageFolder);
        mLottieAnimationView.setProgress(0);
    }

    public void playAnimation() {
        playAnimation(true);
    }

    /**
     * 是否从暂停的地方继续开始
     * @param resume
     */
    public void playAnimation(boolean resume){
        if (resume){
            mLottieAnimationView.playAnimation();
        }else {
            mLottieAnimationView.setProgress(0);
            mLottieAnimationView.playAnimation();
        }
    }

    /**
     * 暂停动画
     */
    public void pauseAnimation() {
        mLottieAnimationView.pauseAnimation();
    }

    /**
     * 取消动画
     */
    public void cancelAnimation() {
        mLottieAnimationView.cancelAnimation();
    }

    /**
     * 监听动画的状态变化
     * @param listener
     */
    public void addAnimationListener(Animator.AnimatorListener listener) {
        mLottieAnimationView.addAnimatorListener(listener);
    }

    /**
     * 监听动画的更新
     * @param listener
     */
    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener listener) {
        mLottieAnimationView.addAnimatorUpdateListener(listener);
    }

    public void setLoop(boolean isLoop){
        mLottieAnimationView.loop(isLoop);
    }

    public void setProgress(float progress){
        mLottieAnimationView.setProgress(progress);
    }
}
