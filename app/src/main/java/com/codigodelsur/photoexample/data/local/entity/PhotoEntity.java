package com.codigodelsur.photoexample.data.local.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by valentin on 6/22/17.
 */
@Entity(tableName = "photos")
public class PhotoEntity {

    @PrimaryKey
    @SerializedName("id")
    public String photoId;

    @SerializedName("width")
    public int width;

    @SerializedName("height")
    public int height;

    @SerializedName("color")
    public String color;

    @SerializedName("likes")
    public int likes;

    @SerializedName("liked_by_user")
    public boolean likedByUser;

    @SerializedName("user")
    @Embedded
    public UserEntity user;

    @SerializedName("urls")
    @Embedded
    public ImageUrlEntity urls;

    @SerializedName("type")
    public SortPhotoEntity type;

}
