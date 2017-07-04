package com.codigodelsur.photoexample.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.codigodelsur.photoexample.data.local.entity.PhotoEntity;
import com.codigodelsur.photoexample.databinding.ItemPhotoListBinding;
import com.codigodelsur.photoexample.ui.BaseAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by valentin on 6/22/17.
 */

public class PhotoListAdapter extends BaseAdapter<PhotoListAdapter.PhotoViewHolder, PhotoEntity> {

    private List<PhotoEntity> photoEntities;

    private PhotoListCallback photoListCallback;

    public PhotoListAdapter(@NonNull PhotoListCallback photoListCallback) {
        photoEntities = new ArrayList<>();
        this.photoListCallback = photoListCallback;
    }

    @Override
    public void setData(List<PhotoEntity> photoEntities) {
        this.photoEntities = photoEntities;
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return PhotoViewHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup, photoListCallback);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder photoViewHolder, int i) {
        photoViewHolder.onBind(photoEntities.get(i));
    }

    @Override
    public int getItemCount() {
        return photoEntities.size();
    }


    static class PhotoViewHolder extends RecyclerView.ViewHolder {

        public static PhotoViewHolder create(LayoutInflater inflater, ViewGroup parent, PhotoListCallback callback) {
            ItemPhotoListBinding itemMovieListBinding = ItemPhotoListBinding.inflate(inflater, parent, false);
            return new PhotoViewHolder(itemMovieListBinding, callback);
        }

        ItemPhotoListBinding binding;

        public PhotoViewHolder(ItemPhotoListBinding binding, PhotoListCallback callback) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(v ->
                    callback.onPhotoClicked(binding.getPhoto(), binding.imageViewCover));

        }

        public void onBind(PhotoEntity photoEntity) {
            binding.setPhoto(photoEntity);
            binding.executePendingBindings();
        }

    }

}
