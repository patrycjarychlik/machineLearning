package com.patrycja.filip.machinelearning.persistence.repository.api;

import android.arch.lifecycle.LiveData;

import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterProgressEntity;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterProgressEntity;

import java.util.List;

/**
 * Created by zwsfke on 2017-11-27.
 */
public interface IChapterProgressRepository {
    
    List<ChapterProgressEntity> findAllPagesByChapterId(int chapterId);

    void insert(ChapterProgressEntity... entity);

    void update(ChapterProgressEntity entity);

    void delete(ChapterProgressEntity entity);
}
