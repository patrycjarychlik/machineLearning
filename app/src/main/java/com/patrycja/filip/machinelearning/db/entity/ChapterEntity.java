package com.patrycja.filip.machinelearning.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import lombok.Data;

/**
 * Created by zwsfke on 2017-11-26.
 */
@Data
@Entity(tableName = "chapters")
public class ChapterEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;

    @ColumnInfo(name = "is_unlocked")
    private boolean isUnlocked;

    @ColumnInfo(name = "earned_exp")
    private int earnedExp;

    @ColumnInfo(name = "percentage_progress")
    private int percentageProgress;
}
