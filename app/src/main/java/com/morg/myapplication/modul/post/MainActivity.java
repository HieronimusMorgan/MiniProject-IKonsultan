package com.morg.myapplication.modul.post;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.morg.myapplication.R;
import com.morg.myapplication.core.model.PostModel;
import com.morg.myapplication.databinding.ActivityMainBinding;
import com.morg.myapplication.modul.detail.DetailActivity;
import com.morg.myapplication.modul.post.adapter.PostAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected ActivityMainBinding binding;
    protected PostAdapter adapter;
    protected List<PostModel> allPosts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        PostViewModel viewModel = new ViewModelProvider(this).get(PostViewModel.class);

        adapter = new PostAdapter(allPosts, post -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("data", new Gson().toJson(post));
            startActivity(intent);
        });

        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(adapter);

        viewModel.getPostList().observe(this, posts -> {
            allPosts = posts;
            adapter.updateData(posts);
        });

        viewModel.getData();


        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<PostModel> filteredPosts = new ArrayList<>();
                for (PostModel post : allPosts) {
                    if (post.getTitle().toLowerCase().contains(newText.toLowerCase())) {
                        filteredPosts.add(post);
                    }
                }
                adapter.updateData(filteredPosts);
                return true;
            }
        });
    }
}