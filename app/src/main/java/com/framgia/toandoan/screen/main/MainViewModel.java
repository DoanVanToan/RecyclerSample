package com.framgia.toandoan.screen.main;

import android.content.Context;
import android.content.Intent;

import com.framgia.toandoan.screen.option.OptionActivity;

/**
 * Created by framgia on 05/04/2017.
 */
public class MainViewModel implements MainConstract.ViewModel {
    private MainConstract.Presenter mPresenter;
    private Context mContext;

    public MainViewModel(Context context) {
        mContext = context;
    }

    @Override
    public void openOptionView() {
        mContext.startActivity(new Intent(mContext, OptionActivity.class));
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(MainConstract.Presenter presenter) {
        mPresenter = presenter;
    }
}
