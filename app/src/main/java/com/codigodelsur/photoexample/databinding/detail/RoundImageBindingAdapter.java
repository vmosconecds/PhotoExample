package com.codigodelsur.photoexample.databinding.detail;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.codigodelsur.photoexample.util.CircleTransform;
import com.squareup.picasso.Picasso;

/**
 * Created by valentin on 6/28/17.
 */

public class RoundImageBindingAdapter {
    @BindingAdapter(value = "circular_image")
    public static void loadImageUrl(ImageView view, String url) {
        if (url != null && !url.equals(""))
            Picasso.with(view.getContext())
                    .load(url)
                    .transform(new CircleTransform())
                    .into(view);
    }
}
