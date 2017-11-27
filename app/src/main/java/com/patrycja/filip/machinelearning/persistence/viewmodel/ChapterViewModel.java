package com.patrycja.filip.machinelearning.persistence.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.patrycja.filip.machinelearning.persistence.MachineLearningApp;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;
import com.patrycja.filip.machinelearning.persistence.repository.ChapterRepository;
import com.patrycja.filip.machinelearning.persistence.repository.api.IChapterRepository;

import java.util.List;

/**
 * Created by zwsfke on 2017-11-27.
 */
public class ChapterViewModel extends ViewModel {

    private IChapterRepository chapterRepository;

    private final LiveData<List<ChapterEntity>> observableChapters;

    public ChapterViewModel(Application application) {
        super();
        chapterRepository = (ChapterRepository) ((MachineLearningApp) application).getChapterRepository();

        observableChapters = chapterRepository.loadChapters();
    }

    public LiveData<List<ChapterEntity>> getObservableChapters() {
        return observableChapters;
    }

    public void insertAllChapters(List<ChapterEntity> chaptersEntities) {
        chapterRepository.insertAll(chaptersEntities);
    }

}
