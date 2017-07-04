package com.codigodelsur.photoexample.ui.main;

import android.view.View;

import com.codigodelsur.photoexample.data.local.entity.PhotoEntity;

/**
 * Created by valentin on 6/22/17.
 */

public interface PhotoListCallback {

    void onPhotoClicked(PhotoEntity photoEntity, View sharedView);

}
