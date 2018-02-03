package com.patrycja.filip.machinelearning.persistence.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;

import java.util.List;

/**
 * Created by zwsfke on 2017-11-26.
 */
@Dao
public interface ChapterDao {

    @Query("SELECT * FROM chapters")
    LiveData<List<ChapterEntity>> loadChapters();

    @Query("SELECT * FROM chapters WHERE id= :chapterId")
    ChapterEntity findById(int chapterId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ChapterEntity... entity);

    @Update
    void update(ChapterEntity entity);

    @Delete
    void delete(ChapterEntity entity);

}
