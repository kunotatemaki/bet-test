package com.oddschecker.bethistory.ui.common;

import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    @Inject
    protected ViewModelProvider.Factory viewModelFactory;


}
