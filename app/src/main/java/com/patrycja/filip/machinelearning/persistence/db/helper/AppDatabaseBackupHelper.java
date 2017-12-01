package com.patrycja.filip.machinelearning.persistence.db.helper;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.patrycja.filip.machinelearning.persistence.db.exception.DbExportException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by zwsfke on 2017-11-27.
 */
public abstract class AppDatabaseBackupHelper {

    public static void exportDatabaseToDownloadsDir(Activity activity) {
        if (isReadWritePermissionsGranted(activity.getApplicationContext()) && needRequestForPermissions()) {
            activity.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        try {
            exportDB();
            Toast.makeText(activity.getApplicationContext(), "DB Backup successfully created!", Toast.LENGTH_SHORT).show();
        } catch (DbExportException e) {
            Log.println(Log.ERROR, "DbExportError", e.getMessage());
            Toast.makeText(activity.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private static void exportDB() throws DbExportException {
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

    private static boolean needRequestForPermissions() {
        return Build.VERSION.SDK_INT > 22;
    }

    private static boolean isReadWritePermissionsGranted(Context context) {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED;
    }
}
