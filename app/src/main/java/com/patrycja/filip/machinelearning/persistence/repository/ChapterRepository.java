package com.patrycja.filip.machinelearning.persistence.repository;

import android.arch.lifecycle.LiveData;

import com.patrycja.filip.machinelearning.persistence.db.AppDatabase;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;
import com.patrycja.filip.machinelearning.persistence.repository.api.IChapterRepository;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zwsfke on 2017-11-27.
 */
public class ChapterRepository extends DataRepository implements IChapterRepository {
    private static ChapterRepository dataRepoInstance;

    private ChapterRepository(AppDatabase database) {
        super(database);
    }

    public static ChapterRepository getInstance(final AppDatabase database) {
        if (dataRepoInstance == null) {
            synchronized (ChapterRepository.class) {
                if (dataRepoInstance == null) {
                    dataRepoInstance = new ChapterRepository(database);
                }
            }
        }
        return dataRepoInstance;
    }

    @Override
    public LiveData<List<ChapterEntity>> loadChapters() {
        return database.chapterDao().loadChapters();
    }

    @Override
    public ChapterEntity findById(int chapterId) {
        return database.chapterDao().findById(chapterId);
    }

    @Override
    public void insert(ChapterEntity... entity){
        database.chapterDao().insert(entity);
    }

    @Override
    public void update(ChapterEntity entity){
        database.chapterDao().update(entity);
    }

    @Override
    public void delete(ChapterEntity entity){
        database.chapterDao().delete(entity);
    }
}
