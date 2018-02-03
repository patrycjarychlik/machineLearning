package com.patrycja.filip.machinelearning.persistence.repository;

import com.patrycja.filip.machinelearning.persistence.db.AppDatabase;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterProgressEntity;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterProgressEntity;
import com.patrycja.filip.machinelearning.persistence.repository.api.IChapterProgressRepository;

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

    public List<ChapterProgressEntity> findAllPagesByChapterId(int chapterId) {
        return database.chapterProgressDao().findAllByChapterId(chapterId);
    }

    @Override
    public void insert(ChapterProgressEntity... entity){
        database.chapterProgressDao().insert(entity);
    }

    @Override
    public void update(ChapterProgressEntity entity){
        database.chapterProgressDao().update(entity);
    }

    @Override
    public void delete(ChapterProgressEntity entity){
        database.chapterProgressDao().delete(entity);
    }
}
