package com.patrycja.filip.machinelearning.components;

import android.app.AlertDialog;
import android.content.Context;

import com.patrycja.filip.machinelearning.R;

/**
 * Created by zwsfke on 2017-11-29.
 */
public class AppBadgesDialog {

    public static AlertDialog createDialog(Context context, String msg) {
        return new AlertDialog.Builder(context)
                .setPositiveButton(context.getString(R.string.ok), (dialogInterface, i) -> dialogInterface.dismiss()).setMessage(msg)
                .setTitle(context.getString(R.string.your_badge))
                .create();
    }

}
