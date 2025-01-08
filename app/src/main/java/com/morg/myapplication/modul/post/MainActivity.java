package com.morg.myapplication.modul.post;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.morg.myapplication.R;
import com.morg.myapplication.core.model.PostModel;
import com.morg.myapplication.databinding.ActivityMainBinding;
import com.morg.myapplication.modul.post.adapter.PostAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected ActivityMainBinding binding;
    protected PostAdapter postAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        PostViewModel viewModel = new ViewModelProvider(this).get(PostViewModel.class);

        postAdapter = new PostAdapter(new ArrayList<>());
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(postAdapter);

        viewModel.getPostList().observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postAdapter.updateData(postModels);
            }
        });

        viewModel.getData();
    }
}