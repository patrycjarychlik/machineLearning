package com.patrycja.filip.machinelearning.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.patrycja.filip.machinelearning.R;
import com.patrycja.filip.machinelearning.adapter.chapters.Chapter1Views;
import com.patrycja.filip.machinelearning.adapter.chapters.ChapterViewPagerAdapter;
import com.patrycja.filip.machinelearning.commons.AppSharedPreferences;
import com.patrycja.filip.machinelearning.persistence.MachineLearningApp;
import com.patrycja.filip.machinelearning.persistence.tasks.UpdateExpTask;
import com.patrycja.filip.machinelearning.persistence.tasks.UpdateProgressBarTask;
import com.patrycja.filip.machinelearning.persistence.repository.ChapterRepository;

public class ChapterActivity extends AppCompatActivity {

    /** Temorary same as Intro activity only for test purpose **/
    //TODO implement series of pages for particular chapter

    private ViewPager viewPager;
    private ChapterViewPagerAdapter chapterViewPagerAdapter;
    private LinearLayout llDots;
    private TextView[] dots;
    private Button btnSkip, btnNext;
    private int chapterId = 1;

    ChapterRepository chapterRepository = MachineLearningApp.getInstance().getChapterRepository();

    public ChapterActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();
        if(b != null)
            chapterId = b.getInt("chapterId");

        setNotificationBarTransparent();
        setContentView(R.layout.activity_chapter);
        getLayoutElements();
        addBottomDots(0);

        chapterViewPagerAdapter = new ChapterViewPagerAdapter(this, chapterId);
        viewPager.setAdapter(chapterViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btnSkip.setOnClickListener(v -> launchHomeScreen());
        btnNext.setOnClickListener(v -> {
            int current = getItem(+1);

            new UpdateProgressBarTask(chapterId).execute();

            if (current == Chapter1Views.getSize()) {
               new UpdateExpTask(chapterId).execute();
            }
            if (current < Chapter1Views.getSize()) {
                viewPager.setCurrentItem(current);
            } else {
                launchHomeScreen();
            }



        });
    }

    private void getLayoutElements() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        llDots = (LinearLayout) findViewById(R.id.layout_dots);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnNext = (Button) findViewById(R.id.btn_next);
    }

    private void launchHomeScreen() {
        AppSharedPreferences.getInstance(this).setIsFirstTimeLaunched();
        startActivity(new Intent(ChapterActivity.this, HomeActivity.class));
        finish();
    }

    private void setNotificationBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[Chapter1Views.getSize()];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        llDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[1]);
            llDots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[1]);
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
            if (position == dots.length - 1) {
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.GONE);
            } else {
                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

}
