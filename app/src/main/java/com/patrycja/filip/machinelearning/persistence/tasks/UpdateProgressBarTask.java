package com.patrycja.filip.machinelearning.persistence.tasks;

import android.os.AsyncTask;

import com.patrycja.filip.machinelearning.persistence.MachineLearningApp;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;
import com.patrycja.filip.machinelearning.persistence.repository.ChapterRepository;

public class UpdateProgressBarTask extends AsyncTask<Void, Void, Void> {
    private int chapterId;


    public UpdateProgressBarTask(int chapterId) {
        this.chapterId = chapterId;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        //TODO change to count only one per page and to accurate percent

        ChapterRepository chapterRepository = MachineLearningApp.getInstance().getChapterRepository();
        ChapterEntity chapter = chapterRepository.findById(chapterId);

        if (chapter!=null && chapter.getPercentageProgress() < 100) {
            chapter.setPercentageProgress(chapter.getPercentageProgress() + 10);
            chapterRepository.update(chapter);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result1) {

    }
}