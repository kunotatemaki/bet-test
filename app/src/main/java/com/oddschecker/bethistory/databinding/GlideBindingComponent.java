package com.oddschecker.bethistory.databinding;

public class GlideBindingComponent implements android.databinding.DataBindingComponent {

    @Override
    public GlideBindingAdapters getGlideBindingAdapters() {
        return new GlideBindingAdapters();
    }
}