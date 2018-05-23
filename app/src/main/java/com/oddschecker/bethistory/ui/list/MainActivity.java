package com.oddschecker.bethistory.ui.list;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.oddschecker.bethistory.R;
import com.oddschecker.bethistory.databinding.MainActivityBinding;
import com.oddschecker.bethistory.model.BetResponse;
import com.oddschecker.bethistory.ui.common.BaseActivity;
import com.oddschecker.bethistory.ui.details.DetailsActivity;

import java.util.List;

import timber.log.Timber;

public class MainActivity extends BaseActivity {

    BetsRecyclerViewAdapter adapter;
    private MainViewModel viewModel;
    private MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        viewModel.bets.observe(this, betResponses ->
        {
            if(betResponses != null){
                setupRecyclerView(betResponses);
            }
        });



    }

    private void setupRecyclerView(List<BetResponse> responses) {
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter = new BetsRecyclerViewAdapter(responses, bet -> {
            Timber.d("bet: " + bet.betName);
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(DetailsActivity.BET, bet);
            startActivity(intent);

        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            viewModel.downloadData();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
