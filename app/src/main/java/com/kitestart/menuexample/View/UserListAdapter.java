package com.kitestart.menuexample.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kitestart.menuexample.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;
import com.kitestart.menuexample.Model.UsersModel;

public class UserListAdapter extends ArrayAdapter<UsersModel>{

    Context context;
    ArrayList<UsersModel> allUsers;

    public UserListAdapter(@NonNull Context context, ArrayList<UsersModel> objects) {
        super(context, 0, objects);
        this.context = context;
        this.allUsers = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false);
        }

        UsersModel user = allUsers.get(position);

        ImageView image = convertView.findViewById(R.id.logoImageView);
        TextView name = convertView.findViewById(R.id.nameTextView);
        TextView status = convertView.findViewById(R.id.statusTextView);

        name.setText(user.getName());
        status.setText(user.getStatus());


        return convertView;
    }



}
