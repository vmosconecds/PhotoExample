package com.codigodelsur.photoexample.ui.main.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.codigodelsur.photoexample.data.PhotoRepository;
import com.codigodelsur.photoexample.data.Resource;
import com.codigodelsur.photoexample.data.local.entity.PhotoEntity;
import com.codigodelsur.photoexample.data.local.entity.SortPhotoEntity;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by valentin on 6/26/17.
 */

public class OldestPhotoListViewModel extends ViewModel {

    private final LiveData<Resource<List<PhotoEntity>>> photos;

    @Inject
    public OldestPhotoListViewModel(PhotoRepository photoRepository) {
        photos = photoRepository.getPhotos(SortPhotoEntity.OLDEST);
    }

    public LiveData<Resource<List<PhotoEntity>>> getPhotos() { return photos; }

}

