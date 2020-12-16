package com.example.project2_eoghan_spillane;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    private TabLayout tabs;
    RecyclerView f;


    public PagerAdapter(FragmentManager fm, int numOfTabs, RecyclerView f){
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new StringFragment(f);
            case 1:
                return new PercussionFragment();
            case 2:
                return new WindFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
