package me.appa.materialdesign;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import me.drakeet.library.CrashWoodpecker;

/**
 * Created by niuxm on 2015/12/2.
 */
public class NewApp extends Application{

    public static RefWatcher getRefWatcher(Context context) {
        NewApp application = (NewApp) context.getApplicationContext();
        return  application.mRefWatcher;
    }

    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        CrashWoodpecker.fly().to(this);
        mRefWatcher = LeakCanary.install(this);
    }
}
