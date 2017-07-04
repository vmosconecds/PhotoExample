package com.codigodelsur.photoexample.di.fragment.builder;

import com.codigodelsur.photoexample.ui.detail.fragment.UserProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by valentin on 6/27/17.
 */
@Module
public abstract class DetailFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract UserProfileFragment userProfileFragment();

}
