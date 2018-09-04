package com.ladyishenlong.translation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * 文字平移的控件
 */
public class TranslationView extends FrameLayout {

    private TextView textView1;
    private TextView textView2;

    private float textSize = 20;
    private int textColor = Color.BLACK;
    private int direction = 0;//0横向移动，1竖直移动
    private boolean isNext = true;//true是下一个，false是上一个
    private int currPosition = 0;//当前位置

    private ValueAnimator animator;
    private List<String> datas;


    public TranslationView(Context context) {
        super(context);
    }

    public TranslationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TranslationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 属性设置
     **/
    public TranslationView setDirection(int direction) {
        if (direction == 0 || direction == 1) {
            this.direction = direction;
        }
        return this;
    }

    public TranslationView setTestSize(float textSize) {
        this.textSize = textSize;
        return this;
    }

    public TranslationView setDatas(List<String> datas) {
        this.datas = datas;
        return this;
    }

    /**
     * 必须调用这个
     */
    public void build() {
        init();
    }


    private void init() {

        if (datas == null || datas.size() < 2) {
            datas = new ArrayList<>();
            datas.add("暂无数据");
            datas.add("暂无数据");
        }

        if (currPosition + 1 >= datas.size()) return;

        initView();
        initAnim();
    }


    public void initView() {
        textView1 = new TextView(getContext());
        textView1.setTextSize(textSize);
        textView1.setTextColor(textColor);
        textView1.setText(datas.get(currPosition));
        textView1.setAlpha(1);
        textView1.setGravity(Gravity.CENTER);
        addView(textView1);

        textView2 = new TextView(getContext());
        textView2.setTextSize(textSize);
        textView2.setTextColor(textColor);
        textView2.setText(datas.get(currPosition + 1));
        textView2.setGravity(Gravity.CENTER);

        textView2.setAlpha(0);
        addView(textView2);
    }


    private void initAnim() {

        animator = ValueAnimator.ofFloat(1f, 0f).setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float animationValue = (float) animation.getAnimatedValue();

                textView1.setAlpha(animationValue);
                textView2.setAlpha(1 - animationValue);

                if (direction == 0) {//横向移动

                    float textView1Width = (float) textView1.getWidth();
                    float x = animationValue * textView1Width;

                    if (isNext) {
                        textView2.setX(x);
                    } else {
                        textView2.setX(-x);
                    }

                } else if (direction == 1) {//垂直移动

                    float textView1Height = (float) textView1.getHeight();
                    float y = animationValue * textView1Height;

                    if (isNext) {
                        textView2.setY(-y);
                    } else {
                        textView2.setY(y);
                    }
                }
            }
        });


        //动画结束后的操作
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                TextView tem = textView1;
                textView1 = textView2;
                textView2 = tem;
                textView2.setAlpha(0);
            }

        });


    }


    /**
     * @param isNext
     */
    public void move(boolean isNext) {

        this.isNext = isNext;

        if (isNext) {//向后走

            if (currPosition >= datas.size() - 1) return;
            currPosition = currPosition + 1;

        } else {//向前走

            if (currPosition < 1) return;
            currPosition = currPosition - 1;
        }

        textView2.setText(datas.get(currPosition));
        animator.start();

    }


}
