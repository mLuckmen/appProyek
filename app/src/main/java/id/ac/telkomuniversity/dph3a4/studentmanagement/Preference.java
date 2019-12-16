package id.ac.telkomuniversity.dph3a4.studentmanagement;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Preference {
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    Context context;

    private final String PREF_NAME = "STUDENT_MANAGEMENT";

    public Preference(Context context) {
        super();
        this.context = context;
    }

    public void userHasLoggedIn(boolean loggedIn){
        settings = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        editor = settings.edit();

        editor.putBoolean("loggedIn", loggedIn);
        editor.commit();
    }

    public boolean getUserLoggedIn(){
        settings = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        return settings.getBoolean("loggedIn", false);
    }

    public void removePreference(){
        settings = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        editor = settings.edit();

        editor.clear();
        editor.commit();
    }

    public void setUserCredentials(int id){
        settings = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        editor = settings.edit();

        editor.putInt("id", id);
        editor.commit();
    }

    public int getUserId(){
        settings = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        return settings.getInt("id", 0);
    }

    public String getUsername(){
        settings = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        return settings.getString("username", "");
    }
}
