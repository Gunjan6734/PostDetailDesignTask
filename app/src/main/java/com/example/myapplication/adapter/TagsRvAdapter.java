package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.TagsRvItemLayoutBinding;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class TagsRvAdapter extends RecyclerView.Adapter<TagsRvAdapter.TagsRvHolder>{

    private Context context;
    private ArrayList<String> tagsList;

    TagsRvItemLayoutBinding binding;

    public TagsRvAdapter(Context context, ArrayList<String> tagsList) {
        this.context = context;
        this.tagsList = tagsList;
    }

    @NonNull
    @Override
    public TagsRvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.tags_rv_item_layout, parent, false);
        return new TagsRvHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull TagsRvHolder holder, int position) {
        binding.tagsTv.setText(tagsList.get(position));
    }

    @Override
    public int getItemCount() {
        return tagsList.size();
    }


    public void updateTagsList(ArrayList<String> tagsList) {
        this.tagsList.clear();
        this.tagsList = tagsList;
        notifyDataSetChanged();
    }

    public static class TagsRvHolder extends RecyclerView.ViewHolder{

        public TagsRvHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
