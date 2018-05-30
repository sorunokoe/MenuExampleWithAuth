package com.kitestart.menuexample.Network;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kitestart.menuexample.Controller.Repos.ListReposController;
import com.kitestart.menuexample.Model.ReposModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ReposService {

    public static ReposService shared = new ReposService();
    private static Context context;

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    private IReposService service = retrofit.create(IReposService.class);


    public void getAllRepos(Context context){
        ReposService.context = context;
        final Call<List<ReposModel>> repos = service.listRepos();

        repos.enqueue(new Callback<List<ReposModel>>() {
            @Override
            public void onResponse(Call<List<ReposModel>> call, Response<List<ReposModel>> response) {
                if(response.isSuccessful()){
                    ArrayList<ReposModel> allRepsos = (ArrayList) response.body();
                    ListReposController.onLoadRepos(ReposService.context, allRepsos, null);
                }else{
                    ListReposController.onLoadRepos(ReposService.context,null, response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<ReposModel>> call, Throwable t) {
                ListReposController.onLoadRepos(ReposService.context,null, "Some problems with thread.");
            }
        });


    }




}

