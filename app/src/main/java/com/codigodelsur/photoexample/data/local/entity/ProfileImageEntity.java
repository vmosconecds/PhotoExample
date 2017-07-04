package com.codigodelsur.photoexample.data.local.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by valentin on 6/22/17.
 */
@Entity(tableName = "profileImages")
public class ProfileImageEntity {

    @PrimaryKey(autoGenerate = true)
    public long profileImageId;

    @SerializedName("small")
    public String small;

    @SerializedName("medium")
    public String medium;

    @SerializedName("large")
    public String large;

}
