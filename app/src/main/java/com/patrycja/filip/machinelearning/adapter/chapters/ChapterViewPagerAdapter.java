package com.patrycja.filip.machinelearning.adapter.chapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by patyk on 03.01.2018.
 */

public class ChapterViewPagerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    private Activity callerActivity;
    private int chapterId;

    public ChapterViewPagerAdapter(Activity callerActivity, int chapterId) {
        this.callerActivity = callerActivity;
        this.callerActivity = callerActivity;
        this.chapterId = chapterId;
    }

    @Override
    public int getCount() {
        return ChapterViews.getSize(chapterId);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) callerActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(ChapterViews.getViewPagerViews(chapterId).get(position), container, false);
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
