package com.framgia.toandoan.screen.main;

import com.framgia.toandoan.BasePresenter;
import com.framgia.toandoan.BaseViewModel;

/**
 * Created by framgia on 05/04/2017.
 */
public interface MainConstract {
    interface ViewModel extends BaseViewModel<Presenter> {
        void openOptionView();
    }

    interface Presenter extends BasePresenter {
    }
}
