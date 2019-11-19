package com.example.moviecataloguesub2.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.Context;

import com.example.moviecataloguesub2.R;
import com.example.moviecataloguesub2.listmovie.ListMovieFragment;
import com.example.moviecataloguesub2.listtvshow.TvShowListFragment;

public class SelectionsPagerAdapter extends FragmentPagerAdapter {
    @StringRes
    private static final int[] TAB_TITLE = new int[]{R.string.tab_title_1, R.string.tab_title_2};
    private final Context movieContext;
    private ListMovieFragment movieFragment;
    private TvShowListFragment tvShowFragment;

    public SelectionsPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        movieContext = context;
        movieFragment = new ListMovieFragment();
        tvShowFragment = new TvShowListFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

                return new ListMovieFragment();
            case 1:
                return new TvShowListFragment();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return movieContext.getResources().getString(TAB_TITLE[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}