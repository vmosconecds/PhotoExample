package com.codigodelsur.photoexample.data;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.codigodelsur.photoexample.data.local.dao.PhotoDao;
import com.codigodelsur.photoexample.data.local.entity.PhotoEntity;
import com.codigodelsur.photoexample.data.remote.UnSplashService;
import com.codigodelsur.photoexample.data.local.entity.SortPhotoEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Call;



/**
 * Created by valentin on 6/22/17.
 */

public class PhotoRepository {

    private final static int PHOTOS_PER_PAGE = 10;

    private final PhotoDao photoDao;
    private final UnSplashService unSplashService;

    private Observable<List<PhotoEntity>> listObservable;
    private int currentPage;

    @Inject
    public PhotoRepository(PhotoDao photoDao, UnSplashService unSplashService) {
        this.photoDao = photoDao;
        this.unSplashService = unSplashService;
        currentPage = 1;
    }

    public LiveData<Resource<List<PhotoEntity>>> getPhotos(SortPhotoEntity sortPhotoEntity) {
        return new NetworkBoundResource<List<PhotoEntity>, List<PhotoEntity>>() {

            @Override
            protected void saveCallResult(@NonNull List<PhotoEntity> items) {
                if (items.size() != 0) {
                    for (PhotoEntity item: items) {
                        item.type = sortPhotoEntity;
                    }
                    photoDao.savePhotos(items);
                }
            }

            @NonNull
            @Override
            protected LiveData<List<PhotoEntity>> loadFromDb() {
                switch (sortPhotoEntity) {
                    case POPULAR:
                        return photoDao.loadPopularPhotos();
                    case LATEST:
                        return photoDao.loadLatestPhotos();
                    case OLDEST:
                        return photoDao.loadOldestPhotos();
                }
                return photoDao.loadPopularPhotos();
            }

            @NonNull
            @Override
            protected Call<List<PhotoEntity>> createCall() {
                return unSplashService.getPhotos(currentPage, PHOTOS_PER_PAGE, sortPhotoEntity);
            }
        }.getAsLiveData();
    }
}
