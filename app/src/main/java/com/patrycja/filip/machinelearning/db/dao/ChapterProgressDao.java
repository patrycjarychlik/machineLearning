package com.patrycja.filip.machinelearning.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.patrycja.filip.machinelearning.db.entity.ChapterProgressEntity;

import java.util.List;

/**
 * Created by zwsfke on 2017-11-26.
 */
@Dao
public interface ChapterProgressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ChapterProgressEntity chapterProgress);

    @Query("SELECT * FROM chapter_progress WHERE chapterId = :chapterId")
    List<ChapterProgressEntity> loadAllByChapterId(int chapterId);
}
