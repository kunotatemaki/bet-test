package com.oddschecker.bethistory.di.modules;

import android.content.Context;

import com.oddschecker.bethistory.BetApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class BetModule {


    @Provides
    Context providesContext(BetApplication application) {
        return application.getApplicationContext();
    }
}
