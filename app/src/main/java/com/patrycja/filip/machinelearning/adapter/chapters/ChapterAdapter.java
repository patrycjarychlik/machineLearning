package com.patrycja.filip.machinelearning.adapter.chapters;

/**
 * Created by patyk on 03.01.2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.patrycja.filip.machinelearning.R;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;

import java.util.List;

public class ChapterAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<ChapterEntity> chapters;

    public ChapterAdapter(Context context, List<ChapterEntity> chapters) {
        this.mContext = context;
        this.chapters = chapters;
    }

    @Override
    public int getCount() {
        return chapters.size();
    }

    @Override
    public long getItemId(int position) {
        return chapters.get(position).getId();
    }

    @Override
    public Object getItem(int position) {
        return chapters.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ChapterEntity chapter = chapters.get(position);
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.chapter_list_item, null);
        }

        final TextView chapterName = (TextView) convertView.findViewById(R.id.chapter_name);
        final ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.progress_bar);
        final TextView chapterExp = (TextView) convertView.findViewById(R.id.chapter_exp);

        chapterName.setText(chapter.getTitle());
        progressBar.setProgress(chapter.getPercentageProgress());
        chapterExp.setText(String.valueOf(chapter.getEarnedExp()));

        return convertView;
    }

}
