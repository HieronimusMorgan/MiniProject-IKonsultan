package com.morg.myapplication.core.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.morg.myapplication.core.model.PostModel;
import com.morg.myapplication.core.service.PostService;
import com.morg.myapplication.utils.http.ApiHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {
    private PostService postService;

    public PostRepository() {
        this.postService = ApiHelper.getClient().create(PostService.class);
    }

    public void getData(MutableLiveData<List<PostModel>> data) {
        postService.getPostList().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                data.setValue(null);
            }
        });
    }
}
