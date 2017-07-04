package com.codigodelsur.photoexample.data.remote.model;

import com.codigodelsur.photoexample.data.local.entity.PhotoEntity;

import java.util.List;

/**
 * Created by valentin on 6/22/17.
 */

public class PhotoResponse {

    private List<PhotoEntity> photosResult;

    public List<PhotoEntity> getPhotosResult() { return photosResult; }

    public void setPhotosResult(List<PhotoEntity> photosResult) { this.photosResult = photosResult; }

}
