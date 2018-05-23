package com.oddschecker.bethistory.di.modules;

import com.oddschecker.bethistory.di.interfaces.CustomScopes;
import com.oddschecker.bethistory.ui.details.DetailsActivity;
import com.oddschecker.bethistory.ui.list.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @CustomScopes.ActivityScope
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @CustomScopes.ActivityScope
    @ContributesAndroidInjector
    abstract DetailsActivity bindDetailsActivity();

}
