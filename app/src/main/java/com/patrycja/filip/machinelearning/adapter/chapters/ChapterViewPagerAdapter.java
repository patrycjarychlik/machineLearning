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
    /** Temorary same as Intro activity only for test purpose **/
    //TODO implement series of pages for particular chapter

    private LayoutInflater layoutInflater;
    private Activity callerActivity;


    public ChapterViewPagerAdapter(Activity callerActivity, int chapterId) {
        this.callerActivity = callerActivity;

    }

    @Override
    public int getCount() {
        return Chapter1Views.getSize();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) callerActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(Chapter1Views.getViewPagerViews().get(position), container, false);
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
