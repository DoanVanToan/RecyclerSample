package com.framgia.toandoan.data.option.model;

import android.database.Cursor;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.toandoan.BR;
import com.framgia.toandoan.data.option.source.local.OptionPersistenceContract;
import java.util.ArrayList;
import java.util.List;

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

    public OptionItem(Cursor cursor) {
        mId = cursor.getInt(
                cursor.getColumnIndex(OptionPersistenceContract.OptionEntry.COLUMN_ENTRY_ID));
        mTitle = cursor.getString(
                cursor.getColumnIndex(OptionPersistenceContract.OptionEntry.COLUMN_TITLE));
        mUrl = cursor.getString(
                cursor.getColumnIndex(OptionPersistenceContract.OptionEntry.COLUMN_URL));
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

    public static List<OptionItem> getListOption(Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) return null;
        List<OptionItem> options = new ArrayList<>();

        do {
            options.add(new OptionItem(cursor));
        } while (cursor.moveToNext());

        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return options;
    }
}
