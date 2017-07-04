package com.codigodelsur.photoexample.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.codigodelsur.photoexample.R;
import com.codigodelsur.photoexample.data.local.entity.PhotoEntity;
import com.codigodelsur.photoexample.databinding.ActivityDetailBinding;
import com.codigodelsur.photoexample.ui.detail.fragment.UserProfileFragment;
import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class DetailActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    ActivityDetailBinding binding;

    public PhotoEntity photoEntity;

    public static Intent newIntent(Context context, PhotoEntity photoEntity) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("PHOTO_ENTITY", new Gson().toJson(photoEntity, PhotoEntity.class));
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        photoEntity = new Gson().fromJson(getIntent().getStringExtra("PHOTO_ENTITY"), PhotoEntity.class);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, UserProfileFragment.newInstance(photoEntity))
                    .commitAllowingStateLoss();
        }

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
