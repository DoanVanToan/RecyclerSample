package com.framgia.toandoan.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.framgia.toandoan.data.option.source.local.OptionPersistenceContract;

/**
 * Created by framgia on 05/04/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Rxsample.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TEXT_TYPE = " TEXT";
    private static final String BOOLEAN_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String COMMAND_CREATE_DB = "CREATE TABLE "
            + OptionPersistenceContract.OptionEntry.TABLE_NAME
            + " ("
            + OptionPersistenceContract.OptionEntry._ID
            + TEXT_TYPE
            + " PRIMARY KEY,"
            + OptionPersistenceContract.OptionEntry.COLUMN_ENTRY_ID
            + BOOLEAN_TYPE
            + COMMA_SEP
            + OptionPersistenceContract.OptionEntry.COLUMN_TITLE
            + TEXT_TYPE
            + COMMA_SEP
            + OptionPersistenceContract.OptionEntry.COLUMN_URL
            + TEXT_TYPE
            + COMMA_SEP
            + OptionPersistenceContract.OptionEntry.COLUMN_TASK_ID
            + BOOLEAN_TYPE
            + " )";
    private static final String COMMAND_DELTE_TABLE =
            "DROP TABLE IF EXISTS " + OptionPersistenceContract.OptionEntry.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(COMMAND_CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(COMMAND_DELTE_TABLE);
        sqLiteDatabase.execSQL(COMMAND_CREATE_DB);
    }
}
