package com.instagramdrawertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RevealActivity extends AppCompatActivity {

    MainActivity.RevealAnimation mRevealAnimation;
    TextView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal);

        Intent intent = this.getIntent();   //get the intent to recieve the x and y coords, that you passed before

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.root_layout); //there you have to get the root layout of your second activity
        mRevealAnimation = new MainActivity.RevealAnimation(rootLayout, intent, this);

        btn = findViewById(R.id.btn);
        hideBtn();

//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int width = displayMetrics.widthPixels;
//
//        final int newWidth = (int)(width*0.6);
//
//        btn.setLayoutParams(new LinearLayout.LayoutParams(newWidth, 100));


    }


    @Override
    public void onBackPressed()
    {
        mRevealAnimation.unRevealActivity();
        revealBtn();
    }

    private void revealBtn() {
        final View view = findViewById(R.id.btn);
        view.post(new Runnable() {
            @Override
            public void run() {
                int cx = view.getWidth() / 2;
                int cy = view.getHeight() / 2;
                float finalRadius = (float) Math.hypot(cx, cy);
                Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
                view.setVisibility(View.VISIBLE);
                anim.setDuration(300);
                anim.start();
            }
        });
    }
    private void hideBtn() {
        final View view = findViewById(R.id.btn);
        view.post(new Runnable() {
            @Override
            public void run() {
                int cx = view.getWidth() / 2;
                int cy = view.getHeight() / 2;
                float initialRadius = (float) Math.hypot(cx, cy);
                Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, 0);
                anim.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.setVisibility(View.INVISIBLE);
                    }
                });
                anim.setDuration(1000);
                anim.start();
            }
        });
    }
//    private void startRevealActivity(View v) {
//        //calculates the center of the View v you are passing
//        int revealX = (int) (v.getX() + (v.getWidth() / 2) * 7.3);
//        int revealY = (int) (v.getY() + (v.getHeight() / 2));
//
//        //create an intent, that launches the second activity and pass the x and y coordinates
//        Intent intent = new Intent(this, RevealActivity.class);
//        intent.putExtra(MainActivity.RevealAnimation.EXTRA_CIRCULAR_REVEAL_X, revealX);
//        intent.putExtra(MainActivity.RevealAnimation.EXTRA_CIRCULAR_REVEAL_Y, revealY);
//
//        //just start the activity as an shared transition, but set the options bundle to null
//        ActivityCompat.startActivity(this, intent, null);
//
//        //to prevent strange behaviours override the pending transitions
//        overridePendingTransition(0, 0);
//    }
//    private void startRevealActivity2(View v) {
//        //calculates the center of the View v you are passing
//        int revealX = (int) (v.getX() + (v.getWidth() / 2) * 2.5);
//        int revealY = (int) (v.getY() + (v.getHeight() / 2));
//
//        //create an intent, that launches the second activity and pass the x and y coordinates
//        Intent intent = new Intent(this, RevealActivity.class);
//        intent.putExtra(MainActivity.RevealAnimation.EXTRA_CIRCULAR_REVEAL_X, revealX);
//        intent.putExtra(MainActivity.RevealAnimation.EXTRA_CIRCULAR_REVEAL_Y, revealY);
//
//        //just start the activity as an shared transition, but set the options bundle to null
//        ActivityCompat.startActivity(this, intent, null);
//
//        //to prevent strange behaviours override the pending transitions
//        overridePendingTransition(0, 0);
//    }
//
//    public static class RevealAnimation {
//        public static final String EXTRA_CIRCULAR_REVEAL_X = "EXTRA_CIRCULAR_REVEAL_X";
//        public static final String EXTRA_CIRCULAR_REVEAL_Y = "EXTRA_CIRCULAR_REVEAL_Y";
//
//        private final View mView;
//        private Activity mActivity;
//
//        private int revealX;
//        private int revealY;
//
//        public RevealAnimation(View view, Intent intent, Activity activity) {
//            mView = view;
//            mActivity = activity;
//
//            //when you're android version is at leat Lollipop it starts the reveal activity
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP &&
//                    intent.hasExtra(EXTRA_CIRCULAR_REVEAL_X) &&
//                    intent.hasExtra(EXTRA_CIRCULAR_REVEAL_Y)) {
//                view.setVisibility(View.INVISIBLE);
//
//                revealX = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_X, 0);
//                revealY = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_Y, 0);
//
//                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
//                if (viewTreeObserver.isAlive()) {
//                    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//                        @Override
//                        public void onGlobalLayout() {
//                            revealActivity(revealX, revealY);
//                            mView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                        }
//                    });
//                }
//            } else {
//
//                //if you are below android 5 it jist shows the activity
//                view.setVisibility(View.VISIBLE);
//            }
//        }
//
//        public void revealActivity(int x, int y) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                float finalRadius = (float) (Math.max(mView.getWidth(), mView.getHeight()) * 1.1);
//
//                // create the animator for this view (the start radius is zero)
//                Animator circularReveal = ViewAnimationUtils.createCircularReveal(mView, x, y, 0, finalRadius);
//                circularReveal.setDuration(300);
//                circularReveal.setInterpolator(new AccelerateInterpolator());
//
//                // make the view visible and start the animation
//                mView.setVisibility(View.VISIBLE);
//                circularReveal.start();
//            } else {
//                mActivity.finish();
//            }
//        }
//
//        public void unRevealActivity() {
//            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//                mActivity.finish();
//            } else {
//                float finalRadius = (float) (Math.max(mView.getWidth(), mView.getHeight()) * 1.1);
//                Animator circularReveal = ViewAnimationUtils.createCircularReveal(
//                        mView, revealX, revealY, finalRadius, 0);
//
//                circularReveal.setDuration(300);
//                circularReveal.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        mView.setVisibility(View.INVISIBLE);
//                        mActivity.finish();
//                        mActivity.overridePendingTransition(0, 0);
//                    }
//                });
//
//                circularReveal.start();
//            }
//        }
//    }
}