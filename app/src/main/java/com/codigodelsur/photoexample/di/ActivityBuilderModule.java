package com.codigodelsur.photoexample.di;

import com.codigodelsur.photoexample.di.fragment.builder.DetailFragmentBuilderModule;
import com.codigodelsur.photoexample.di.fragment.builder.MainFragmentBuilderModule;
import com.codigodelsur.photoexample.ui.detail.DetailActivity;
import com.codigodelsur.photoexample.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by valentin on 6/19/17.
 */
@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = MainFragmentBuilderModule.class)
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = DetailFragmentBuilderModule.class)
    abstract DetailActivity detailActivity();

}
