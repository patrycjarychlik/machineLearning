package com.patrycja.filip.machinelearning.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.patrycja.filip.machinelearning.R;
import com.patrycja.filip.machinelearning.adapter.model.BadgeItem;

import java.util.List;

public class BadgesAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<BadgeItem> badges;

    public BadgesAdapter(Context mContext, List<BadgeItem> badges) {
        this.mContext = mContext;
        this.badges = badges;
    }

    @Override
    public int getCount() {
        return badges.size();
    }

    @Override
    public Object getItem(int position) {
        return badges.get(position);
    }

    @Override
    public long getItemId(int position) {
        return badges.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.chapter_list_item, null);
            View view = convertView.findViewById(R.id.chapter_ico);
            ImageView icon = view.findViewById(R.id.circle_image_button);
            icon.setImageResource(badges.get(position).getBadge());
        }

        final TextView chapterName = (TextView) convertView.findViewById(R.id.chapter_name);
        final ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.progress_bar);
        final TextView chapterExp = (TextView) convertView.findViewById(R.id.chapter_exp);

        chapterName.setText(badges.get(position).getText());
        progressBar.setProgress(0);
        chapterExp.setText("");

        return convertView;
    }

}
