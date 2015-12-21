package me.appa.materialdesign.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.appa.materialdesign.fragment.PageFragment;

/**
 * Created by yeeni on 2015/11/8.
 */
public class SimpleFragmentAdapter extends FragmentPagerAdapter {

    int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"tab1","tab2","tab3","tab4","tab5","tab6","tab7"};
    private Context context;
    public SimpleFragmentAdapter(FragmentManager fm , Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
