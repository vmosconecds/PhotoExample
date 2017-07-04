package com.codigodelsur.photoexample.di.fragment.builder;

import com.codigodelsur.photoexample.ui.main.fragment.LatestPhotoListFragment;
import com.codigodelsur.photoexample.ui.main.fragment.OldestPhotoListFragment;
import com.codigodelsur.photoexample.ui.main.fragment.PopularPhotoListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by valentin on 6/19/17.
 */
@Module
public abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract PopularPhotoListFragment popularPhotoListFragment();

    @ContributesAndroidInjector
    abstract LatestPhotoListFragment latestPhotoListFragment();

    @ContributesAndroidInjector
    abstract OldestPhotoListFragment oldestPhotoListFragment();

}
