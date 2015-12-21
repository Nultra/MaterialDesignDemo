package me.appa.materialdesign.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import me.appa.materialdesign.R;

public class Main2Activity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabs;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("内容简介"));
        tabs.addTab(tabs.newTab().setText("作者简介"));
        tabs.addTab(tabs.newTab().setText("目录"));
        tabs.addTab(tabs.newTab().setText("书评"));

        viewPager = (ViewPager) findViewById(R.id.viewpager);

    }

}
