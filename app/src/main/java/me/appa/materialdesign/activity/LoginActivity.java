package me.appa.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.appa.materialdesign.R;
import me.appa.materialdesign.fragment.SignInFragment;
import me.appa.materialdesign.helper.PreferencesHelper;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private static final String EXTRA_EDIT = "EDIT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        boolean edit = isInEditMode();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.sign_in_container, SignInFragment.newInstance(edit)).commit();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(PreferencesHelper.isSignedIn(this)){
            finish();
        }
    }

    private boolean isInEditMode() {
        Intent intent = getIntent();
        boolean edit =false;
        if(null == intent){
            edit = intent .getBooleanExtra(EXTRA_EDIT,false
            );
        }
        return  edit;
    }


}
