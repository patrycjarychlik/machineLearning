package com.patrycja.filip.machinelearning.persistence.db.migration.sql.initializer;

import android.arch.persistence.db.SupportSQLiteDatabase;

/**
 * Created by zwsfke on 2018-02-13.
 */

public interface DatabaseInitializer {

    default void populateDatabase(SupportSQLiteDatabase database) {
        database.execSQL("Insert into user_details (total_exp) values (0)");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Basics', '1', '0', '0')");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Market', '0', '0', '0')");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Process', '0', '0', '0')");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Problems', '0', '0', '0')");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Supervised', '0', '0', '0')");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Unsupervised', '0', '0', '0')");
        database.execSQL("Insert into chapters (title, is_unlocked, earned_exp, percentage_progress) values ('Chapter', '0', '0', '0')");
    }

}
