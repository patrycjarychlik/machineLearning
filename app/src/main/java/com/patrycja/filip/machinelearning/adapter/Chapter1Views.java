package com.patrycja.filip.machinelearning.adapter;

import com.patrycja.filip.machinelearning.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwsfke on 2017-12-09.
 */

public class Chapter1Views {

    private static final List<Integer> viewPagerViews = new ArrayList<Integer>() {{
        add(R.layout.page_1_1);
        add(R.layout.page_1_2);
        add(R.layout.page_1_3);
        add(R.layout.page_1_4);
    }};

    public static List<Integer> getViewPagerViews() {
        return viewPagerViews;
    }

    public static int getSize() {
        return viewPagerViews.size();
    }

}
