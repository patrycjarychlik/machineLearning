package com.patrycja.filip.machinelearning.persistence.tasks;

import android.os.AsyncTask;

import com.patrycja.filip.machinelearning.persistence.MachineLearningApp;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;
import com.patrycja.filip.machinelearning.persistence.db.entity.UserDetailEntity;
import com.patrycja.filip.machinelearning.persistence.repository.ChapterRepository;
import com.patrycja.filip.machinelearning.persistence.repository.UserRepository;

public class UpdateExpTask extends AsyncTask<Void, Void, Void> {
    private int chapterId;


    public UpdateExpTask(int chapterId) {
        this.chapterId = chapterId;
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        ChapterRepository chapterRepository = MachineLearningApp.getInstance().getChapterRepository();
        ChapterEntity chapter = chapterRepository.findById(chapterId);

        if (chapter != null) {
            int calculatedExp = chapter.getEarnedExp() + 10;
            chapter.setEarnedExp(calculatedExp);
            chapterRepository.update(chapter);

            UserRepository userRepository = MachineLearningApp.getInstance().getUserRepository();
            UserDetailEntity userDetails = userRepository.findById(1);
            if (userDetails != null) {
                userDetails.setTotalExp(userDetails.getTotalExp() + calculatedExp);
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result1) {

    }
}