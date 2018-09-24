package com.patrycja.filip.machinelearning.adapter.chapters;

import com.patrycja.filip.machinelearning.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwsfke on 2017-12-09.
 */

public class ChapterViews {

    private static final List<Integer> basics = new ArrayList<Integer>() {{
        add(R.layout.page_basics_title);
        add(R.layout.page_artur_samuel);
        add(R.layout.page_tom_mitchell);
        add(R.layout.page_mitchells_example);
        add(R.layout.page_what_the_heck);
        add(R.layout.page_2_types_algorithms);
    }};

    private static final List<Integer> chapter2 = new ArrayList<Integer>() {{
        add(R.layout.under_construction);
    }};
    private static final List<Integer> chapter3 = new ArrayList<Integer>() {{
        add(R.layout.page_proc_title);
        add(R.layout.page_proc_question);
        add(R.layout.page_proc_have_data);
        add(R.layout.page_proc_measure);
        add(R.layout.page_machine_learning_process);
        add(R.layout.page_machine_learning_process2);
    }};
    private static final List<Integer> chapter4 = new ArrayList<Integer>() {{
        add(R.layout.under_construction);
    }};
    private static final List<Integer> chapter6 = new ArrayList<Integer>() {{
        add(R.layout.under_construction);
    }};
    private static final List<Integer> chapter7 = new ArrayList<Integer>() {{
        add(R.layout.under_construction);
    }};

    private static final List<Integer> chapterSupervised = new ArrayList<Integer>() {{
        add(R.layout.page_super_title);
        add(R.layout.page_super_regre2);
        add(R.layout.page_super_regre);
        add(R.layout.page_super_class2);
        add(R.layout.page_super_class);
    }};

    public static List<Integer> getViewPagerViews(int chapterId) {
        switch (chapterId) {
            case 1:
                return basics;
            case 2:
                return chapter2;
            case 3:
                return chapter3;
            case 4:
                return chapter4;
            case 5:
                return chapterSupervised;
            case 6:
                return chapter6;
            case 7:
                return chapter7;
            default:
                return basics;
        }
    }

    public static int getSize(int chapterId) {
        return getViewPagerViews(chapterId).size();
    }

}
