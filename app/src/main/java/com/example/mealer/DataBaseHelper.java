package com.example.mealer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String LOGIN_INFO = "LOGIN_INFO";
    public static final String EMAIL_ADDRESS = "EMAIL_ADDRESS";
    public static final String PASSWORD = "PASSWORD";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "loginInfo.db", null, 1);
    }

    //this is called when a database will be created... There should be code here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + LOGIN_INFO + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + EMAIL_ADDRESS + " TEXT, " + PASSWORD + " TEXT)";
        db.execSQL(createTableStatement);

    }
    // this is called if the database version number changes.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne (ClientInfo clientInfo) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(EMAIL_ADDRESS, clientInfo.getEmailAddressField());
        cv.put(PASSWORD, clientInfo.getPasswordField());
        // we need something like cv.put (isCook) Bool

        long insert = db.insert(LOGIN_INFO, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }

    }
}
