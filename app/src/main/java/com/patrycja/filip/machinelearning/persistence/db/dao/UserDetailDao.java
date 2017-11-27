package com.patrycja.filip.machinelearning.persistence.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.patrycja.filip.machinelearning.persistence.db.entity.UserDetailEntity;

/**
 * Created by zwsfke on 2017-11-26.
 */
@Dao
public interface UserDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserDetailEntity userDetail);

    @Query("SELECT * FROM user_details WHERE id = :userDetailId")
    UserDetailEntity loadById(int userDetailId);
}