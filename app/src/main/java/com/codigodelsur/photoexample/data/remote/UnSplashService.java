package com.codigodelsur.photoexample.data.remote;

import com.codigodelsur.photoexample.data.local.entity.PhotoEntity;
import com.codigodelsur.photoexample.data.local.entity.SortPhotoEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by valentin on 6/20/17.
 */

public interface UnSplashService {

    @GET("photos")
    Call<List<PhotoEntity>> getPhotos(@Query("page") int page, @Query("per_page") int pageNumber, @Query("order_by") SortPhotoEntity sortPhotoEntity);

}
