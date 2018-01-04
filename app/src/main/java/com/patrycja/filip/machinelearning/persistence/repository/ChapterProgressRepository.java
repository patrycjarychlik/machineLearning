package com.patrycja.filip.machinelearning.persistence.repository;

import android.arch.lifecycle.LiveData;

import com.patrycja.filip.machinelearning.persistence.db.AppDatabase;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterProgressEntity;
import com.patrycja.filip.machinelearning.persistence.repository.api.IChapterProgressRepository;
import com.patrycja.filip.machinelearning.persistence.repository.api.IChapterRepository;

import java.util.List;

/**
 * Created by patyk.
 */
public class ChapterProgressRepository extends DataRepository implements IChapterProgressRepository {
    private static ChapterProgressRepository dataRepoInstance;

    private ChapterProgressRepository(AppDatabase database) {
        super(database);
    }

    public static ChapterProgressRepository getInstance(final AppDatabase database) {
        if (dataRepoInstance == null) {
            synchronized (ChapterProgressRepository.class) {
                if (dataRepoInstance == null) {
                    dataRepoInstance = new ChapterProgressRepository(database);
                }
            }
        }
        return dataRepoInstance;
    }

    public List<ChapterProgressEntity> loadAllPagesByChapterId(int chapterId) {
        return database.chapterProgressDao().loadAllByChapterId(chapterId);
    }

    public List<ChapterProgressEntity> loadAllPages() {
        return database.chapterProgressDao().loadAllPages();
    }
}
