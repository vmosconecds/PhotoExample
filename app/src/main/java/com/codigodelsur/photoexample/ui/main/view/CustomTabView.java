package com.codigodelsur.photoexample.ui.main.view;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.codigodelsur.photoexample.R;
import com.codigodelsur.photoexample.databinding.CustomTabIndicatorViewBinding;

/**
 * Created by valentin on 6/27/17.
 */
@InverseBindingMethods(value = {
        @InverseBindingMethod(type = CustomTabView.class, attribute = "bind:filterStringValue", method = "getFilterValue", event = "android:filterStringValuetAttrChanged")
})
public class CustomTabView extends LinearLayout{

    public CustomTabIndicatorViewBinding mBinding;

    public CustomTabView(Context context) {
        super(context);
        init(context);
    }

    public CustomTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CustomTabView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_tab_indicator_view, this, true);
        setOrientation(HORIZONTAL);
    }

    @BindingAdapter(value = {"bind:tabText"})
    public static void setTabText(CustomTabView view, String tabText) {
        view.mBinding.tabContent.setText(tabText);
    }

}
