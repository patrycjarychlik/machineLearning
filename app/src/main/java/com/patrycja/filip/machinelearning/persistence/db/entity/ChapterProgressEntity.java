package com.patrycja.filip.machinelearning.persistence.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import lombok.Data;

/**
 * Created by zwsfke on 2017-11-26.
 */
@Data
@Entity(tableName = "chapter_progress",
        foreignKeys = {
                @ForeignKey(entity = ChapterEntity.class,
                        parentColumns = "id",
                        childColumns = "chapter_id")
        })
public class ChapterProgressEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "chapter_id")
    private int chapterId;

    @ColumnInfo(name = "question_id")
    private int questionId;

    @ColumnInfo(name = "correct_answered")
    private boolean correctAnswered;

    @ColumnInfo(name = "time_took_to_answer")
    private int timeTookToAnswer;
}
