package com.patrycja.filip.machinelearning.persistence.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.content.ContentValues;
import android.util.Log;

import com.patrycja.filip.machinelearning.persistence.AppExecutors;
import com.patrycja.filip.machinelearning.persistence.db.dao.ChapterDao;
import com.patrycja.filip.machinelearning.persistence.db.dao.ChapterProgressDao;
import com.patrycja.filip.machinelearning.persistence.db.dao.UserDetailDao;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterProgressEntity;
import com.patrycja.filip.machinelearning.persistence.db.entity.UserDetailEntity;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by zwsfke on 2017-11-26.
 */
@Database(entities = {ChapterEntity.class, ChapterProgressEntity.class, UserDetailEntity.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabaseInstance;
    private static final String DATABASE_NAME = "learn-ml-db";
    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public abstract ChapterDao chapterDao();

    public abstract ChapterProgressDao chapterProgressDao();

    public abstract UserDetailDao userDetailDao();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors) {
        if (appDatabaseInstance == null) {
            synchronized (AppDatabase.class) {
                if (appDatabaseInstance == null) {
                    appDatabaseInstance = buildDatabase(context.getApplicationContext(), executors);
                    appDatabaseInstance.checkIfAppDatabaseExists(context);
                }
            }
        }
        return appDatabaseInstance;
    }

    private static AppDatabase buildDatabase(final Context appContext,
                                             final AppExecutors executors) {
        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        Log.println(Log.INFO, "I/DATABASE:", "DB Populated on create" + new Date());
                        super.onCreate(db);
                        populateDB(db);
                    }
                    @Override
                    public void onOpen(@NonNull SupportSQLiteDatabase db) {
                        super.onOpen(db);
                        // DB operation on each db open.
                    }
                }).addMigrations().build();
    }

    private static void populateDB(@NonNull SupportSQLiteDatabase db) {
        ContentValues basics = new ContentValues();
        basics.put("title","Basics");
        basics.put("description","Learn Basics od machine learning");
        basics.put("is_unlocked","1");
        basics.put("earned_exp","0");
        basics.put("percentage_progress","0");
        db.insert("chapters", OnConflictStrategy.IGNORE, basics);
    }

    private void checkIfAppDatabaseExists(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setAppDatabaseCreated();
        }
    }

    private void setAppDatabaseCreated() {
        mIsDatabaseCreated.postValue(true);
    }

    public LiveData<Boolean> isDatabaseCreated() {
        return mIsDatabaseCreated;
    }
}
