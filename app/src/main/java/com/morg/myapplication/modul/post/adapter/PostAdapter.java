package com.morg.myapplication.modul.post.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.morg.myapplication.R;
import com.morg.myapplication.core.model.PostModel;
import com.morg.myapplication.databinding.ItemPostBinding;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<PostModel> postModels;
    private final OnItemClickListener listener;


    public PostAdapter(List<PostModel> postModels, OnItemClickListener listener) {
        this.postModels = postModels;
        this.listener = listener;
    }


    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        PostModel p = postModels.get(position);
        holder.binding.tvId.setText(String.valueOf(p.getId()));
        holder.binding.tvTitle.setText(p.getTitle());
        holder.itemView.setOnClickListener(v -> listener.onItemClick(p));
    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }

    public void updateData(List<PostModel> posts) {
        this.postModels = posts;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemPostBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemPostBinding.bind(itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(PostModel post);
    }
}
