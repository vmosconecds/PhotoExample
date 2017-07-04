package com.codigodelsur.photoexample.data.local.converter;

import android.arch.persistence.room.TypeConverter;

import com.codigodelsur.photoexample.data.local.entity.SortPhotoEntity;


/**
 * Created by valentin on 6/26/17.
 */

public class SortPhotoConverter {

    @TypeConverter
     public int SortPhotoEntityToInt(SortPhotoEntity value) {
         return value.getCode();
     }

     @TypeConverter
     public SortPhotoEntity intToSortPhotoEntity(int value) {

        SortPhotoEntity result = null;

         if (value == SortPhotoEntity.LATEST.getCode()) {
             result = SortPhotoEntity.LATEST;
         }
         if (value == SortPhotoEntity.POPULAR.getCode()) {
             result = SortPhotoEntity.POPULAR;
         }
         if (value == SortPhotoEntity.OLDEST.getCode()) {
             result = SortPhotoEntity.OLDEST;
         }

         return result;
     }
}
