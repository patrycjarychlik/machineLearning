package com.patrycja.filip.machinelearning.persistence.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.patrycja.filip.machinelearning.persistence.db.entity.UserDetailEntity;

/**
 * Created by zwsfke on 2017-11-26.
 */
@Dao
public interface UserDetailDao {

    @Query("SELECT * FROM user_details WHERE id = :userDetailId")
    UserDetailEntity findById(int userDetailId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserDetailEntity... entity);

    @Update
    void update(UserDetailEntity entity);

    @Delete
    void delete(UserDetailEntity entity);

}
