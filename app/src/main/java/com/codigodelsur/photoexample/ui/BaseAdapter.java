package com.codigodelsur.photoexample.ui;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by valentin on 6/22/17.
 */

public abstract class BaseAdapter<Type extends RecyclerView.ViewHolder, Data> extends RecyclerView.Adapter<Type>{

    public abstract void setData(List<Data> data);
}
