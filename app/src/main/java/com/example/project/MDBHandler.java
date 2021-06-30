package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PeopleDB.db";
    private static final String TABLE_PRODUCTS = "People";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_PRODUCTNAME = "username";
    private static final String COLUMN_PRICE = "password";
    private static final String COLUMN_TEACHERORSTUDENT = "teacherorstudent";
    private static final String COLUMN_NAME = "name";
    private static String p;


    // constructor
    public MDBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    // create the table
    @Override
    public void onCreate(SQLiteDatabase db){
        // CREATE TABLE TABLE_PRODUCTS (COLUMN_ID INTEGER PRIMARY KEY, COLUMN_PRODUCTNAME TEXT,
        // COLUMN_PRICE DOUBLE)
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS
                + "(" + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_PRODUCTNAME + " TEXT,"
                + COLUMN_PRICE + " TEXT,"
                + COLUMN_TEACHERORSTUDENT+ " TEXT," +
                COLUMN_NAME +" TEXT"+")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

    }

    // deletes old tables and creates a new one
    // change tables by incrementing the database version number
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    // insert into database
    public void addProduct(People people){
        SQLiteDatabase db = this.getWritableDatabase();

        // creating an empty set of values
        ContentValues values = new ContentValues();
        // add values to the set
        values.put(COLUMN_PRODUCTNAME, people.getUserName());
        values.put(COLUMN_PRICE, people.getPassWord());
        values.put(COLUMN_TEACHERORSTUDENT, people.getTeacherOrStudent());
        values.put(COLUMN_NAME, people.getName());

        // insert the set into the products table and close
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    // find a product from database
    public boolean findProduct(String username){
        SQLiteDatabase db = this.getWritableDatabase();

        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + username + "\"";
        // passing the query
        Cursor cursor = db.rawQuery(query, null);


        // moves cursor to the first row
        if(cursor.moveToFirst()){
            cursor.close();
            db.close();
            return false;
        }else{
            cursor.close();
            db.close();
            return true;

        }
    }
    public boolean deleteProduct(String productname) {
        boolean result = false;
        SQLiteDatabase db = this.getWritableDatabase();

        // run a query to find the product with the specified name, then delete
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = productname
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + productname + "\"";

        // passing the query
        Cursor cursor = db.rawQuery(query, null);

        // moves cursor to the first row
        // this deletes the first occurrence of the product with the specified name
        if (cursor.moveToFirst()) {
            String idStr = cursor.getString(0);
            db.delete(TABLE_PRODUCTS, COLUMN_ID + " = " + idStr, null);
            cursor.close();
            result = true;
        }
        db.close();

        // if product is deleted this returns true
        return result;
    }


    // read all from table
    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS;

        // passing the query
        Cursor cursor = db.rawQuery(query, null);

        // returns all products from table
        return cursor;
    }
    public int validate(String productname, String password) {
        int x = 0;
        SQLiteDatabase m = this.getWritableDatabase();

        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + productname + "\"";
        // passing the query
        Cursor cursor = m.rawQuery(query, null);


        // moves cursor to the first row
         if (cursor.moveToFirst()) {
            if (cursor.getString(2).equals(password)) {
                if (cursor.getString(3).equals("instructor")) {
                    x = 2;
                    p=cursor.getString(4);
                } else if (cursor.getString(3).equals("student")) {
                    x = 3;
                    p=cursor.getString(4);
                }
            }

        }
        return x;
    }
    public String find(String productname, String password) {
        SQLiteDatabase m = this.getWritableDatabase();

        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + productname + "\"";
        // passing the query
        Cursor cursor = m.rawQuery(query, null);


        // moves cursor to the first row
        cursor.moveToFirst();
        return cursor.getString(3).toLowerCase();

        }
    public String find2(String productname, String password) {
        SQLiteDatabase m = this.getWritableDatabase();

        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + productname + "\"";
        // passing the query
        Cursor cursor = m.rawQuery(query, null);


        // moves cursor to the first row
        cursor.moveToFirst();
        return cursor.getString(4).toLowerCase();

    }

    public static void setP(String p) {
        MDBHandler.p = p;
    }

    public static String getP(){
        return p;
    }
    }


