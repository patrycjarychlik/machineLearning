package com.patrycja.filip.machinelearning.commons;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zwsfke on 2017-11-29.
 */
public class AppSharedPreferences {
    private static AppSharedPreferences instance;
    private SharedPreferences sharedPreferences;

    private static final String APP_PREFERENCES = "app_preferences";
    private static final String LAUNCH_COUNT = "launch_count";
    private static final String IS_APP_RATED = "is_app_rated";

    private AppSharedPreferences() {
    }

    private AppSharedPreferences(Context context) {
        this.sharedPreferences = context.getSharedPreferences(APP_PREFERENCES, 0);
    }

    public static AppSharedPreferences getInstance(Context context) {
        if (instance == null) {
            instance = new AppSharedPreferences(context);
        }
        return instance;
    }

    public int getLaunchCount() {
        return this.sharedPreferences.getInt(LAUNCH_COUNT, 0);
    }

    public void incrementLaunchCount() {
        int launchCount = getLaunchCount();
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putInt(LAUNCH_COUNT, ++launchCount);
        editor.commit();
    }

    public void resetLaunchCount() {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.remove(LAUNCH_COUNT);
        editor.commit();
    }

    public boolean isAppRated() {
        return this.sharedPreferences.getBoolean(IS_APP_RATED, false);
    }

    public void setIsAppRated(boolean isAppRated) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putBoolean(IS_APP_RATED, isAppRated);
        editor.commit();
    }
}
