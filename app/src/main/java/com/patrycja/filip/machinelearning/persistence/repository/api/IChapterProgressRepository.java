package com.patrycja.filip.machinelearning.persistence.repository.api;

import android.arch.lifecycle.LiveData;

import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterProgressEntity;

import java.util.List;

/**
 * Created by zwsfke on 2017-11-27.
 */
public interface IChapterProgressRepository {
    List<ChapterProgressEntity> loadAllPagesByChapterId(int chapterId);
}
