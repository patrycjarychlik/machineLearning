package com.patrycja.filip.machinelearning.persistence.repository;

import com.patrycja.filip.machinelearning.persistence.db.AppDatabase;
import com.patrycja.filip.machinelearning.persistence.db.entity.UserDetailEntity;
import com.patrycja.filip.machinelearning.persistence.repository.api.IUserRepository;

/**
 * Created by zwsfke on 2017-11-27.
 */
public class UserRepository extends DataRepository implements IUserRepository {
    private static UserRepository dataRepoInstance;

    private UserRepository(AppDatabase database) {
        super(database);
    }

    public static UserRepository getInstance(final AppDatabase database) {
        if (dataRepoInstance == null) {
            synchronized (UserRepository.class) {
                if (dataRepoInstance == null) {
                    dataRepoInstance = new UserRepository(database);
                }
            }
        }
        return dataRepoInstance;
    }


    @Override
    public UserDetailEntity findById(int chapterId) {
        return database.userDetailDao().findById(chapterId);
    }

    @Override
    public void insert(UserDetailEntity... entity){
        database.userDetailDao().insert(entity);
    }

    @Override
    public void update(UserDetailEntity entity){
        database.userDetailDao().update(entity);
    }

    @Override
    public void delete(UserDetailEntity entity){
        database.userDetailDao().delete(entity);
    }
}
