package com.patrycja.filip.machinelearning.persistence.db.migration.sql.initializer;

import android.arch.persistence.db.SupportSQLiteDatabase;

/**
 * Created by zwsfke on 2018-02-13.
 */

public interface DatabaseInitializer {

    default void populateDatabase(SupportSQLiteDatabase database) {
        database.execSQL("Insert into user_details (total_exp) values (0)");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 1', '1', '0', '0')");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 2', '0', '0', '0')");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 3', '0', '0', '0')");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 4', '0', '0', '0')");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 5', '0', '0', '0')");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 6', '0', '0', '0')");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter 7', '0', '0', '0')");
    }

}
