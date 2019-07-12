package com.storyPost.PhotoVideoDownloader.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

public class PreferencesManager {
    private final static String TAG = PreferencesManager.class.getSimpleName();
    //    private static PreferencesManager instance;
    private static SharedPreferences pref;

    public static void init(Context context) {
        String PREF_NAME = context.getPackageName();
        if (pref == null) {
//            pref = android.preference.PreferenceManager.getDefaultSharedPreferences(context);

            //With this code gettting proble, as our service is on remote process
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
            } else {
                pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            }
        } else {
            throw new RuntimeException("Double init our preference");
        }
    }

    private static SharedPreferences.Editor getEditor() {
        return pref.edit();
    }

    public static void savePref(String key, Object value) {

        SharedPreferences.Editor editor = getEditor();

        if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Enum) {
            editor.putString(key, value.toString());
        } else if (value != null) {
            throw new RuntimeException("Attempting to save non-primitive preference");
        }

        editor.commit();
    }


    @SuppressWarnings("unchecked")
    public static <T> T getPref(String key) {
        return (T) pref.getAll().get(key);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getPref(String key, T defValue) {

        T returnValue = (T) pref.getAll().get(key);
        return returnValue == null ? defValue : returnValue;
    }

    public static void remove(String key) {
        SharedPreferences.Editor editor = getEditor();
        editor.remove(key);
        editor.commit();
    }

    public static void clear() {
        SharedPreferences.Editor editor = getEditor();
        editor.clear();
        editor.commit();
    }




    public static class keys {
        public static final String USER_ID="user_id";
        public static final String USER_TOKEN="user_token";
        public static final String USER_PROFILE_DATA="user_profile_data";

    }


}
