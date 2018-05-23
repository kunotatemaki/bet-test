package com.oddschecker.bethistory.ui.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.view.ViewTreeObserver;

import com.oddschecker.bethistory.R;
import com.oddschecker.bethistory.databinding.DetailsBinding;
import com.oddschecker.bethistory.databinding.GlideBindingComponent;
import com.oddschecker.bethistory.model.BetResponse;
import com.oddschecker.bethistory.ui.common.BaseActivity;

public class DetailsActivity extends BaseActivity {

    public final static String BET = "my_bet";

    private DetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_init);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details_init, new GlideBindingComponent());
        //addAnimationOperations();

        if (getIntent() == null || !getIntent().hasExtra(BET)) {
            //no data, kill the activity
            finish();
            return;
        }

        setSupportActionBar(binding.toolbar);

        BetResponse bet = getIntent().getParcelableExtra(BET);
        binding.content.setResp(bet);

        binding.content.container.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        binding.content.container.getViewTreeObserver().removeOnPreDrawListener(this);
                        supportStartPostponedEnterTransition();
                        addAnimationOperations();
                        return true;
                    }
                }
        );

    }

    private void addAnimationOperations() {


        ConstraintSet constraint1 = new ConstraintSet();
        constraint1.clone(this, R.layout.content_details);
        TransitionManager.beginDelayedTransition(binding.content.container);
        constraint1.applyTo(binding.content.container);

    }

}
