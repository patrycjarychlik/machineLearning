package com.patrycja.filip.machinelearning.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.patrycja.filip.machinelearning.R;
import com.patrycja.filip.machinelearning.commons.SoundPlayer;

/**
 * Created by zwsfke on 2017-11-27.
 */
public class SettingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Settings");

        //Todo: Use this sound when correct answer is given in quiz
        Button btnCorrectSound = (Button) view.findViewById(R.id.btn_correct_sound);
        btnCorrectSound.setOnClickListener(btnClick -> SoundPlayer.playCorrectAnswerSound(this.getActivity()));
    }

}
