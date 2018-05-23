package com.oddschecker.bethistory.ui.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.oddschecker.bethistory.databinding.ItemBinding;
import com.oddschecker.bethistory.model.BetResponse;

class BetViewHolder extends RecyclerView.ViewHolder{

    private ItemBinding binding;

    BetViewHolder(@NonNull ItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(BetResponse resp, BetsRecyclerViewAdapter.BetClickCallback callback){
        binding.setResp(resp);
        binding.getRoot().setOnClickListener(view -> callback.onClick(resp));
    }

}