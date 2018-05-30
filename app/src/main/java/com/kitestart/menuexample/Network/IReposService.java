package com.kitestart.menuexample.Network;

import com.kitestart.menuexample.Model.ReposModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface IReposService {

    @GET("repositories?since=364")
    Call<List<ReposModel>> listRepos();

}
