package com.codigodelsur.photoexample.ui.detail.fragment;

import android.arch.lifecycle.LifecycleFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codigodelsur.photoexample.data.local.entity.PhotoEntity;
import com.codigodelsur.photoexample.databinding.FragmentUserProfileBinding;
import com.google.gson.Gson;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by valentin on 6/27/17.
 */

public class UserProfileFragment extends LifecycleFragment {


    public PhotoEntity photoEntity;

    FragmentUserProfileBinding binding;

    public static UserProfileFragment newInstance(PhotoEntity photoEntity) {
        Bundle args = new Bundle();
        args.putString("PHOTO_ENTITY", new Gson().toJson(photoEntity, PhotoEntity.class));
        UserProfileFragment fragment = new UserProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentUserProfileBinding.inflate(inflater, container, false);
        this.photoEntity = new Gson().fromJson(getArguments().getString("PHOTO_ENTITY"), PhotoEntity.class);
        binding.setPhotoEntity(photoEntity);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }
}
