package com.example.seg2105_project_gr13;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHandler extends SQLiteOpenHelper{

    //Users Table
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "school_app.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    //Courses Table
    private static final String COURSE_TABLE = "courses";
    private static final String COURSE_ID = "_id";
    private static final String COURSE_NAME = "name";
    private static final String COURSE_CODE = "code";


    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY," + COLUMN_USERNAME + " TEXT," + COLUMN_PASSWORD +
                " TEXT" + ")";
        String CREATE_COURSES_TABLE = "CREATE TABLE " + COURSE_TABLE + "(" + COURSE_ID +
                " INTEGER PRIMARY KEY," + COURSE_NAME + " TEXT," + COURSE_CODE +
                " TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_COURSES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + COURSE_TABLE);
        onCreate(db);
    }

    //Course Table Actions
    //Add Course
    public void addCourse(Course course){
        SQLiteDatabase db = this.getWritableDatabase();

        //value map
        ContentValues values = new ContentValues();
        values.put(COURSE_NAME, course.getName());
        values.put(COURSE_CODE, course.getCode());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    //Course Lookup
    public Course findCourse(String coursecode){
        SQLiteDatabase db = this.getWritableDatabase();

        String findQuery = "SELECT * FROM " + COURSE_TABLE + " WHERE " + COURSE_CODE +
                " = \"" + coursecode + "\"";
        Cursor cursor = db.rawQuery(findQuery, null);

        Course course = new Course();
        if(cursor.moveToFirst()){
            course.setID(Integer.parseInt(cursor.getString(0)));
            course.setName(cursor.getString(1));
            course.setCode(cursor.getString(2));
            cursor.close();
        }else{
            course = null;
        }
        db.close();
        return course;
    }

    public boolean deleteCourse(String coursecode){
        boolean result = false;
        SQLiteDatabase db = this.getWritableDatabase();

        //Select Course to Del
        String findQuery = "SELECT * FROM " + COURSE_TABLE + " WHERE " + COURSE_CODE +
                " = \"" + coursecode + "\"";
        Cursor cursor = db.rawQuery(findQuery, null);
        if(cursor.moveToFirst()){
            String idStr = cursor.getString(0);
            db.delete(COURSE_TABLE,COURSE_ID + " = " + idStr, null);
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    //User Registration Actions
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
