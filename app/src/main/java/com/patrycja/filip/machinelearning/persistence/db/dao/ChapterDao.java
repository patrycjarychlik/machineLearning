package com.patrycja.filip.machinelearning.persistence.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;

import java.util.List;

/**
 * Created by zwsfke on 2017-11-26.
 */
@Dao
public interface ChapterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ChapterEntity> chapters);

    @Query("SELECT * FROM ChapterEntity")
    LiveData<List<ChapterEntity>> loadChapters();
}
