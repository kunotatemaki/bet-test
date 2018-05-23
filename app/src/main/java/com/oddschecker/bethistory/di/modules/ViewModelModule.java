package com.oddschecker.bethistory.di.modules;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.oddschecker.bethistory.ui.list.MainViewModel;
import com.oddschecker.bethistory.di.interfaces.ViewModelKey;
import com.oddschecker.bethistory.viewmodel.BetViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindSearchViewModel(MainViewModel mainViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(BetViewModelFactory factory);
}

