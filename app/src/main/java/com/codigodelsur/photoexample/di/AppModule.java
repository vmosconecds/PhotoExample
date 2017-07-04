package com.codigodelsur.photoexample.di;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;

import com.codigodelsur.photoexample.data.local.PhotoDatabase;
import com.codigodelsur.photoexample.data.local.dao.PhotoDao;
import com.codigodelsur.photoexample.data.remote.ApiConstants;
import com.codigodelsur.photoexample.data.remote.RequestInterceptor;
import com.codigodelsur.photoexample.data.remote.UnSplashService;
import com.codigodelsur.photoexample.viewmodel.PhotoViewModelFactory;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by valentin on 6/19/17.
 */
@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        //okHttpClient.connectTimeout(ApiConstants.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        //okHttpClient.readTimeout(ApiConstants.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.addInterceptor(new RequestInterceptor());
        okHttpClient.addNetworkInterceptor(new StethoInterceptor());
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    UnSplashService provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(UnSplashService.class);
    }

    @Provides
    @Singleton
    PhotoDatabase providePhotoDatabase(Application application) {
        return Room.databaseBuilder(application, PhotoDatabase.class, "photoDemo.db").build();
    }

    @Provides
    @Singleton
    PhotoDao provideMovieDao(PhotoDatabase photoDatabase) {
        return photoDatabase.photoDao();
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder builder){
        return new PhotoViewModelFactory(builder.build());
    }
}
