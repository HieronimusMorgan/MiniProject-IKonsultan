package com.morg.myapplication.modul.detail;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.morg.myapplication.core.model.PostModel;
import com.morg.myapplication.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String data = getIntent().getStringExtra("data");
        PostModel postModel = new Gson().fromJson(data, PostModel.class);
        binding.userId.setText("UserID : " + postModel.getUserId());
        binding.id.setText("ID : " + postModel.getUserId());
        binding.title.setText("Title : " + postModel.getTitle());
        binding.body.setText("Body : " + postModel.getBody());
    }
}