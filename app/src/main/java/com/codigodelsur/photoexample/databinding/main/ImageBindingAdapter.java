package com.codigodelsur.photoexample.databinding.main;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by valentin on 6/23/17.
 */

public final class ImageBindingAdapter {

    @BindingAdapter(value = "url")
    public static void loadImageUrl(ImageView view, String url) {
        if (url != null && !url.equals(""))
            Picasso.with(view.getContext())
                    .load(url)
                    .into(view);
    }

}
