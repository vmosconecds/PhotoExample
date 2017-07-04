package com.codigodelsur.photoexample.data.local.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by valentin on 6/22/17.
 */
@Entity(tableName = "images_urls")
public class ImageUrlEntity {

    @PrimaryKey(autoGenerate = true)
    public long imageUrlId;

    @SerializedName("raw")
    public String imageRaw;

    @SerializedName("full")
    public String imageFull;

    @SerializedName("regular")
    public String imageRegular;

    @SerializedName("small")
    public String imageSmall;

    @SerializedName("thumb")
    public String imageThumb;

}
