package com.example.project;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDBHandler<privare> extends SQLiteOpenHelper {
    //defining the schema
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    private static final String TABLE_PRODUCTS = "course";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PRODUCTNAME = "coursecode";
    private static final String COLUMN_PRICE = "coursename";

    private static final String COLUMN_INSTRUCTORNAME = "instructorname";
    private static final String COLUMN_COURSEDAYS = "coursedays";
    private static final String COLUMN_COURSEHOURS = "coursehours";
    private static final String COLUMN_COURSEDESCRIPTION = "coursedescription";
    private static final String COLUMN_STUDENTCAPCITY = "studentcapacity";



    // constructor
    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // create the table
    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE TABLE TABLE_PRODUCTS (COLUMN_ID INTEGER PRIMARY KEY, COLUMN_PRODUCTNAME TEXT,
        // COLUMN_PRICE DOUBLE)
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS
                + "(" + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_PRODUCTNAME + " TEXT,"
                + COLUMN_PRICE + " TEXT,"
                + COLUMN_INSTRUCTORNAME+ " TEXT,"
                + COLUMN_COURSEDAYS+ " TEXT,"
                + COLUMN_COURSEHOURS+ " TEXT,"
                + COLUMN_COURSEDESCRIPTION+ " TEXT,"
                + COLUMN_STUDENTCAPCITY+ " TEXT" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

    }

    public ArrayList<Course> eidtStudentCapcity (String coursename, String coursecode,String instructorname,String StudentCapcity) {
        ArrayList<Course> result = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase q = this.getWritableDatabase();
        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRICE
                + " = \"" + coursename + "\"";
        // passing the query
        String x = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + coursecode + "\"";
        Cursor y = q.rawQuery(x, null);

        Cursor cursor = db.rawQuery(query, null);


        // moves cursor to the first row

        while (cursor.moveToNext()) {
                    if (cursor.getString(1).equals(coursecode)) {
                        if (cursor.getString(3)!=null) {
                            if (cursor.getString(3).equals(instructorname)) {
                                String o = "UPDATE " + TABLE_PRODUCTS
                                        + " SET "
                                        + COLUMN_STUDENTCAPCITY + " = \"" + StudentCapcity + "\""
                                        + " WHERE "
                                        + COLUMN_ID + " = \"" + cursor.getString(0) + "\"";
                                db.execSQL(o);
                            }

                        }
            }
        }

        SQLiteDatabase db2 = this.getWritableDatabase();
        String str = "SELECT * FROM " + TABLE_PRODUCTS;
        Cursor y2 = db2.rawQuery(str, null);
        while (y2.moveToNext()) {
            Course x1=new Course(Integer.valueOf(y2.getString(0)),y2.getString(1),y2.getString(2)
                    ,y2.getString(3),y2.getString(4),y2.getString(5),y2.getString(6),
                    y2.getString(7));
            result.add(x1);
        }
        return result;

    }
    public ArrayList<Course> eidtCourseDescription(String coursename, String coursecode,String instructorname,String description) {
        ArrayList<Course> result = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase q = this.getWritableDatabase();
        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRICE
                + " = \"" + coursename + "\"";
        // passing the query
        String x = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + coursecode + "\"";
        Cursor y = q.rawQuery(x, null);

        Cursor cursor = db.rawQuery(query, null);


        // moves cursor to the first row

        while (cursor.moveToNext()) {
            if(cursor!=null){
                    if (cursor.getString(1).equals(coursecode)) {
                        if (cursor.getString(3)!=null) {
                            if (cursor.getString(3).equals(instructorname)) {
                                String o = "UPDATE " + TABLE_PRODUCTS
                                        + " SET "
                                        + COLUMN_COURSEDESCRIPTION + " = \"" + description + "\""
                                        + " WHERE "
                                        + COLUMN_ID + " = \"" + cursor.getString(0) + "\"";
                                db.execSQL(o);
                            }
                        }

            }
            }
        }
        SQLiteDatabase db2 = this.getWritableDatabase();
        String str = "SELECT * FROM " + TABLE_PRODUCTS;
        Cursor y2 = db2.rawQuery(str, null);
        while (y2.moveToNext()) {
            Course x1=new Course(Integer.valueOf(y2.getString(0)),y2.getString(1),y2.getString(2)
                    ,y2.getString(3),y2.getString(4),y2.getString(5),y2.getString(6),
                    y2.getString(7));
            result.add(x1);
        }
        return result;
    }
    public ArrayList<Course> eidtCourseHour (String coursename, String coursecode,String instructorname,String coursehour) {
        ArrayList<Course> result =new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase q = this.getWritableDatabase();
        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRICE
                + " = \"" + coursename + "\"";
        // passing the query
        String x = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + coursecode + "\"";
        Cursor y = q.rawQuery(x, null);

        Cursor cursor = db.rawQuery(query, null);


        // moves cursor to the first row

        while (cursor.moveToNext()) {
            if(cursor!=null){
                    if (cursor.getString(1).equals(coursecode)) {
                        if (cursor.getString(3)!=null) {
                            if (cursor.getString(3).equals(instructorname)) {
                                String o = "UPDATE " + TABLE_PRODUCTS
                                        + " SET "
                                        + COLUMN_COURSEHOURS + " = \"" + coursehour + "\""
                                        + " WHERE "
                                        + COLUMN_ID + " = \"" + cursor.getString(0) + "\"";
                                db.execSQL(o);
                            }
                        }

            }
            }
        }
        SQLiteDatabase db2 = this.getWritableDatabase();
        String str = "SELECT * FROM " + TABLE_PRODUCTS;
        Cursor y2 = db2.rawQuery(str, null);
        while (y2.moveToNext()) {
            Course x1=new Course(Integer.valueOf(y2.getString(0)),y2.getString(1),y2.getString(2)
                    ,y2.getString(3),y2.getString(4),y2.getString(5),y2.getString(6),
                    y2.getString(7));
            result.add(x1);
        }
        return result;
    }
    public ArrayList<Course> eidtCourseDay (String coursename, String coursecode,String instructorname, String courseday) {
        ArrayList<Course> result =new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase q = this.getWritableDatabase();
        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRICE
                + " = \"" + coursename + "\"";
        // passing the query
        String x = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + coursecode + "\"";
        Cursor y = q.rawQuery(x, null);

        Cursor cursor = db.rawQuery(query, null);


        // moves cursor to the first row

        while (cursor.moveToNext()) {
            if(cursor!=null){
                    if (cursor.getString(1).equals(coursecode)) {
                        if (cursor.getString(3)!=null) {
                            if (cursor.getString(3).equals(instructorname)) {
                                String o = "UPDATE " + TABLE_PRODUCTS
                                        + " SET "
                                        + COLUMN_COURSEDAYS + " = \"" + courseday + "\""
                                        + " WHERE "
                                        + COLUMN_ID + " = \"" + cursor.getString(0) + "\"";
                                db.execSQL(o);

                            }
                        }
                    }}


        }
        SQLiteDatabase db2 = this.getWritableDatabase();
        String str = "SELECT * FROM " + TABLE_PRODUCTS;
        Cursor y2 = db2.rawQuery(str, null);
        while (y2.moveToNext()) {
            Course x1=new Course(Integer.valueOf(y2.getString(0)),y2.getString(1),y2.getString(2)
                    ,y2.getString(3),y2.getString(4),y2.getString(5),y2.getString(6),
                    y2.getString(7));
            result.add(x1);
        }
        return result;

    }
    public ArrayList<Course> unassignCourse(String coursename, String coursecode,String instructorname) {
        ArrayList<Course> result =new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase q = this.getWritableDatabase();
        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRICE
                + " = \"" + coursename + "\"";
        // passing the query
        String x = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + coursecode + "\"";
        Cursor y = q.rawQuery(x, null);

        Cursor cursor = db.rawQuery(query, null);


        // moves cursor to the first row

        while (cursor.moveToNext()) {
            if(cursor!=null){
            if (cursor.getString(1).equals(coursecode)) {
                if (cursor.getString(3)!=null) {
                    if (cursor.getString(3).equals(instructorname)) {
                        String o = "UPDATE " + TABLE_PRODUCTS
                                + " SET "
                                + COLUMN_INSTRUCTORNAME + " = \"" + "" + "\" ,"
                                + COLUMN_COURSEDAYS + " = \"" + "" + "\" ,"
                                + COLUMN_COURSEHOURS + " = \"" + "" + "\" ,"
                                + COLUMN_COURSEDESCRIPTION + " = \"" + "" + "\" ,"
                                + COLUMN_STUDENTCAPCITY + " = \"" + "" + "\""
                                + " WHERE "
                                + COLUMN_ID + " = \"" + cursor.getString(0) + "\"";
                        db.execSQL(o);
                    }

                }

            }}
        }
        SQLiteDatabase db2 = this.getWritableDatabase();
        String str = "SELECT * FROM " + TABLE_PRODUCTS;
        Cursor y2 = db2.rawQuery(str, null);
        while (y2.moveToNext()) {
            Course x1=new Course(Integer.valueOf(y2.getString(0)),y2.getString(1),y2.getString(2)
                    ,y2.getString(3),y2.getString(4),y2.getString(5),y2.getString(6),
                    y2.getString(7));
            result.add(x1);
        }
        return result;

    }

    public ArrayList<Course> assignCourse(String coursename, String coursecode,String instructorname) {
        ArrayList<Course> result =new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase q = this.getWritableDatabase();
        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRICE
                + " = \"" + coursename + "\"";
        // passing the query
        String x = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + coursecode + "\"";
        Cursor y = q.rawQuery(x, null);

        Cursor cursor = db.rawQuery(query, null);


        // moves cursor to the first row

        while (cursor.moveToNext()) {
            if(cursor!=null){
            if (cursor.getString(1).equals(coursecode)) {
                        if (cursor.getString(3)==null) {
                            String o = "UPDATE " + TABLE_PRODUCTS
                                    + " SET " + COLUMN_INSTRUCTORNAME
                                    + " = \"" + instructorname + "\""
                                    + " WHERE " + COLUMN_ID + " = \"" + cursor.getString(0) + "\"";
                            db.execSQL(o);

                        }else{
                            return null;
                        }

                    }}

        }
        SQLiteDatabase db2 = this.getWritableDatabase();
        String str = "SELECT * FROM " + TABLE_PRODUCTS;
        Cursor y2 = db2.rawQuery(str, null);
        while (y2.moveToNext()) {
            Course x1=new Course(Integer.valueOf(y2.getString(0)),y2.getString(1),y2.getString(2)
                    ,y2.getString(3),y2.getString(4),y2.getString(5),y2.getString(6),
                    y2.getString(7));
            result.add(x1);
        }
        return result;
    }
    public ArrayList<Course> findCourse4( String coursecode) {
        ArrayList<Course> result =new ArrayList<>();
        Course x1;

        SQLiteDatabase q = this.getWritableDatabase();
        String x = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + coursecode + "\"";
        Cursor y = q.rawQuery(x, null);


        while (y.moveToNext()) {


            x1 = new Course(Integer.valueOf(y.getString(0)), y.getString(1), y.getString(2)
                    , y.getString(3), y.getString(4), y.getString(5), y.getString(6),
                    y.getString(7));
            result.add(x1);


        }
        return result;
    }
    public ArrayList<Course> findCourse3(String coursename) {
        ArrayList<Course> result =new ArrayList<>();
        Course x1;
        SQLiteDatabase qp = this.getWritableDatabase();
        String query1 = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRICE
                + " = \"" + coursename + "\"";
        Cursor cursor1 = qp.rawQuery(query1, null);


        while (cursor1.moveToNext()) {

            x1 = new Course(Integer.valueOf(cursor1.getString(0)), cursor1.getString(1), cursor1.getString(2)
                    , cursor1.getString(3), cursor1.getString(4), cursor1.getString(5), cursor1.getString(6),
                    cursor1.getString(7));
            result.add(x1);

        }




        return result;}
    public ArrayList<Course> findCourse2(String coursename, String coursecode) {
        ArrayList<Course> result =new ArrayList<>();
        Course x1;
        SQLiteDatabase db = this.getWritableDatabase();

        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRICE
                + " = \"" + coursename + "\"";
        // passing the query

        Cursor cursor = db.rawQuery(query, null);



        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"

        // passing the query


        // moves cursor to the first row
        if(coursename!="" && coursecode!=""){
        while (cursor.moveToNext()) {
            if(cursor!=null){
            if (cursor.getString(1).equals(coursecode)) {
                 x1=new Course(Integer.valueOf(cursor.getString(0)),cursor.getString(1),cursor.getString(2)
                        ,cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),
                        cursor.getString(7));
                result.add(x1);
                return result;
            }}


        }}
        return null;
    }
    public Cursor findCourse(String coursename, String coursecode) {

        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase q = this.getWritableDatabase();
        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRICE
                + " = \"" + coursename + "\"";
        // passing the query
        String x = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + coursecode + "\"";
        Cursor y = q.rawQuery(x, null);

        Cursor cursor = db.rawQuery(query, null);


        // moves cursor to the first row

                while (cursor.moveToNext()) {
                    if (cursor.getString(1).equals(coursecode)) {
                            return cursor;
                    }


        }if(coursename!=null && coursecode==null){
            if (cursor.moveToFirst()) {
            return cursor;
            }
        }else if(coursename==null && coursecode!=null){
            if (y.moveToFirst()) {
                return y;
            }
        }
    return null;
    }
    // deletes old tables and creates a new one
    // change tables by incrementing the database version number
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    // insert into database
    public Cursor addProduct1(Course course) {
        SQLiteDatabase db = this.getWritableDatabase();

        // creating an empty set of values
        ContentValues values = new ContentValues();
        // add values to the set
        values.put(COLUMN_PRODUCTNAME, course.getCourseCode());
        values.put(COLUMN_PRICE, course.getCourseName());

        // insert the set into the products table and close
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
        return viewData();

    }
    public void addProduct(Course course) {
        SQLiteDatabase db = this.getWritableDatabase();

        // creating an empty set of values
        ContentValues values = new ContentValues();
        // add values to the set
        values.put(COLUMN_PRODUCTNAME, course.getCourseCode());
        values.put(COLUMN_PRICE, course.getCourseName());

        // insert the set into the products table and close
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();

    }

    // find a product from database
    public void editProduct(String productname, String coursename) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase q = this.getWritableDatabase();
        // run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + productname + "\"";
        // passing the query
        String x = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRICE
                + " = \"" + coursename + "\"";
        Cursor y = q.rawQuery(x, null);

        Cursor cursor = db.rawQuery(query, null);

        Course product = new Course();

        // moves cursor to the first row
        if (cursor.moveToFirst()) {
            String idStr = cursor.getString(0);
            db.delete(TABLE_PRODUCTS, COLUMN_ID + " = " + idStr, null);

            ContentValues values = new ContentValues();
            values.put(COLUMN_PRODUCTNAME, productname);
            values.put(COLUMN_PRICE, coursename);
            db.insert(TABLE_PRODUCTS, null, values);

        }else if(y.moveToFirst()){

                String p = y.getString(0);
                q.delete(TABLE_PRODUCTS, COLUMN_ID + " = " + p, null);

                ContentValues z = new ContentValues();
                z.put(COLUMN_PRODUCTNAME, productname);
                z.put(COLUMN_PRICE, coursename);
                q.insert(TABLE_PRODUCTS, null, z);}


        db.close();
        q.close();
    }

    // delete from database
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
    public Cursor viewData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS;

        // passing the query
        Cursor cursor = db.rawQuery(query, null);

        // returns all products from table
        return cursor;

    }



}