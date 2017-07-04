package com.codigodelsur.photoexample;

import android.app.Activity;
import android.app.Application;

import com.codigodelsur.photoexample.di.DaggerAppComponent;
import com.facebook.stetho.Stetho;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by valentin on 6/12/17.
 */

public class PhotoApp extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        initializeComponent();
    }

    private void initializeComponent() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
