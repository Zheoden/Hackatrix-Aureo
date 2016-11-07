package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import constants.Actions;

/**
 * Created by kevin on 22/10/2016.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "NumApp.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_PINACTIONS =
            "CREATE TABLE " + PinActionsContract.PinActionsEntry.TABLE_NAME + " (" +
                    PinActionsContract.PinActionsEntry._ID + " INTEGER PRIMARY KEY," +
                    PinActionsContract.PinActionsEntry.COLUMN_NAME_PIN + TEXT_TYPE + COMMA_SEP +
                    PinActionsContract.PinActionsEntry.COLUMN_NAME_ACTION + TEXT_TYPE + " )";
    private static final String SQL_CREATE_CONTACT = "CREATE TABLE " + ContactsDbContract.ContactsEntry.TABLE_NAME + " (" +
            ContactsDbContract.ContactsEntry._ID + " INTEGER PRIMARY KEY," +
            ContactsDbContract.ContactsEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
            ContactsDbContract.ContactsEntry.COLUMN_NAME_NUMBER + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PinActionsContract.PinActionsEntry.TABLE_NAME;

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PINACTIONS);
        db.execSQL(SQL_CREATE_CONTACT);
        ContentValues values = new ContentValues();
        values.put(PinActionsContract.PinActionsEntry.COLUMN_NAME_ACTION, Actions.UNLOCK);
        values.put(PinActionsContract.PinActionsEntry.COLUMN_NAME_PIN, "1234");
        db.insert(PinActionsContract.PinActionsEntry.TABLE_NAME, null, values);
        values.put(PinActionsContract.PinActionsEntry.COLUMN_NAME_ACTION, Actions.CALL_POLICE);
        values.put(PinActionsContract.PinActionsEntry.COLUMN_NAME_PIN, "1");
        db.insert(PinActionsContract.PinActionsEntry.TABLE_NAME, null, values);
        values.put(PinActionsContract.PinActionsEntry.COLUMN_NAME_ACTION, Actions.CALL_GENDER_VIOLENCE);
        values.put(PinActionsContract.PinActionsEntry.COLUMN_NAME_PIN, "2");
        db.insert(PinActionsContract.PinActionsEntry.TABLE_NAME, null, values);
        values.put(PinActionsContract.PinActionsEntry.COLUMN_NAME_ACTION, Actions.CALL_AMBULANCE);
        values.put(PinActionsContract.PinActionsEntry.COLUMN_NAME_PIN, "3");
        db.insert(PinActionsContract.PinActionsEntry.TABLE_NAME, null, values);
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
