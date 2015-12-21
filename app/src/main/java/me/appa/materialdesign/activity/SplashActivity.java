package me.appa.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import me.appa.materialdesign.R;

/**
 * Created by niuxm on 2015/12/7.
 */
public class SplashActivity extends BaseActivity {

    private static final long DELAYTIME = 200;
    private static final int GO_HOME = 1001;
    private Handler mHandler = new Handler(){
    
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == GO_HOME){
                goHome();
            }
        }
    };

    private void goHome() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler.sendEmptyMessageDelayed(GO_HOME, DELAYTIME);
    }
}
