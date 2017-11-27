package com.patrycja.filip.machinelearning.persistence.db.helper;

import android.os.Environment;

import com.patrycja.filip.machinelearning.persistence.db.exception.DbExportException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by zwsfke on 2017-11-27.
 */
public abstract class AppDatabaseBackupHelper {

    public static void exportDB() throws DbExportException {
        try {
            File destinationDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File data = Environment.getDataDirectory();

            String currentDBPath = "//data//" + "com.patrycja.filip.machinelearning"
                    + "//databases//" + "learn-ml-db";
            String backupDBPath = "learn-ml-db-backup.db";

            File currentDB = new File(data, currentDBPath);
            File backupDB = new File(destinationDir, backupDBPath);

            backupDB.getParentFile().mkdirs();

            FileChannel src = new FileInputStream(currentDB).getChannel();
            FileChannel dst = new FileOutputStream(backupDB).getChannel();
            dst.transferFrom(src, 0, src.size());
            src.close();
            dst.close();
        } catch (Exception e) {
            throw new DbExportException("An error occurred while exporting the database!", e.getCause());
        }
    }
}
