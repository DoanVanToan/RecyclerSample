package com.framgia.toandoan;

import android.databinding.BindingAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.framgia.toandoan.screen.option.OptionAdapter;

/**
 * Created by framgia on 29/03/2017.
 */
public class BindingUtil {
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
            .load(url)
            .centerCrop()
            .into(view);
    }

    @BindingAdapter({"bind:onTouch", "bind:position"})
    public static void setOnTouchListenner(EditText view, final OptionAdapter adapter,
                                           final int position) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                adapter.onAddNewOption(position);
                return false;
            }
        });
    }
}
