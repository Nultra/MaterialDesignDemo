package me.appa.materialdesign.activity;

import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.leakcanary.RefWatcher;

import me.appa.materialdesign.NewApp;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by niuxm on 2015/12/3.
 */
public class BaseActivity extends AppCompatActivity {


    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

    Retrofit mRetrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com").addConverterFactory(GsonConverterFactory.create(gson)).build();


    @Override
    protected void onDestroy() {
        super.onDestroy();
            RefWatcher refWatcher = NewApp.getRefWatcher(getApplicationContext());
        refWatcher.watch(this);
    }
}

