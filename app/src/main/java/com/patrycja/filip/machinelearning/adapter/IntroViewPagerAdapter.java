package com.patrycja.filip.machinelearning.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zwsfke on 2017-12-02.
 */

public class IntroViewPagerAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private Activity callerActivity;

    public IntroViewPagerAdapter(Activity callerActivity) {
        this.callerActivity = callerActivity;
    }

    @Override
    public int getCount() {
        return IntroViews.getSize();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) callerActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(IntroViews.getViewPagerViews().get(position), container, false);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
