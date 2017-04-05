package com.framgia.toandoan.data.option.source.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.framgia.toandoan.data.DatabaseHelper;
import com.framgia.toandoan.data.option.model.OptionItem;
import com.framgia.toandoan.data.option.source.OptionDataSource;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by framgia on 05/04/2017.
 */
public class OptionLocalDataSource extends DatabaseHelper
        implements OptionDataSource.LocalDataSource {
    private static OptionLocalDataSource sDataSource;

    public static OptionLocalDataSource getInstance(Context context) {
        if (sDataSource == null) {
            sDataSource = new OptionLocalDataSource(context);
        }
        return sDataSource;
    }

    public OptionLocalDataSource(Context context) {
        super(context);
    }

    @Override
    public Observable<List<OptionItem>> getListOption() {
        return Observable.create(new Observable.OnSubscribe<List<OptionItem>>() {

            @Override
            public void call(Subscriber<? super List<OptionItem>> subscriber) {
                SQLiteDatabase db = getWritableDatabase();
                Cursor cursor =
                        db.query(OptionPersistenceContract.OptionEntry.TABLE_NAME, null, null, null,
                                null, null, null);
                subscriber.onNext(OptionItem.getListOption(cursor));
                subscriber.onCompleted();
            }
        });
    }

    @Override
    public Observable<Boolean> insertData(OptionItem item) {
        return null;
    }
}
