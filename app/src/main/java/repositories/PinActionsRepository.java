package repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import db.DbHelper;
import db.PinActionsContract;
import db.PinActionsContract.PinActionsEntry;
import models.PinAction;


/**
 * Created by kevin on 22/10/2016.
 */

public class PinActionsRepository {
    private DbHelper dbHelper;
    public PinActionsRepository(Context context){
        dbHelper = new DbHelper(context);
    }

    private SQLiteDatabase getDbForRead(){
        return dbHelper.getReadableDatabase();
    }

    private SQLiteDatabase getDbForWrite(){
        return dbHelper.getWritableDatabase();
    }

    public long AddPinAction(PinAction pinAction){
        ContentValues values = new ContentValues();
        values.put(PinActionsEntry.COLUMN_NAME_ACTION, pinAction.Action);
        values.put(PinActionsEntry.COLUMN_NAME_PIN, pinAction.Pin);
        long newRowId = getDbForWrite().insert(PinActionsContract.PinActionsEntry.TABLE_NAME, null, values);

        return newRowId;
    }

    public int UpdatePinAction(PinAction pinAction){
        ContentValues values = new ContentValues();
        values.put(PinActionsEntry.COLUMN_NAME_PIN, pinAction.Pin);
        String selection = PinActionsEntry.COLUMN_NAME_ACTION + " = ?";
        String[] selectionArgs = {pinAction.Action};
        int count = getDbForWrite().update(PinActionsEntry.TABLE_NAME, values, selection, selectionArgs);
        return count;
    }

    public PinAction GetPinActionByAction(String action){
        String[] projection = {
                PinActionsEntry.COLUMN_NAME_PIN,
                PinActionsEntry.COLUMN_NAME_ACTION
        };
        String selection = PinActionsEntry.COLUMN_NAME_ACTION + " = ?";
        String[] selectionArgs = {action};
        Cursor cursor = getDbForRead().query(
                PinActionsEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        if(cursor.moveToFirst()) {
            PinAction pinAction = new PinAction();
            pinAction.Action = cursor.getString(cursor.getColumnIndex(PinActionsEntry.COLUMN_NAME_ACTION));
            pinAction.Pin = cursor.getString(cursor.getColumnIndex(PinActionsEntry.COLUMN_NAME_PIN));
            return pinAction;
        }
        else {
            return null;
        }
    }

    public PinAction GetPinActionByPin(String pin){
        String[] projection = {
                PinActionsEntry.COLUMN_NAME_PIN,
                PinActionsEntry.COLUMN_NAME_ACTION
        };
        String selection = PinActionsEntry.COLUMN_NAME_PIN + " = ?";
        String[] selectionArgs = {pin};
        Cursor cursor = getDbForRead().query(
                PinActionsEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        if(cursor.moveToFirst()) {
            PinAction pinAction = new PinAction();
            pinAction.Action = cursor.getString(cursor.getColumnIndex(PinActionsEntry.COLUMN_NAME_ACTION));
            pinAction.Pin = cursor.getString(cursor.getColumnIndex(PinActionsEntry.COLUMN_NAME_PIN));
            return pinAction;
        }
        else{
            return null;
        }
    }
}
