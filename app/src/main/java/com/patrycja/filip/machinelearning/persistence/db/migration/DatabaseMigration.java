package com.patrycja.filip.machinelearning.persistence.db.migration;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.migration.Migration;

/**
 * Created by zwsfke on 2018-02-13.
 */

public interface DatabaseMigration {

    Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE user_details (id INTEGER PRIMARY KEY AUTOINCREMENT, total_exp INTEGER NOT NULL DEFAULT 0)");
            database.execSQL("CREATE TABLE chapters (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, isUnlocked INTEGER NOT NULL DEFAULT 0, earned_exp INTEGER NOT NULL DEFAULT 0, percentage_progress INTEGER NOT NULL DEFAULT 0)");
            database.execSQL("CREATE TABLE chapter_progress (id INTEGER PRIMARY KEY AUTOINCREMENT, chapter_id INTEGER NOT NULL, question_id INTEGER NOT NULL, correct_answered INTEGER NOT NULL, time_took_to_answer INTEGER NOT NULL, FOREIGN KEY(chapter_id) REFERENCES chapters(id))");
        }
    };

    Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("Insert into user_details (total_exp) values (0)");
            database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 1', '1', '0', '0')");
            database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 2', '0', '0', '0')");
            database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 3', '0', '0', '0')");
            database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 4', '0', '0', '0')");
            database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 5', '0', '0', '0')");
            database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 6', '0', '0', '0')");
            database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 7', '0', '0', '0')");
        }
    };

    Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            //Todo: add questions table
        }
    };
}
