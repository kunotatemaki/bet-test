package com.oddschecker.bethistory.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.google.gson.Gson;
import com.oddschecker.bethistory.model.BetResponse;
import com.oddschecker.bethistory.model.BetResponseFromServer;
import com.oddschecker.bethistory.utils.AssetUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FakeNetworkModule {

    private Context context;

    @Inject
    FakeNetworkModule(Context context) {
        this.context = context;
    }

    public LiveData<List<BetResponse>> getBets() {
        try {
            String bets = AssetUtils.readFromFile(context, "mybets.json");
            Gson gson = new Gson();
            BetResponseFromServer responseFromServer = gson.fromJson(bets, BetResponseFromServer.class);
            LiveData<List<BetResponse>> list = new MutableLiveData<>();
            List<BetResponse> responses = BetParser.parseResponses(responseFromServer);
            ((MutableLiveData<List<BetResponse>>) list).setValue(responses);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }
}
