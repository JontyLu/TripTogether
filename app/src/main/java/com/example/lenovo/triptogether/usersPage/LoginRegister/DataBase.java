package com.example.lenovo.triptogether.usersPage.LoginRegister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dell on 2016/11/21.
 */
public class DataBase extends SQLiteOpenHelper {
    private static final String DB_NAME = "JOURNEY.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "USERS";

    public DataBase(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String CREATE_TABLE="CREATE TABLE if not exists " +
                TABLE_NAME
                +"(_id PRIMARY KEY,username TEXT,password TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i,int j){}

    public void insert(String username,String password)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }
    public void delete(String username)
    {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = "username=?";
        String[] whereArgs = {username};
        db.delete(TABLE_NAME,whereClause,whereArgs);
        db.close();
    }
    public void update(String username,String password)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        String whereClause = "username=?";
        String[] whereArgs = {username};
        db.update(TABLE_NAME,contentValues,whereClause,whereArgs);
        db.close();
    }
    public boolean queryNameDuplicate(String username)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]
                {"username","password"},"username=?", new String[]{username}, null, null, null);
        cursor.moveToFirst();
        if(cursor.getCount()==0)
        {
            return false;
        }
        else
        {
           return true;
        }
    }
    public Cursor queryResult()
    {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }
    public String queryPasswordByUsername(String username)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]
                {"username","password"},"username=?", new String[]{username}, null, null, null);
        int columnIndex=cursor.getColumnIndex("password");
        System.out.println("columnIndex = " +columnIndex);
        cursor.moveToFirst();
        String password=cursor.getString(cursor.getColumnIndex("password"));
        //String password = cursor.getString(1);
        System.out.println("password = " + password);
        return  password;
    }
}
