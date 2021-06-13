package com.example.seg2105_project_gr13;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "school_app.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_ROLE = "role";

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY," + COLUMN_USERNAME + " TEXT," + COLUMN_PASSWORD +
                " TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean registerUser(User user){
        //Register User
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        //value map
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPassword());

        //insert values
        long queryResult = db.insert(TABLE_NAME, null, values);
        if(queryResult == -1)
            return false;
        else
            return true;
    }

    public boolean checkUser(User user){
        //Check if User exists in database with given info
        SQLiteDatabase db = this.getWritableDatabase();

        String checkQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                COLUMN_USERNAME + " = \"" + user.getUsername() + "\"";
        Cursor cursor = db.rawQuery(checkQuery, null);
        int count = cursor.getCount();
        db.close();
        cursor.close();

        if (count > 0)
            return true;
        else
            return false;

    }
}
