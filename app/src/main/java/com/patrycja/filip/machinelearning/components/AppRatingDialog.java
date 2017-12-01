package com.patrycja.filip.machinelearning.components;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;

import com.patrycja.filip.machinelearning.R;
import com.patrycja.filip.machinelearning.commons.AppSharedPreferences;

/**
 * Created by zwsfke on 2017-11-29.
 */
public class AppRatingDialog {

    public static AlertDialog createDialog(Context context) {
        AppSharedPreferences sharedPrefs = AppSharedPreferences.getInstance(context.getApplicationContext());
        AlertDialog dialog = new AlertDialog.Builder(context).setPositiveButton(context.getString(R.string.rate_it), (dialogInterface, i) -> {
            rateIt(context);
            sharedPrefs.setIsAppRated(true);
        }).setNegativeButton(context.getString(R.string.feedback), (dialogInterface, i) -> {
            openFeedback(context);
            sharedPrefs.setIsAppRated(true);
        }).setNeutralButton(context.getString(R.string.ask_later), (dialogInterface, i) -> {
            sharedPrefs.resetLaunchCount();
            dialogInterface.dismiss();
        }).setMessage(context.getString(R.string.rate_msg)).setTitle(context.getString(R.string.rate_our_app)).create();
        return dialog;
    }

    @NonNull
    public static void rateIt(Context paramContext) {
        paramContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/")));
    }

    @NonNull
    private static void openFeedback(Context context) {
        Intent localIntent = new Intent(Intent.ACTION_SEND);
        localIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"dummy_mail@mail.com"});
        localIntent.putExtra(Intent.EXTRA_CC, "");
        localIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback for Machine Learning App");
        localIntent.putExtra(Intent.EXTRA_TEXT, getFeedbackMailFooter(context));
        localIntent.setType("message/rfc822");
        context.startActivity(Intent.createChooser(localIntent, "Choose an Email client :"));
    }

    @NonNull
    private static String getFeedbackMailFooter(Context context) {
        String appVersion;
        try {
            appVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            appVersion = "unknown";
            Log.e("AppRatingDialog", e.getMessage());
        }
        String feedbackMailFooter = String.format("\n\n_______________________________\n Device OS version: %s \n Machine Learning Version: %s \n Device Model: %s", Build.VERSION.RELEASE, appVersion, Build.MODEL);
        return feedbackMailFooter;
    }

}
