package db;

import android.provider.BaseColumns;

/**
 * Created by schif on 22/10/2016.
 */

public class ContactsDbContract {

    private ContactsDbContract(){}

    public static class ContactsEntry implements BaseColumns {
        public static final String TABLE_NAME = "Contacts";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_NUMBER = "number";
    }

}
