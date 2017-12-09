package com.patrycja.filip.machinelearning.commons;

import android.app.Activity;
import android.media.MediaPlayer;

import com.patrycja.filip.machinelearning.R;

/**
 * Created by zwsfke on 2017-12-09.
 */

public class SoundPlayer {
    /**
     * This method plays the correct answer sound.
     * It is non-commercial use!
     * http://www.orangefreesounds.com/game-show-correct-answer/
     * It is licensed under: “Attribution-NonCommercial 4.0 International (CC BY-NC 4.0)”
     *
     * @param callerActivity
     */
    public static void playCorrectAnswerSound(Activity callerActivity) {
        MediaPlayer mPlayer = MediaPlayer.create(callerActivity, R.raw.game_correct_answer_sound);
        mPlayer.setLooping(false);
        mPlayer.start();
    }
}
