package com.patrycja.filip.machinelearning.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.patrycja.filip.machinelearning.R;
import com.patrycja.filip.machinelearning.commons.SoundPlayer;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;
import com.patrycja.filip.machinelearning.persistence.viewmodel.ChapterViewModel;

import java.util.List;

/**
 * Created by zwsfke on 2017-11-27.
 */
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ChapterViewModel chapterViewModel = ViewModelProviders.of(this).get(ChapterViewModel.class);
        chapterViewModel.getObservableChapters().observe(this, new Observer<List<ChapterEntity>>() {
            @Override
            public void onChanged(@Nullable List<ChapterEntity> chapterEntities) {
                Log.println(Log.INFO, "TEST_VIEW_MODEL", "List of chapters: " + chapterEntities.toString());
            }
        });

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home");

        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        progressBar.setProgress(30);

        Button btnCorrectSound = (Button) view.findViewById(R.id.btn_correct_sound);
        btnCorrectSound.setOnClickListener(btnClick -> SoundPlayer.playCorrectAnswerSound(this.getActivity()));
    }

}
