package db;

import android.provider.BaseColumns;

/**
 * Created by kevin on 22/10/2016.
 */

public final class PinActionsContract {

    private PinActionsContract(){}

    public static class PinActionsEntry implements BaseColumns {
        public static final String TABLE_NAME = "PinActions";
        public static final String COLUMN_NAME_PIN = "pin";
        public static final String COLUMN_NAME_ACTION = "action";
    }
}
