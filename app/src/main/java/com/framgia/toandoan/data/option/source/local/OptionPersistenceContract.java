package com.framgia.toandoan.data.option.source.local;

import android.provider.BaseColumns;

/**
 * Created by framgia on 05/04/2017.
 */
public class OptionPersistenceContract {
    public OptionPersistenceContract() {
    }

    public static abstract class OptionEntry implements
        BaseColumns {
        public static final String TABLE_NAME = "option";
        public static final String COLUMN_ENTRY_ID = "entry_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TASK_ID = "plan_id";
    }
}
