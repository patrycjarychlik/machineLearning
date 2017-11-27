package com.patrycja.filip.machinelearning.persistence.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zwsfke on 2017-11-26.
 */
@Entity(tableName = "user_details")
public class UserDetailEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "total_exp")
    private int totalExp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(int totalExp) {
        this.totalExp = totalExp;
    }
}
