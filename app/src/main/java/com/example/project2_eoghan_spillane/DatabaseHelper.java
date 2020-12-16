package com.example.project2_eoghan_spillane;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "shopping.db";
    public static final String USER_TABLE = "user_table";
    public static final String PRODUCT_TABLE = "product_table";

    public static final String USER_COL_ID = "ID";
    public static final String USER_COL_USERNAME = "USERNAME";
    public static final String USER_COL_PASSWORD = "PASSWORD";
    public static final String USER_COL_ADDRESS = "ADDRESS";

    public static final String PRODUCT_COL_ITEMCODE = "ITEMCODE";
    public static final String PRODUCT_COL_ITEMNAME = "ITEMNAME";
    public static final String PRODUCT_COL_ITEMPRICE= "ITEMPRICE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + USER_TABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT, ADDRESS TEXT)");
        db.execSQL("create table " + PRODUCT_TABLE + "(ITEMCODE INTEGER PRIMARY KEY AUTOINCREMENT, ITEMNAME TEXT, ITEMPRICE REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_TABLE);
        onCreate(db);
    }

    public boolean newUser(String username, String password, String address){
        SQLiteDatabase db = this.getWritableDatabase();

        //Makes sure the user has filled in all the needed data.
        if(username.equals("") | password.equals("") | address.equals("")){
            return false;
        }

        ContentValues cValues = new ContentValues();
        cValues.put(USER_COL_USERNAME, username);
        cValues.put(USER_COL_PASSWORD, password);
        cValues.put(USER_COL_ADDRESS, address);

        long newRowID = db.insert(USER_TABLE, null, cValues);

        if (newRowID == -1){
            return false;
        } else{
            return true;
        }
    }

    public ArrayList<ArrayList<String>> getUsers(){
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();

        String query = "Select USERNAME, PASSWORD, ADDRESS From " + USER_TABLE;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()){
            ArrayList<String> user = new ArrayList<String>();
            user.add(cursor.getString(cursor.getColumnIndex(USER_COL_USERNAME)));
            user.add(cursor.getString(cursor.getColumnIndex(USER_COL_PASSWORD)));
            user.add(cursor.getString(cursor.getColumnIndex(USER_COL_ADDRESS)));
            outer.add(user);
        }

        return outer;
    }

    public ArrayList<ArrayList<String>> getBasket(){
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();

        String query = "Select ITEMNAME, ITEMPRICE From " + PRODUCT_TABLE;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()){
            ArrayList<String> item = new ArrayList<String>();
            item.add(cursor.getString(cursor.getColumnIndex(PRODUCT_COL_ITEMNAME)));
            item.add(cursor.getString(cursor.getColumnIndex(PRODUCT_COL_ITEMPRICE)));
            outer.add(item);
        }
        return outer;
    }

    //Returns true or false if the password is correct.
    public boolean checkPassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();

        //Checks if the user has inputted nothing in one of the text fields to stop possible errors.
        if(username.equals("") | password.equals("")){
            return false;
        }

        //
        String query = "Select PASSWORD From " + USER_TABLE + " Where USERNAME = '" + username + "'";
        String userPassword = null;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()){
            userPassword = cursor.getString(cursor.getColumnIndex(USER_COL_PASSWORD));
        }

        if(userPassword.equals(password)){
            return true;
        } else {
            return false;
        }

    }
}
