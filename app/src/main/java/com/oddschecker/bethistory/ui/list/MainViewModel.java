package com.oddschecker.bethistory.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.oddschecker.bethistory.model.BetResponse;
import com.oddschecker.bethistory.network.FakeNetworkModule;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    private FakeNetworkModule networkModule;

    private MutableLiveData query = new MutableLiveData<Long>();

    LiveData<List<BetResponse>> bets;

    @Inject
    MainViewModel(FakeNetworkModule fakeNetworkModule) {
        networkModule = fakeNetworkModule;
        query.setValue(System.currentTimeMillis());
        bets = Transformations.switchMap(query, value -> getListOfUsers());
    }

    LiveData<List<BetResponse>> getListOfUsers() {
        return networkModule.getBets();
    }



    void downloadData() {
        query.setValue(System.currentTimeMillis());
    }
}
