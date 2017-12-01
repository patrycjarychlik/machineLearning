package com.patrycja.filip.machinelearning.persistence.db.exception;

/**
 * Created by zwsfke on 2017-11-27.
 */
public class DbExportException extends Exception {

    public DbExportException(String message) {
        super(message);
    }

    public DbExportException(String message, Throwable cause) {
        super(message, cause);
    }
}
