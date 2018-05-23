package com.oddschecker.bethistory.ui.list;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.oddschecker.bethistory.R;
import com.oddschecker.bethistory.databinding.GlideBindingComponent;
import com.oddschecker.bethistory.databinding.ItemBinding;
import com.oddschecker.bethistory.model.BetResponse;

import java.util.List;

public class BetsRecyclerViewAdapter extends RecyclerView.Adapter<BetViewHolder> {
    private List<BetResponse> bets;
    private BetClickCallback callback;

    BetsRecyclerViewAdapter(List<BetResponse> bets, BetClickCallback callback) {
        this.bets = bets;
        this.callback = callback;
    }

    @Override
    public BetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item, parent, false, new GlideBindingComponent());

        return new BetViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(final BetViewHolder holder, int position) {
        holder.bind(bets.get(position), callback);
    }

    @Override
    public int getItemCount() {

        int count = 0;

        if (bets != null) {
            count = bets.size();
        }
        return count;
    }

    interface BetClickCallback {
        void onClick(BetResponse bet);
    }

}
