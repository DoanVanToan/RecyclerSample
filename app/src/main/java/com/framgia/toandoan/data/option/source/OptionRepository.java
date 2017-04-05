package com.framgia.toandoan.data.option.source;

import android.content.Context;
import com.framgia.toandoan.data.option.source.local.OptionLocalDataSource;

/**
 * Created by framgia on 05/04/2017.
 */

public class OptionRepository {
    private OptionDataSource.LocalDataSource mLocalDataSource;
    private OptionDataSource.RemoteDataSource mRemoteDataSource;
    private static OptionRepository sRepository;

    public OptionRepository(OptionDataSource.LocalDataSource localDataSource) {
        mLocalDataSource = localDataSource;
    }

    public static OptionRepository getInstance(Context context) {
        if (sRepository == null) {
            sRepository = new OptionRepository(OptionLocalDataSource.getInstance(context));
        }
        return sRepository;
    }
}
