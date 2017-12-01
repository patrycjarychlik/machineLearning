package com.patrycja.filip.machinelearning.persistence.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zwsfke on 2017-11-26.
 */
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void setUnlocked(boolean unlocked) {
        isUnlocked = unlocked;
    }

    public int getEarnedExp() {
        return earnedExp;
    }

    public void setEarnedExp(int earnedExp) {
        this.earnedExp = earnedExp;
    }

    public int getPercentageProgress() {
        return percentageProgress;
    }

    public void setPercentageProgress(int percentageProgress) {
        this.percentageProgress = percentageProgress;
    }
}
