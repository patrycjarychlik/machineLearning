package com.patrycja.filip.machinelearning.persistence;

import android.app.Application;

import com.patrycja.filip.machinelearning.persistence.db.AppDatabase;
import com.patrycja.filip.machinelearning.persistence.repository.ChapterProgressRepository;
import com.patrycja.filip.machinelearning.persistence.repository.ChapterRepository;
import com.patrycja.filip.machinelearning.persistence.repository.UserRepository;

/**
 * Created by zwsfke on 2017-11-27.
 */
public class MachineLearningApp extends Application {
    private static MachineLearningApp singleton;

    public static MachineLearningApp getInstance() {
        return singleton;
    }

    private AppExecutors appExecutors;

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        appExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, appExecutors);
    }

    public ChapterRepository getChapterRepository() {
        return ChapterRepository.getInstance(getDatabase());
    }

    public ChapterProgressRepository getChapterProgressRepository() {
        return ChapterProgressRepository.getInstance(getDatabase());
    }

    public UserRepository getUserRepository() {
        return UserRepository.getInstance(getDatabase());
    }
}
