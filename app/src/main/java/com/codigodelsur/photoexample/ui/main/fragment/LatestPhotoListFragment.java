package com.codigodelsur.photoexample.ui.main.fragment;

import android.arch.lifecycle.LifecycleFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codigodelsur.photoexample.data.local.entity.PhotoEntity;
import com.codigodelsur.photoexample.databinding.FragmentPhotoListBinding;
import com.codigodelsur.photoexample.ui.detail.DetailActivity;
import com.codigodelsur.photoexample.ui.main.PhotoListAdapter;
import com.codigodelsur.photoexample.ui.main.PhotoListCallback;
import com.codigodelsur.photoexample.ui.main.viewmodel.LatestPhotoListViewModel;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by valentin on 6/26/17.
 */

public class LatestPhotoListFragment extends LifecycleFragment implements PhotoListCallback {

    @Inject
    LatestPhotoListViewModel photoListViewModel;

    FragmentPhotoListBinding binding;

    public static LatestPhotoListFragment newInstance() {
        Bundle args = new Bundle();
        LatestPhotoListFragment fragment = new LatestPhotoListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPhotoListBinding.inflate(inflater, container, false);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.setAdapter(new PhotoListAdapter(this));
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        photoListViewModel.getPhotos().observe(this, listResource -> binding.setResource(listResource));

    }

    @Override
    public void onPhotoClicked(PhotoEntity photoEntity, View sharedView) {
        startActivity(DetailActivity.newIntent(getActivity(), photoEntity));
    }

}
