package com.patrycja.filip.machinelearning.adapter.chapters;

import com.patrycja.filip.machinelearning.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwsfke on 2017-12-09.
 */

public class ChapterViews {

    private static final List<Integer> viewPagerViews = new ArrayList<Integer>() {{
        add(R.layout.page_basics_title);
        add(R.layout.page_artur_samuel);
        add(R.layout.page_tom_mitchell);
        add(R.layout.page_mitchells_example);
        add(R.layout.page_what_the_heck);
        add(R.layout.page_machine_learning_process);
        add(R.layout.page_2_types_algorithms);
    }};

    private static final List<Integer> chapter2 = new ArrayList<Integer>() {{
        add(R.layout.page_what_the_heck);
        add(R.layout.page_machine_learning_process);
    }};

    public static List<Integer> getViewPagerViews(int chapterId) {
        if(chapterId==2){
            return chapter2;
        }
        return viewPagerViews;
    }

    public static int getSize(int chapterId) {
        if(chapterId==2){
            return chapter2.size();
        }
        return viewPagerViews.size();
    }

}
