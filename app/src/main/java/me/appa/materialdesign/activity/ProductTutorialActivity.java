package me.appa.materialdesign.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

import me.appa.materialdesign.R;
import me.appa.materialdesign.fragment.TutorialFragment;
import me.appa.materialdesign.widget.CirclePageIndicator;

/**
 * Created by niuxm on 2015/11/20.
 */
public class ProductTutorialActivity extends BaseActivity {

    private VideoView mVideoView;
    private String mPath;
    private ViewPager mPagers;
    private ViewPagerAdapter mViewPagerAdapter;
    private CirclePageIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_tutorial);
        mVideoView = VideoView.class.cast(findViewById(R.id.video_view));
        mPath = "android.resource://" + getPackageName() + "/" + R.raw.appintro;
        mVideoView.setVideoURI(Uri.parse(mPath));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer arg0) {
                mVideoView.requestFocus();
                mVideoView.start();
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mVideoView.setVideoURI(Uri.parse(mPath));
            }
        });
        mPagers = (ViewPager) findViewById(R.id.viewpager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPagers.setAdapter(mViewPagerAdapter);
        indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPagers);

        mPagers.setPageTransformer(true, new CustomPageTransformer());
        mPagers.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                System.out.println("onPageScrolled " + position + "positionOffset " + positionOffset + "positionOffsetPixels " + positionOffsetPixels);

            }

            @Override
            public void onPageSelected(int position) {
                    System.out.println("onPageSelected "+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                System.out.println("onPageScrollStateChanged "+state);
            }
        });
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            TutorialFragment tutorialFragment = null;
            switch (position) {
                case 0:
                    tutorialFragment = TutorialFragment.newInstance(R.layout.tutorial_fragment1);
                    break;
                case 1:
                    tutorialFragment = TutorialFragment.newInstance(R.layout.tutorial_fragment2);
                    break;
                case 2:
                    tutorialFragment = TutorialFragment.newInstance(R.layout.tutorial_fragment3);
                    break;
            }
            return tutorialFragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);

        }
    }

    private class CustomPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        @Override
        public void transformPage(View page, float position) {
            int pageHeight = page.getHeight();
            int pageWidth = page.getWidth();
            System.out.println("CustomPageTransformer    "+position);

            if(position < -1){
                page.setAlpha(0);

            }else if(position <=1){

                float scaleFactor = Math.max(MIN_SCALE, 1- Math.abs(position));
                float verMargin = pageHeight * (1 - scaleFactor) /2 ;
                float horzMargin = pageWidth * (1 -scaleFactor) /2 ;
                if(position <0){
                    page.setTranslationX(horzMargin-verMargin/2);
                }else{
                    page.setTranslationX(-horzMargin+verMargin/2);
                }

                page.setScaleY(scaleFactor);
                page.setScaleX(scaleFactor);

                page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE)
                        / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoView.stopPlayback();
        mVideoView = null;
    }
}