package com.texas.texasmobileapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TexasDAO {
    DbHelper dbHelper;

    public TexasDAO (Context context){
        dbHelper = new DbHelper(context);
    }

    ///CREATE
    public long insertData (String name, String course){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.COL_NAME, name);
        contentValues.put(DbHelper.COL_COURSE, course);
        return db.insert(DbHelper.TABLE_NAME, null, contentValues);
    }

    //READ
    public ArrayList<String> getAllData(){
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + DbHelper.TABLE_NAME, null);

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String course = cursor.getString(2);

            list.add("ID: " + id + "/" + "NAME: " + name + "/" + "COURSE: " + course);
        }
        cursor.close();
        return list;
    }

    //UPDATE
    public int updateData(int id, String name, String course){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.COL_NAME, name);
        contentValues.put(DbHelper.COL_COURSE, course);

        return db.update(
                DbHelper.TABLE_NAME,
                contentValues,
                DbHelper.COL_ID + "=?",
                new String[]{String.valueOf(id)}
        );
    }

    //DELETE
    public int deleteData(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        return db.delete(
                DbHelper.TABLE_NAME,
                DbHelper.COL_ID + "=?",
                new String[]{String.valueOf(id)}
        );
    }
}
