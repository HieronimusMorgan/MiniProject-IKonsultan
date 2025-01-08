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

    public PostAdapter(List<PostModel> postModels) {
        this.postModels = postModels;
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
        holder.binding.tvId.setText(p.getId());
        holder.binding.tvTitle.setText(p.getTitle());
    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }

    public void  updateData(List<PostModel> postModels) {
        postModels.clear();
        postModels.addAll(postModels);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemPostBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemPostBinding.bind(itemView);
        }
    }
}
