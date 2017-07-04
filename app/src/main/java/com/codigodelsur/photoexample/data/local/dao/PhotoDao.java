package com.codigodelsur.photoexample.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.codigodelsur.photoexample.data.local.entity.PhotoEntity;

import java.util.List;

/**
 * Created by valentin on 6/22/17.
 */
@Dao
public interface PhotoDao {

    @Query("SELECT * FROM photos WHERE type=2")
    LiveData<List<PhotoEntity>> loadPopularPhotos();

    @Query("SELECT * FROM photos WHERE type=1")
    LiveData<List<PhotoEntity>> loadOldestPhotos();

    @Query("SELECT * FROM photos WHERE type=0")
    LiveData<List<PhotoEntity>> loadLatestPhotos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void savePhotos(List<PhotoEntity> photoEntities);
}
