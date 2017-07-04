package com.codigodelsur.photoexample.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.codigodelsur.photoexample.data.Resource;
import com.codigodelsur.photoexample.ui.BaseAdapter;

import java.util.List;

/**
 * Created by valentin on 6/22/17.
 */

public final class ListBindingAdapter{
    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter == null)
            return;

        if(resource == null || resource.data == null)
            return;

        if(adapter instanceof BaseAdapter){
            ((BaseAdapter)adapter).setData((List) resource.data);
        }
    }
}
