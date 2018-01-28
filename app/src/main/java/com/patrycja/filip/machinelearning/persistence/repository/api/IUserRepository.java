package com.patrycja.filip.machinelearning.persistence.repository.api;

import com.patrycja.filip.machinelearning.persistence.db.entity.UserDetailEntity;

/**
 * Created by patyk on 28.01.2018.
 */

public interface IUserRepository {


    UserDetailEntity findById(int chapterId);

    void insert(UserDetailEntity... entity);

    void update(UserDetailEntity entity);

    void delete(UserDetailEntity entity);
}
