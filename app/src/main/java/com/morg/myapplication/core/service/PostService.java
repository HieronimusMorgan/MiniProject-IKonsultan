package com.morg.myapplication.core.service;

import com.morg.myapplication.core.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

    @GET("posts")
    Call<List<PostModel>> getPostList();
}
