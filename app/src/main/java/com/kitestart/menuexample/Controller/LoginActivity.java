package com.kitestart.menuexample.Controller;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kitestart.menuexample.Constants.Constants;
import com.kitestart.menuexample.Database.DBHelper;
import com.kitestart.menuexample.R;

public class LoginActivity extends AppCompatActivity {


    DBHelper dbHelper;


    EditText loginField, passwordField, emailField;
    Button signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        dbHelper = new DBHelper(this, "MenuExampleDB", 1);



        Constants.shared.config(LoginActivity.this);

        String login = Constants.shared.getLogin();
        String email = Constants.shared.getEmail();

        if( login != null && email != null){
            signIn(login, email);
        }

        setViews();

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid(loginField.getText().toString()) && isValid(emailField.getText().toString()) && isValid(passwordField.getText().toString())){

                    String login = loginField.getText().toString();
                    String password = passwordField.getText().toString();


                    SQLiteDatabase db = dbHelper.getReadableDatabase();

                    Cursor c = db.query("UserTable", null, null, null, null, null, null);

                    Boolean isValid = false;
                    if (c.moveToFirst()) {
                        int loginColIndex = c.getColumnIndex("login");
                        int passwordColIndex = c.getColumnIndex("password");
                        do {

                            if(login.equals(c.getString(loginColIndex))){
                                if(password.equals(c.getString(passwordColIndex))){
                                    isValid=true;
                                    break;
                                }else{
                                    Toast.makeText(LoginActivity.this, "Password error", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(LoginActivity.this, "Login error", Toast.LENGTH_SHORT).show();
                            }

                        } while (c.moveToNext());
                    }

                    db.close();
                    if(isValid){
                        Constants.shared.setCredentials(loginField.getText().toString(), emailField.getText().toString());
                        signIn(loginField.getText().toString(), emailField.getText().toString());
                    }else{
                        Toast.makeText(LoginActivity.this, "Auth error", Toast.LENGTH_SHORT).show();
                    }



                }else{
                    Toast.makeText(LoginActivity.this, "Fill all the fields!", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }

    void setViews(){
        loginField = findViewById(R.id.loginField);
        passwordField = findViewById(R.id.passwordField);
        emailField = findViewById(R.id.emailField);
        signInBtn = findViewById(R.id.signInBtn);
    }

    void signIn(String login, String email){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    boolean isValid(String value){
        if(value.length()>3){
            return true;
        }
        return false;
    }

}
