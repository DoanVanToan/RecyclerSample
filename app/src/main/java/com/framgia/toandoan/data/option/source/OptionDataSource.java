package com.framgia.toandoan.data.option.source;

import com.framgia.toandoan.data.option.model.OptionItem;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by framgia on 05/04/2017.
 */
public interface OptionDataSource {
    interface LocalDataSource {
        Observable<List<OptionItem>> getListOption();

        Observable<Boolean> insertData(OptionItem item);
    }

    interface RemoteDataSource {
    }
}
