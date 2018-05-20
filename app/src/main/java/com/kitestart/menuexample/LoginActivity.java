package com.kitestart.menuexample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kitestart.menuexample.Constants.Constants;

public class LoginActivity extends AppCompatActivity {


    EditText loginField, passwordField, emailField;
    Button signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

                if(isValid(loginField.getText().toString()) && isValid(emailField.getText().toString())){
                    Constants.shared.setCredentials(loginField.getText().toString(), emailField.getText().toString());
                    signIn(loginField.getText().toString(), emailField.getText().toString());
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
