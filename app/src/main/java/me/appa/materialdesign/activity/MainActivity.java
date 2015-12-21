package me.appa.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import me.appa.materialdesign.R;
import me.appa.materialdesign.adapter.SimpleFragmentAdapter;
import me.appa.materialdesign.adapter.ViewPagerAdapter;
import me.appa.materialdesign.fragment.CardFragment;
import me.appa.materialdesign.fragment.FirstFragment;

import static android.support.design.widget.Snackbar.LENGTH_SHORT;

public class MainActivity extends BaseActivity {
    private DrawerLayout mDrawerLayout;
    public NavigationView navigationView;
    public Toolbar mToolbar;
    public TabLayout tabs;
    public ViewPager viewPager;
    public SimpleFragmentAdapter simpleFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
//            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
//            supportActionBar.setHomeButtonEnabled(true); //设置返回键可用


        }

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close);

        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        viewPager = (ViewPager) findViewById(R.id.viewpaper);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FirstFragment(), "首页");
        viewPagerAdapter.addFragment(new CardFragment(), "卡片");

//        simpleFragmentAdapter = new SimpleFragmentAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(viewPagerAdapter);
        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabs.setupWithViewPager(viewPager);
        navigationView = (NavigationView) findViewById(R.id.nv_main_navigation);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

    }

    private void switchToBook() {
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragme_content,new BookFragment()).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()) {
            case R.id.action_search:
                msg += "Click search";
                break;
            case R.id.action_share:
                msg += "Click share";
                 case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
        }
        if (!msg.equals("")) {
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
        return true;
    }


    private void setupDrawerContent(final NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Snackbar.make(navigationView, item.getTitle() + "pressed", LENGTH_SHORT).show();
                        break;

                    case R.id.nav_friends:
                        startActivity(new Intent(MainActivity.this, ProductTutorialActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        break;

                    case R.id.nav_messages:

                        break;

                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }


    private long exitTime = 0;

    public void doExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, R.string.press_again_exit_app, Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

  /*  @Override
    public void onBackPressed() {
        if (selectedFragment == null || !selectedFragment.onBackPressed()) {
            if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            } else {
                doExitApp();
            }
        }

    }*/

    private void testOkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url("https://github.com/hongyangAndroid").build();


        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });


    }
}
