package com.patrycja.filip.machinelearning.commons;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zwsfke on 2017-11-29.
 */
public class AppSharedPreferences {
    private static AppSharedPreferences instance;
    private SharedPreferences sharedPreferences;

    private static final int SHARED_PRIVATE_MODE = 0;
    private static final String APP_PREFERENCES = "app_preferences";
    private static final String LAUNCH_COUNT = "launch_count";
    private static final String IS_APP_RATED = "is_app_rated";
    private static final String IS_FIRST_TIME_LAUNCHED = "is_first_time_launched";

    private AppSharedPreferences() {
    }

    private AppSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(APP_PREFERENCES, SHARED_PRIVATE_MODE);
    }

    public static AppSharedPreferences getInstance(Context context) {
        if (instance == null) {
            instance = new AppSharedPreferences(context);
        }
        return instance;
    }

    public int getLaunchCount() {
        return sharedPreferences.getInt(LAUNCH_COUNT, SHARED_PRIVATE_MODE);
    }

    public void incrementLaunchCount() {
        int launchCount = getLaunchCount();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(LAUNCH_COUNT, ++launchCount);
        editor.commit();
    }

    public void resetLaunchCount() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(LAUNCH_COUNT);
        editor.commit();
    }

    public boolean isAppRated() {
        return sharedPreferences.getBoolean(IS_APP_RATED, false);
    }

    public void setIsAppRated(boolean isAppRated) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_APP_RATED, isAppRated);
        editor.commit();
    }

    public boolean isFirstTimeLaunched() {
        return sharedPreferences.getBoolean(IS_FIRST_TIME_LAUNCHED, false);
    }

    public void setIsFirstTimeLaunched() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_FIRST_TIME_LAUNCHED, true);
        editor.commit();
    }
}
