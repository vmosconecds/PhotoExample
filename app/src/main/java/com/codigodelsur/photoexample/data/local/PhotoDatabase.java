package com.codigodelsur.photoexample.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.codigodelsur.photoexample.data.local.converter.SortPhotoConverter;
import com.codigodelsur.photoexample.data.local.dao.PhotoDao;
import com.codigodelsur.photoexample.data.local.entity.PhotoEntity;

/**
 * Created by valentin on 6/22/17.
 */
@Database(entities= {PhotoEntity.class}, version = 1)
@TypeConverters(SortPhotoConverter.class)
public abstract class PhotoDatabase extends RoomDatabase {

    public abstract PhotoDao photoDao();

}
