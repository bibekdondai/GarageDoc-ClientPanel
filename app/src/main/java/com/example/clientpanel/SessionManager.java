package com.example.clientpanel;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SessionManager {

    private static final String PREF_NAME = "SessionPref";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_EMAIL = "email";
    private static final String TAG = "SessionManager";
    private static final String KEY_FULL_NAME = "fullName";

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void setLoggedIn(boolean isLoggedIn, String email) {
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);
        editor.putString(KEY_EMAIL, email);
        editor.apply();
        Log.d(TAG, "User logged in: " + isLoggedIn + ", email: " + email);
    }

    public boolean isLoggedIn() {
        boolean loggedIn = pref.getBoolean(KEY_IS_LOGGED_IN, false);
        Log.d(TAG, "isLoggedIn: " + loggedIn);
        return loggedIn;
    }

    public String getEmail() {
        String email = pref.getString(KEY_EMAIL, null);
        Log.d(TAG, "getEmail: " + email);
        return email;
    }

//    public void setFullName(String fullName) {
//        editor.putString(KEY_FULL_NAME, fullName);
//        editor.apply(); // Use apply() for asynchronous save
//        Log.d(TAG, "Full name set: " + fullName);
//    }

    public String getFullName() {
        String fullName = pref.getString(KEY_FULL_NAME, null);
        Log.d(TAG, "getFullName: " + fullName);
        return fullName;
    }

    public void clearSession() {
        editor.remove(KEY_IS_LOGGED_IN);
        editor.remove(KEY_EMAIL);
        editor.remove(KEY_FULL_NAME); // Clear full name on logout
        editor.apply();
        Log.d(TAG, "Session cleared");
    }
}
