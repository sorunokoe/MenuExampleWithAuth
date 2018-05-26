package com.kitestart.menuexample.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
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

        final ArrayList<UsersModel> users = new ArrayList();
        UsersModel user1 = new UsersModel("Jerry", "Yoyoyo how are ou.", 24.1,72.1);
        UsersModel user2 = new UsersModel("Tom", "Yoyoyo how are ou.",21.34,73.12);
        UsersModel user3 = new UsersModel("Mario", "Yoyoyo how are ou.",32.12,70.12);
        users.add(user1);
        users.add(user2);
        users.add(user3);


        userListView = findViewById(R.id.userListView);

        UserListAdapter adapter = new UserListAdapter(this, users);

        userListView.setAdapter(adapter);

        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                UsersModel user = users.get(position);

                UserMapActivity.name = user.getName();
                UserMapActivity.status = user.getStatus();
                UserMapActivity.lat = user.getLat();
                UserMapActivity.lon = user.getLon();


                Intent intent = new Intent(getApplicationContext(), UserMapActivity.class);

                startActivity(intent);

            }
        });


    }
}
