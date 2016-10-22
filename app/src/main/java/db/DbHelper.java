package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kevin on 22/10/2016.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "NumApp.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PinActionsContract.PinActionsEntry.TABLE_NAME + " (" +
                    PinActionsContract.PinActionsEntry._ID + " INTEGER PRIMARY KEY," +
                    PinActionsContract.PinActionsEntry.COLUMN_NAME_PIN + " INTEGER" + COMMA_SEP +
                    PinActionsContract.PinActionsEntry.COLUMN_NAME_ACTION + TEXT_TYPE + " );";
                    /*+
                    "CREATE INDEX " + PinActionsContract.PinActionsEntry.TABLE_NAME + "_" +
                    PinActionsContract.PinActionsEntry.COLUMN_NAME_PIN + "_idx ON " +
                    PinActionsContract.PinActionsEntry.TABLE_NAME;
*/
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PinActionsContract.PinActionsEntry.TABLE_NAME;

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
