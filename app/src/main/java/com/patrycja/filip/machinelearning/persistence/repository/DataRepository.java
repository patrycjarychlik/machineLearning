package com.patrycja.filip.machinelearning.persistence.repository;

import com.patrycja.filip.machinelearning.persistence.db.AppDatabase;

/**
 * Created by zwsfke on 2017-11-27.
 */

public class DataRepository {
    private static DataRepository dataRepoInstance;
    final AppDatabase database;

    DataRepository(final AppDatabase database) {
        this.database = database;
    }

    public static DataRepository getInstance(final AppDatabase database) {
        if (dataRepoInstance == null) {
            synchronized (DataRepository.class) {
                if (dataRepoInstance == null) {
                    dataRepoInstance = new DataRepository(database);
                }
            }
        }
        return dataRepoInstance;
    }

}
