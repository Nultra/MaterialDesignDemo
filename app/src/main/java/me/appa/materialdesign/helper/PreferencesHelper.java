package me.appa.materialdesign.helper;

import android.content.Context;
import android.content.SharedPreferences;

import me.appa.materialdesign.model.User;

/**
 * Created by yeeni on 2015/11/8.
 */
public class PreferencesHelper {

    private static final String PLAYER_PREFERENCES = "playerPreferences";
    private static final String PREFERENCE_FIRST_NAME = PLAYER_PREFERENCES +".firstName";
    private static final String PREFERENCE_LAST_INITIAL = PLAYER_PREFERENCES + ".lastIntial";

    public PreferencesHelper() {
    }

    public static void writeToPreferences(Context context,User user){
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(PREFERENCE_FIRST_NAME,user.getmFirstName());
        editor.putString(PREFERENCE_LAST_INITIAL, user.getmLastInitial());
        editor.apply();
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.edit();

    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PLAYER_PREFERENCES, context.MODE_PRIVATE);
    }

    public static User getUser(Context context){
        SharedPreferences preferences = getSharedPreferences(context);
        String firstName = preferences.getString(PREFERENCE_FIRST_NAME,null);
        String lastInitial = preferences.getString(PREFERENCE_LAST_INITIAL,null);

        if(null == firstName && null == lastInitial){
            return null;
        }
        return  new User(firstName,lastInitial);
    }

    public static boolean isSignedIn(Context context){
        SharedPreferences preferences = getSharedPreferences(context);
        return  preferences.contains(PREFERENCE_FIRST_NAME)&&
                preferences.contains(PREFERENCE_LAST_INITIAL);
    }

    public static void signOut(Context context){
        SharedPreferences.Editor editor = getEditor(context);
        editor.remove(PREFERENCE_FIRST_NAME);
        editor.remove(PREFERENCE_LAST_INITIAL);
        editor.apply();
    }

}

