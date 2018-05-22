package com.kitestart.menuexample.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kitestart.menuexample.Model.UsersModel;
import com.kitestart.menuexample.R;
import com.kitestart.menuexample.View.UserListAdapter;

import java.util.ArrayList;


public class UserListController extends AppCompatActivity {

    ListView userListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list_controller);

        ArrayList<UsersModel> users = new ArrayList();
        UsersModel user1 = new UsersModel("Jerry", "Yoyoyo how are ou.");
        UsersModel user2 = new UsersModel("Jerry", "Yoyoyo how are ou.");
        UsersModel user3 = new UsersModel("Jerry", "Yoyoyo how are ou.");
        users.add(user1);
        users.add(user2);
        users.add(user3);


        userListView = findViewById(R.id.userListView);

        UserListAdapter adapter = new UserListAdapter(this, users);

        userListView.setAdapter(adapter);


    }
}
