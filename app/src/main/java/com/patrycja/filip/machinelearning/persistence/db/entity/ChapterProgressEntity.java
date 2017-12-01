package com.patrycja.filip.machinelearning.persistence.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zwsfke on 2017-11-26.
 */
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean isCorrectAnswered() {
        return correctAnswered;
    }

    public void setCorrectAnswered(boolean correctAnswered) {
        this.correctAnswered = correctAnswered;
    }

    public int getTimeTookToAnswer() {
        return timeTookToAnswer;
    }

    public void setTimeTookToAnswer(int timeTookToAnswer) {
        this.timeTookToAnswer = timeTookToAnswer;
    }
}
