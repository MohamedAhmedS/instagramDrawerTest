package com.instagramdrawertest;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ViewGroup bigParent;
    private ImageView burger;
    private LinearLayout right_sheet;
    private RelativeLayout holder1;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bigParent = findViewById(R.id.bigParent);
        burger = findViewById(R.id.burger);
        right_sheet = findViewById(R.id.right_sheet);
        holder1 = findViewById(R.id.holder1);

//        final int scale = (int) context.getResources().getDisplayMetrics().density;
//        final TypedArray array = context.getTheme().obtainStyledAttributes(
//                new int[] { android.R.attr.actionBarSize });
//        int actionBarSize = (int) array.getDimensionPixelSize(0, -1);
//        array.recycle();
//
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT
//        );
//        params.setMargins(actionBarSize * 3, 0, 0, 0);
//        right_sheet.setLayoutParams(params);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        final int newWidth = (int)(width*0.6);
        final int normalWidth = 0;


        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (right_sheet.getMeasuredWidth() == normalWidth) {
                    ValueAnimator anim = ValueAnimator.ofInt(right_sheet.getMeasuredWidth(), (int) newWidth);
                    anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int val = (Integer) valueAnimator.getAnimatedValue();
                            ViewGroup.LayoutParams layoutParams = right_sheet.getLayoutParams();
                            layoutParams.width = val;
                            right_sheet.setLayoutParams(layoutParams);
                        }
                    });
                    anim.setDuration(300);
                    anim.start();
                } else if (right_sheet.getMeasuredWidth() == newWidth) {

                    ValueAnimator anim = ValueAnimator.ofInt(right_sheet.getMeasuredWidth(), normalWidth);
                    anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int val = (Integer) valueAnimator.getAnimatedValue();
                            ViewGroup.LayoutParams layoutParams = right_sheet.getLayoutParams();
                            layoutParams.width = val;
                            right_sheet.setLayoutParams(layoutParams);
                        }
                    });
                    anim.setDuration(300);
                    anim.start();
                }


            }
        });

            holder1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (right_sheet.getMeasuredWidth() == newWidth) {
                        ValueAnimator anim = ValueAnimator.ofInt(right_sheet.getMeasuredWidth(), normalWidth);
                        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int val = (Integer) valueAnimator.getAnimatedValue();
                                ViewGroup.LayoutParams layoutParams = right_sheet.getLayoutParams();
                                layoutParams.width = val;
                                right_sheet.setLayoutParams(layoutParams);
                            }
                        });
                        anim.setDuration(300);
                        anim.start();
                    }
                }
            });


    }

}