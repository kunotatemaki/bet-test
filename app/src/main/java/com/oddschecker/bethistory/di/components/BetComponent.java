package com.oddschecker.bethistory.di.components;


import com.oddschecker.bethistory.BetApplication;
import com.oddschecker.bethistory.di.modules.ActivityBuilder;
import com.oddschecker.bethistory.di.modules.BetModule;
import com.oddschecker.bethistory.di.modules.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, BetModule.class,
        ActivityBuilder.class,
        ViewModelModule.class})
public interface BetComponent extends AndroidInjector<BetApplication> {

    @Override
    void inject(BetApplication instance);


    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(BetApplication application);

        BetComponent build();
    }
}