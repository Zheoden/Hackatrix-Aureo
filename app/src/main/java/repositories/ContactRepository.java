package repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import db.ContactsDbContract;
import db.DbHelper;
import db.PinActionsContract;
import models.Contact;

/**
 * Created by schif on 22/10/2016.
 */

public class ContactRepository {

    private DbHelper dbHelper;
    public ContactRepository(Context context){
        dbHelper = new DbHelper(context);
    }

    private SQLiteDatabase getDbForRead(){
        return dbHelper.getReadableDatabase();
    }

    private SQLiteDatabase getDbForWrite(){
        return dbHelper.getWritableDatabase();
    }


    public long AddContact(Contact Contact){
        ContentValues values = new ContentValues();
        values.put(ContactsDbContract.ContactsEntry.COLUMN_NAME_NAME, Contact.Name);
        values.put(ContactsDbContract.ContactsEntry.COLUMN_NAME_NUMBER, Contact.Number);
        long newRowId = getDbForWrite().insert(PinActionsContract.PinActionsEntry.TABLE_NAME, null, values);

        return  newRowId;
    }

    public int UpdateContact(Contact Contact){
        ContentValues values = new ContentValues();
        values.put(ContactsDbContract.ContactsEntry.COLUMN_NAME_NAME, Contact.Name);
        String selection = ContactsDbContract.ContactsEntry.COLUMN_NAME_NUMBER + " = ?";
        String[] selectionArgs = {Contact.Number};
        int count = getDbForWrite().update(ContactsDbContract.ContactsEntry.TABLE_NAME, values, selection, selectionArgs);

        return count;
    }

    public List<Contact> GetAllContact(){
        String[] projection = {
                ContactsDbContract.ContactsEntry.COLUMN_NAME_NAME,
                ContactsDbContract.ContactsEntry.COLUMN_NAME_NUMBER
        };
        Cursor cursor = getDbForRead().query(
                ContactsDbContract.ContactsEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        cursor.moveToFirst();
        List<Contact> contacts = new ArrayList<Contact>();
        while(!cursor.isAfterLast()) {
            Contact contact = new Contact();
            contact.Name = cursor.getString(cursor.getColumnIndex(ContactsDbContract.ContactsEntry.COLUMN_NAME_NAME));
            contact.Number = cursor.getString(cursor.getColumnIndex(ContactsDbContract.ContactsEntry.COLUMN_NAME_NUMBER));
            contacts.add(contact);
            cursor.moveToNext();
        }
        return contacts;
    }
}
