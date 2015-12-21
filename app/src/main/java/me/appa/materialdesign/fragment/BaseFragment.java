package me.appa.materialdesign.fragment;

import com.squareup.leakcanary.RefWatcher;

import me.appa.materialdesign.NewApp;

/**
 * Created by niuxm on 2015/12/3.
 */
public class BaseFragment extends android.support.v4.app.Fragment {

    @Override
    public void onDestroy() {
        super.onDestroy();

        RefWatcher watcher = NewApp.getRefWatcher(getActivity());
        watcher.watch(this);
    }
}
