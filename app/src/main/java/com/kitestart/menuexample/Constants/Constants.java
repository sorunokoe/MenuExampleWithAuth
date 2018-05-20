package com.kitestart.menuexample.Constants;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Constants {

    public static Constants shared = new Constants();
    public String login;
    public String email;
    private Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedEditor;

    public void config(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("ExampleAppPreferences", Activity.MODE_PRIVATE);
        sharedEditor =  sharedPreferences.edit();
    }

    public void setCredentials(String login, String email){
        this.login = login;
        sharedEditor.putString("myLogin", login);
        sharedEditor.putString("myEmail", email);
        sharedEditor.commit();
    }

    public String getEmail() {
        System.out.println(email);
        System.out.println(sharedPreferences.getString("myEmail", null));
        if(email == null) {
            email = sharedPreferences.getString("myEmail", null);
        }
        return email;
    }

    public String getLogin() {
        if(login == null) {
            login = sharedPreferences.getString("myLogin", null);
        }
        return login;
    }

    public boolean removeCredentials(){
        try {
            login = null;
            email = null;
            sharedEditor.remove("myLogin");
            sharedEditor.remove("myEmail");
            sharedEditor.commit();
        }catch (Exception ex){
            return false;
        }
        return true;
    }

}
