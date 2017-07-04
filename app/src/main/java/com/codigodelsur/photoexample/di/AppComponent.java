package com.codigodelsur.photoexample.di;

import android.app.Application;

import com.codigodelsur.photoexample.PhotoApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by valentin on 6/12/17.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(PhotoApp app);

}
