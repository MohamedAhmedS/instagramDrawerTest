package com.instagramdrawertest;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class InstaDrawer extends ViewGroup {

    List<String> menuItems = new ArrayList<>();

//    InstaDrawerCallback listener;

    public InstaDrawer(Context context) {
        super(context);
    }

    public InstaDrawer(Context context, List<String> menuItems) {
        super(context);
        this.menuItems = menuItems;
    }

    public InstaDrawer(Context context, AttributeSet attrs, List<String> menuItems) {
        super(context, attrs);
        this.menuItems = menuItems;
    }

    public InstaDrawer(Context context, AttributeSet attrs, int defStyleAttr, List<String> menuItems) {
        super(context, attrs, defStyleAttr);
        this.menuItems = menuItems;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InstaDrawer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, List<String> menuItems) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.menuItems = menuItems;
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

//    public void addItems(List<String> items){
//        menuItems.addAll(items);
//    }
//
//    public void setListener(InstaDrawerCallback listener){
//        this.listener = listener;
//    }
//
//    public interface InstaDrawerCallback{
//        public void onTiemClick(int index);
//    }
}
