package com.patrycja.filip.machinelearning.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.patrycja.filip.machinelearning.R;
import com.patrycja.filip.machinelearning.activity.ChapterActivity;
import com.patrycja.filip.machinelearning.adapter.chapters.ChapterAdapter;
import com.patrycja.filip.machinelearning.persistence.viewmodel.ChapterViewModel;

/**
 * Created by zwsfke on 2017-11-27.
 */
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home");

        final ChapterViewModel chapterViewModel = ViewModelProviders.of(this).get(ChapterViewModel.class);
        chapterViewModel.getObservableChapters().observe(this, chapterEntities -> {
            ChapterAdapter adapter = new ChapterAdapter(getContext(), chapterEntities);
            GridView gridView = (GridView) view.findViewById(R.id.gridview);
            gridView.setAdapter(adapter);
            gridView.setOnItemClickListener((parent, view1, position, id) -> {
                startChapterActivity(position + 1);
            });
        });

        TextView textView = view.findViewById(R.id.exp_points);
        textView.setText(String.valueOf(129));

    }

    private void startChapterActivity(int chapterId) {
        Intent intent = new Intent(getActivity(), ChapterActivity.class);
        Bundle b = new Bundle();
        b.putInt("chapterId", chapterId);
        intent.putExtras(b);
        startActivity(intent);
    }

}
