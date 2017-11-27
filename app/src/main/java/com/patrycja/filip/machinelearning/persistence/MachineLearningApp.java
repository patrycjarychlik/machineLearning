package com.patrycja.filip.machinelearning.persistence;

import android.app.Application;

import com.patrycja.filip.machinelearning.persistence.db.AppDatabase;
import com.patrycja.filip.machinelearning.persistence.repository.ChapterRepository;
import com.patrycja.filip.machinelearning.persistence.repository.DataRepository;

/**
 * Created by zwsfke on 2017-11-27.
 */
public class MachineLearningApp extends Application {
    private AppExecutors appExecutors;

    @Override
    public void onCreate() {
        super.onCreate();
        appExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, appExecutors);
    }

    public DataRepository getChapterRepository() {
        return ChapterRepository.getInstance(getDatabase());
    }
}
