package com.example.alensh.petinfo.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.alensh.petinfo.Data.PetContract.*;
import static com.example.alensh.petinfo.Data.PetContract.PetEntry.*;

/**
 * Created by alensh on 9/18/17.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    private  static final String DB_NAME="pet.db";
    private  static final int DB_VERSION = 1;

    public PetDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_STATEMENT = "CREATE TABLE "+ PetEntry.TABLE_NAME+
                "("
                + _ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PET_NAME+" TEXT,"
                + COLUMN_PET_BREED+" TEXT,"
                + COLUMN_PET_GENDER+" INTEGER DEFAULT 0,"
                + COLUMN_PET_WEIGHT+" INTEGER NOT NULL"
                +");";

        db.execSQL(SQL_STATEMENT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
