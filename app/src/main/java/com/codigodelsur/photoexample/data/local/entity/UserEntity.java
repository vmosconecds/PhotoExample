package com.codigodelsur.photoexample.data.local.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by valentin on 6/22/17.
 */
@Entity(tableName = "users")
public class UserEntity {

    @PrimaryKey
    @SerializedName("id")
    public String userId;

    @SerializedName("username")
    public String username;

    @SerializedName("name")
    public String name;

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("portfolio_url")
    public String portfolioUrl;

    @SerializedName("bio")
    public String bio;

    @SerializedName("location")
    public String location;

    @SerializedName("total_likes")
    public int totalLikes;

    @SerializedName("total_photos")
    public int totalPhotos;

    @SerializedName("total_collections")
    public int totalCollections;

    @SerializedName("profile_image")
    @Embedded
    public ProfileImageEntity profileImage;



}
