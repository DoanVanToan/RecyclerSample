package com.framgia.toandoan.data.option.source.local;

import android.content.Context;
import com.framgia.toandoan.data.DatabaseHelper;
import com.framgia.toandoan.data.option.model.OptionItem;
import com.framgia.toandoan.data.option.source.OptionDataSource;
import io.reactivex.Observable;
import java.util.List;

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
        return null;
    }

    @Override
    public Observable<Boolean> insertData(OptionItem item) {
        return null;
    }
}
