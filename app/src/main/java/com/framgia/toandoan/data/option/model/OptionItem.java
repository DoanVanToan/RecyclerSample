package com.framgia.toandoan.data.option.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.framgia.toandoan.BR;

/**
 * Created by framgia on 29/03/2017.
 */
public class OptionItem extends BaseObservable {
    private int mId;
    private String mTitle;
    private String mUrl;

    public OptionItem(int id, String title, String url) {
        mId = id;
        mTitle = title;
        mUrl = url;
    }

    @Bindable
    public int getId() {
        return mId;
    }

    public void setId(int id) {
        notifyPropertyChanged(BR.id);
        mId = id;
    }

    @Bindable
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        notifyPropertyChanged(BR.title);
        mTitle = title;
    }

    @Bindable
    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        notifyPropertyChanged(BR.url);
        mUrl = url;
    }
}
