package com.codigodelsur.photoexample.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.util.ArrayMap;

import com.codigodelsur.photoexample.di.ViewModelSubComponent;
import com.codigodelsur.photoexample.ui.main.viewmodel.PopularPhotoListViewModel;

import java.util.Map;
import java.util.concurrent.Callable;

import javax.inject.Inject;

/**
 * Created by valentin on 6/22/17.
 */

public class PhotoViewModelFactory implements ViewModelProvider.Factory {

    private final ArrayMap<Class, Callable<? extends ViewModel>> creators;

    @Inject
    public PhotoViewModelFactory(ViewModelSubComponent viewModelSubComponent) {
        creators = new ArrayMap<>();
        creators.put(PopularPhotoListViewModel.class, () -> viewModelSubComponent.photoListViewModel());
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Callable<? extends ViewModel> creator = creators.get(modelClass);
        if (creator == null) {
            for (Map.Entry<Class, Callable<? extends ViewModel>> entry : creators.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException("unknown model class " + modelClass);
        }
        try {
            return (T) creator.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
