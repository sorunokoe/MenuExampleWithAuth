
package com.kitestart.menuexample.Controller;

        import android.content.ContentValues;
        import android.content.Intent;
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

public class SignUpController extends AppCompatActivity {


    DBHelper dbHelper;


    EditText loginField, passwordField, emailField;
    Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_controller);


        dbHelper = new DBHelper(this, "MenuExampleDB", 1);

        setViews();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid(loginField.getText().toString()) && isValid(emailField.getText().toString()) && isValid(passwordField.getText().toString())){

                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("login", loginField.getText().toString());
                    contentValues.put("password", passwordField.getText().toString());
                    db.insert("UserTable", null, contentValues);
                    db.close();


                    signUp();
                }else{
                    Toast.makeText(SignUpController.this, "Fill all the fields!", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }

    void setViews(){
        loginField = findViewById(R.id.loginRegField);
        passwordField = findViewById(R.id.passwordRegField);
        emailField = findViewById(R.id.emailRegField);
        signUpBtn = findViewById(R.id.signUpBtn);
    }

    void signUp(){
        Intent intent = new Intent(SignUpController.this, LoginActivity.class);
        startActivity(intent);
    }

    boolean isValid(String value){
        if(value.length()>3){
            return true;
        }
        return false;
    }

}
