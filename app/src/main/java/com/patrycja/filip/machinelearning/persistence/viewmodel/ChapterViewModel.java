package com.patrycja.filip.machinelearning.persistence.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.patrycja.filip.machinelearning.persistence.MachineLearningApp;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;
import com.patrycja.filip.machinelearning.persistence.repository.ChapterRepository;
import com.patrycja.filip.machinelearning.persistence.repository.DataRepository;
import com.patrycja.filip.machinelearning.persistence.repository.api.IChapterRepository;

import java.util.List;

/**
 * Created by zwsfke on 2017-11-27.
 */
public class ChapterViewModel extends AndroidViewModel {

    private ChapterRepository dataRepository;

    private final LiveData<List<ChapterEntity>> observableChapters;

    public ChapterViewModel(Application application) {
        super(application);
        dataRepository = ((MachineLearningApp) application).getChapterRepository();
        observableChapters = dataRepository.loadChapters();
    }

    public LiveData<List<ChapterEntity>> getObservableChapters() {
        return observableChapters;
    }

    public void insertAllChapters(List<ChapterEntity> chaptersEntities) {
        dataRepository.insert(chaptersEntities.toArray(new ChapterEntity[chaptersEntities.size()]));
    }

}
