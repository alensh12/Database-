package com.example.alensh.petinfo.Data;

import android.provider.BaseColumns;
import android.widget.Spinner;

/**
 * Created by alensh on 9/18/17.
 */

public class PetContract {

    public PetContract() {
    }

    public final static class PetEntry implements BaseColumns{

        public final static String TABLE_NAME ="pet";

        public final static String _ID =BaseColumns._ID;

        public final static String COLUMN_PET_NAME = "name";

        public final static String COLUMN_PET_BREED ="breed";

        public final static String COLUMN_PET_WEIGHT="weight";

        public final static String COLUMN_PET_GENDER ="gender";


        public final static int GENDER_UNKNOWN = 0;
        public final static int GENDER_MALE= 1;
        public final static int GENDER_FEMALE = 2;

    }
}
