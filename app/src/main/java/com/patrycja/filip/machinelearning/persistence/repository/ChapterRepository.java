package com.patrycja.filip.machinelearning.persistence.repository;

import android.arch.lifecycle.LiveData;

import com.patrycja.filip.machinelearning.persistence.db.AppDatabase;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;
import com.patrycja.filip.machinelearning.persistence.repository.api.IChapterRepository;

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
    public void insertAll(List<ChapterEntity> chapterEntities) {
        database.chapterDao().insertAll(chapterEntities);
    }

    @Override
    public LiveData<List<ChapterEntity>> loadChapters() {
        return database.chapterDao().loadChapters();
    }
}
