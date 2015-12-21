package me.appa.materialdesign.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import me.appa.materialdesign.R;
import me.appa.materialdesign.fragment.TutorialFragment;

/**
 * Created by niuxm on 2015/11/20.
 */
public class ProductTutorial extends AppCompatActivity {

    private VideoView mVideoView;
    private String mPath;
    private ViewPager mPagers;
    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
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
    }
}
