package com.codigodelsur.photoexample.di;

import com.codigodelsur.photoexample.ui.main.viewmodel.PopularPhotoListViewModel;

import dagger.Subcomponent;

/**
 * Created by valentin on 6/19/17.
 */
@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    PopularPhotoListViewModel photoListViewModel();
}
