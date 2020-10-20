package com.instagramdrawertest;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewGroup bigParent;
    private ImageView burger, imageView, backgroundImage;
    private LinearLayout right_sheet;
    private RelativeLayout holder1;
    private Context context;
    private TextView btn;
    private int width;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bigParent = findViewById(R.id.bigParent);
        burger = findViewById(R.id.burger);
        right_sheet = findViewById(R.id.right_sheet);
        holder1 = findViewById(R.id.holder1);
        imageView = findViewById(R.id.imageView);
        backgroundImage = findViewById(R.id.backgroudImage);
        btn = findViewById(R.id.btn);

        imageView.setImageResource(R.mipmap.placeholder2);
        imageView.setClipToOutline(true);

//        Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_up);
//        btn.startAnimation(myAnim);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startRevealActivity2(v);
//                hideBtn();
//                Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_down);
//                btn.startAnimation(myAnim);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startRevealActivity(v);
            }
        });
//        backgroundImage.setImageResource(R.mipmap.gold);
//        backgroundImage.setClipToOutline(true);

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.gold);
//        imageView.setImageBitmap(getRoundedCornerBitmap(bitmap, 360));
//which adds the imageview to your layout
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
        width = displayMetrics.widthPixels;

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

                    anim.setDuration(2000);
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
                    anim.setDuration(2000);
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
                        anim.setDuration(2000);
                        anim.start();
                    }
                }
            });


    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed()
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        final int newWidth = (int)(width*0.6);
        final int normalWidth = 0;

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
            anim.setDuration(1200);
            anim.start();
        }

        if(right_sheet.getMeasuredWidth() == normalWidth){
            super.onBackPressed();
        }

    }

//    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
//        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
//                .getHeight(), Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(output);
//
//        final int color = 0xff424242;
//        final Paint paint = new Paint();
//        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
//        final RectF rectF = new RectF(rect);
//        final float roundPx = pixels;
//
//        paint.setAntiAlias(true);
//        canvas.drawARGB(0, 0, 0, 0);
//        paint.setColor(color);
//        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
//
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//        canvas.drawBitmap(bitmap, rect, rect, paint);
//
//        return output;
//    }
//private void revealBtn() {
//    final View view = findViewById(R.id.btn);
//    view.post(new Runnable() {
//        @Override
//        public void run() {
//            int cx = view.getWidth() / 2;
//            int cy = view.getHeight() / 2;
//            float finalRadius = (float) Math.hypot(cx, cy);
//            Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
//            view.setVisibility(View.VISIBLE);
//            anim.setDuration(300);
//            anim.start();
//        }
//    });
//}
//    private void hideBtn() {
//        final View view = findViewById(R.id.btn);
//        view.post(new Runnable() {
//            @Override
//            public void run() {
//                int cx = view.getWidth() / 2;
//                int cy = view.getHeight() / 2;
//                float initialRadius = (float) Math.hypot(cx, cy);
//                Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, 0);
//                anim.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        super.onAnimationEnd(animation);
//                        view.setVisibility(View.INVISIBLE);
//                    }
//                });
//                anim.setDuration(500);
//                anim.start();
//            }
//        });
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String myStr=data.getStringExtra("MyData");
            }
        }
    }

    private void startRevealActivity(View v) {
        //calculates the center of the View v you are passing
        int revealX = (int) (v.getX() + (v.getWidth() / 2) + (width * 0.4) );
        int revealY = (int) (v.getY() + (v.getHeight() / 2));

        //create an intent, that launches the second activity and pass the x and y coordinates
        Intent intent = new Intent(this, RevealActivity.class);
        intent.putExtra(RevealAnimation.EXTRA_CIRCULAR_REVEAL_X, revealX);
        intent.putExtra(RevealAnimation.EXTRA_CIRCULAR_REVEAL_Y, revealY);

        //just start the activity as an shared transition, but set the options bundle to null
        ActivityCompat.startActivity(this, intent, null);

        //to prevent strange behaviours override the pending transitions
        overridePendingTransition(0, 0);
    }
    private void startRevealActivity2(View v) {
        //calculates the center of the View v you are passing
        int revealX = (int) (v.getX() + (v.getWidth() / 2) + (width * 0.4));
        int revealY = (int) (v.getY() + (v.getHeight() / 2));

        //create an intent, that launches the second activity and pass the x and y coordinates
        Intent intent = new Intent(this, RevealActivity.class);
        intent.putExtra(RevealAnimation.EXTRA_CIRCULAR_REVEAL_X, revealX);
        intent.putExtra(RevealAnimation.EXTRA_CIRCULAR_REVEAL_Y, revealY);

        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(MainActivity.this, (View)btn, "menu_button");

        //just start the activity as an shared transition, but set the options bundle to null
        ActivityCompat.startActivity(this, intent, null);

        //to prevent strange behaviours override the pending transitions
        overridePendingTransition(0, 0);
    }

    public static class RevealAnimation {
        public static final String EXTRA_CIRCULAR_REVEAL_X = "EXTRA_CIRCULAR_REVEAL_X";
        public static final String EXTRA_CIRCULAR_REVEAL_Y = "EXTRA_CIRCULAR_REVEAL_Y";

        private final View mView;
        private Activity mActivity;

        private int revealX;
        private int revealY;

        public RevealAnimation(View view, Intent intent, Activity activity) {
            mView = view;
            mActivity = activity;

            //when you're android version is at leat Lollipop it starts the reveal activity
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP &&
                    intent.hasExtra(EXTRA_CIRCULAR_REVEAL_X) &&
                    intent.hasExtra(EXTRA_CIRCULAR_REVEAL_Y)) {
                view.setVisibility(View.INVISIBLE);

                revealX = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_X, 0);
                revealY = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_Y, 0);

                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            revealActivity(revealX, revealY);
                            mView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    });
                }
            } else {

                //if you are below android 5 it jist shows the activity
                view.setVisibility(View.VISIBLE);
            }
        }

        public void revealActivity(int x, int y) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                float finalRadius = (float) (Math.max(mView.getWidth(), mView.getHeight()) * 1.1);

                // create the animator for this view (the start radius is zero)
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(mView, x, y, 0, finalRadius);
                circularReveal.setDuration(500);
                circularReveal.setInterpolator(new AccelerateInterpolator());

                // make the view visible and start the animation
                mView.setVisibility(View.VISIBLE);
                circularReveal.start();
            } else {
                mActivity.finish();
            }
        }

        public void unRevealActivity() {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                mActivity.finish();
            } else {
                float finalRadius = (float) (Math.max(mView.getWidth(), mView.getHeight()) * 1.1);
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(
                        mView, revealX, revealY, finalRadius, 0);

                circularReveal.setDuration(500);
                circularReveal.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mView.setVisibility(View.INVISIBLE);
                        mActivity.finish();
                        mActivity.overridePendingTransition(0, 0);
                    }
                });

                circularReveal.start();
            }
        }
    }
}