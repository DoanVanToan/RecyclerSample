package com.framgia.toandoan;

/**
 * Created by framgia on 05/04/2017.
 */
public interface BaseViewModel<T extends BasePresenter> {
    void onStart();
    void onStop();
    void setPresenter(T presenter);
}