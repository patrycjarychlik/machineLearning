package com.patrycja.filip.machinelearning.persistence.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import lombok.Data;

/**
 * Created by zwsfke on 2017-11-26.
 */
@Data
@Entity(tableName = "user_details")
public class UserDetailEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "total_exp")
    private int totalExp;
}
