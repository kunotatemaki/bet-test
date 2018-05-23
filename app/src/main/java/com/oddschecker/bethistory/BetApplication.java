package com.oddschecker.bethistory;

import com.oddschecker.bethistory.di.components.BetComponent;
import com.oddschecker.bethistory.di.components.BetFactory;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import timber.log.Timber;

public class BetApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        BetComponent mComponent = BetFactory.component(this);
        mComponent.inject(this);
        return mComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Logging with Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }


}
