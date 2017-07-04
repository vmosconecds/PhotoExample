package com.codigodelsur.photoexample.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.codigodelsur.photoexample.R;
import com.codigodelsur.photoexample.databinding.ActivityMainBinding;
import com.codigodelsur.photoexample.ui.main.view.CustomTabView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.viewPager.setAdapter(new PhotoPagerAdapter(getSupportFragmentManager()));
        binding.tabs.setupWithViewPager(binding.viewPager);
        binding.viewPager.setOffscreenPageLimit(3);
        setupTabs();

        binding.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ((CustomTabView) tab.getCustomView()).mBinding.tabContent.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.tab_indicator_drawable);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ((CustomTabView) tab.getCustomView()).mBinding.tabContent.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setupTabs() {

        CustomTabView popularTab = new CustomTabView(this);
        popularTab.mBinding.tabContent.setText(PhotoPagerAdapter.titles[0]);
        popularTab.mBinding.tabContent.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.tab_indicator_drawable);
        binding.tabs.getTabAt(0).setCustomView(popularTab);

        CustomTabView latestTab = new CustomTabView(this);
        latestTab.mBinding.tabContent.setText(PhotoPagerAdapter.titles[1]);
        binding.tabs.getTabAt(1).setCustomView(latestTab);

        CustomTabView oldestTab = new CustomTabView(this);
        oldestTab.mBinding.tabContent.setText(PhotoPagerAdapter.titles[2]);
        binding.tabs.getTabAt(2).setCustomView(oldestTab);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

}
