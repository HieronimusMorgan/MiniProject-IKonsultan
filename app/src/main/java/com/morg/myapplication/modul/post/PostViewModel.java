package com.morg.myapplication.modul.post;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.morg.myapplication.core.model.PostModel;
import com.morg.myapplication.core.repository.PostRepository;

import java.util.List;

public class PostViewModel extends ViewModel {
    private final MutableLiveData<List<PostModel>> data = new MutableLiveData<>();
    private final PostRepository postRepository;

    public PostViewModel(){
        this.postRepository = new PostRepository();
    }

    public void getData(){
        postRepository.getData(data);
    }

    public LiveData<List<PostModel>> getPostList (){
        return data;
    }
}
