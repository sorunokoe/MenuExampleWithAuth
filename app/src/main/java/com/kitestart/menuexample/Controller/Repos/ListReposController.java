package com.kitestart.menuexample.Controller.Repos;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kitestart.menuexample.Model.ReposModel;
import com.kitestart.menuexample.Network.ReposService;
import com.kitestart.menuexample.R;
import com.kitestart.menuexample.View.ReposListAdapter;

import java.util.ArrayList;

public class ListReposController extends AppCompatActivity {

    static ListView listReposView;
    static ArrayList<ReposModel> allRepos = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_repos_controller);

        listReposView = findViewById(R.id.reposListView);
        getRepos();

    }

    void getRepos(){
        ReposService.shared.getAllRepos(this);
    }
    public static void onLoadRepos(Context context, ArrayList<ReposModel> allRepos , String error){
        if(error == null){
            ListReposController.allRepos = allRepos;
            ReposListAdapter adapter = new ReposListAdapter(context, allRepos);
            adapter.notifyDataSetChanged();
            ListReposController.listReposView.setAdapter(adapter);
        }
    }

}
