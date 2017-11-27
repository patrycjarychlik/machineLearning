package com.patrycja.filip.machinelearning.persistence.repository;

import com.patrycja.filip.machinelearning.persistence.db.AppDatabase;

/**
 * Created by zwsfke on 2017-11-27.
 */

public class DataRepository {
    final AppDatabase database;

    DataRepository(final AppDatabase database) {
        this.database = database;
    }
}
