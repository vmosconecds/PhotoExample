package com.codigodelsur.photoexample.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.codigodelsur.photoexample.ui.main.fragment.LatestPhotoListFragment;
import com.codigodelsur.photoexample.ui.main.fragment.OldestPhotoListFragment;
import com.codigodelsur.photoexample.ui.main.fragment.PopularPhotoListFragment;

/**
 * Created by valentin on 6/22/17.
 */

public class PhotoPagerAdapter extends FragmentStatePagerAdapter {

    public static final String[] titles = new String[]{"POPULAR", "LATEST" ,"OLDEST"};

    public PhotoPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment;
        switch (i) {
            case 0:
                fragment = PopularPhotoListFragment.newInstance();
                break;
            case 1:
                fragment = LatestPhotoListFragment.newInstance();
                break;
            case 2:
                fragment = OldestPhotoListFragment.newInstance();
                break;

            default:
                throw new UnsupportedOperationException("Could not create an instance");
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
