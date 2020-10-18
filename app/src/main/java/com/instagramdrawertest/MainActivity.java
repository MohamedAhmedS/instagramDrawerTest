package com.instagramdrawertest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Context;
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
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ViewGroup bigParent;
    private ImageView burger, imageView, backgroundImage;
    private LinearLayout right_sheet;
    private RelativeLayout holder1;
    private Context context;

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

        imageView.setImageResource(R.mipmap.gold);
        imageView.setClipToOutline(true);
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

                    anim.setDuration(500);
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

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }
}