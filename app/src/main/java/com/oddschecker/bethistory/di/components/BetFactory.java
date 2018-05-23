package com.oddschecker.bethistory.di.components;

import com.oddschecker.bethistory.BetApplication;

public class BetFactory {

    public static BetComponent component(BetApplication context){
        return DaggerBetComponent.builder()
                .application(context)
                .build();
    }
}
