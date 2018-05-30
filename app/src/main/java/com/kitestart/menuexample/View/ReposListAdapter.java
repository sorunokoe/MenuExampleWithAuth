package com.kitestart.menuexample.View;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kitestart.menuexample.Model.ReposModel;
import com.kitestart.menuexample.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ReposListAdapter extends ArrayAdapter<ReposModel>{


    private Context context;
    private ArrayList<ReposModel> allRepos;

    public ReposListAdapter(Context context, ArrayList<ReposModel> allRepos) {
        super(context, 0, allRepos);
        this.context = context;
        this.allRepos = allRepos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.repos_list_item, parent, false);
        }

        TextView title = view.findViewById(R.id.repoTitleTxtView);
        TextView desc = view.findViewById(R.id.repoDescTxtView);

        ReposModel repo = allRepos.get(position);
        title.setText(repo.getName());
        desc.setText(repo.getDescription());

        return view;

    }



}
