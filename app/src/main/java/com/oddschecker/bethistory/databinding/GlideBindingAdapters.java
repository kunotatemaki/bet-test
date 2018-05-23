package com.oddschecker.bethistory.databinding;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.request.RequestOptions;

public class GlideBindingAdapters {

    @BindingAdapter("imageFitCenter")
    public void setImageUrlCenterAndFitted(ImageView view, String url) {
        //cropped images
        if (url != null) {
            Glide.with(view.getContext())
                    .load(url)
                    .apply(new RequestOptions()
                            .fitCenter())
                    .into(view);
        }
    }

    @BindingAdapter("isVisibleOrGone")
    public <T> void setIsVisibleOrGone(ImageView view, T isVisible) {
        if (isVisible != null) {
            if (isVisible instanceof Boolean && (Boolean) isVisible) {
                view.setVisibility(View.VISIBLE);
            } else if (isVisible instanceof String && !((String) isVisible).isEmpty()) {
                view.setVisibility(View.VISIBLE);

            }
            return;
        }
        view.setVisibility(View.GONE);
    }
}
