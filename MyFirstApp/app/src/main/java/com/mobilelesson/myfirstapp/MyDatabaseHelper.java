package com.mobilelesson.myfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.sql.SQLData;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME = "ToDoList.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "to_do_list";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_JOB = "job";
    private static final String COLUMN_CREATE_TIME = "create_time";
    private static final String COLUMN_CREATER = "creater";


    public MyDatabaseHelper(@Nullable Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME + " ("+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_JOB + " TEXT, " +
                        COLUMN_CREATE_TIME + " TEXT, " +
                        COLUMN_CREATER + " TEXT); ";
      db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
       db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
       onCreate(db);
    }

    public void addJob(String job,String createTime,String creater){
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues cv = new ContentValues();

       cv.put(COLUMN_JOB,job);
       cv.put(COLUMN_CREATE_TIME,createTime);
       cv.put(COLUMN_CREATER,creater);
       long result = db.insert(TABLE_NAME,null, cv);

       if (result == -1){
           Toast.makeText(context, "Ekleme başarısız", Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(context, "Ekleme başarılı", Toast.LENGTH_SHORT).show();
       }

    }

    public Cursor readAllData(){
       String query = "SELECT * FROM "+ TABLE_NAME;
       SQLiteDatabase db =this.getReadableDatabase();

       Cursor cursor = null;

       if (db != null){
           cursor = db.rawQuery(query,null);
       }

       return cursor;
    }

    public void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, " id=?",new String[]{row_id});
        if (result == -1){
            Toast.makeText(context,"Silme işlemi başarısız oldu.",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Silme işlemi başarılı.",Toast.LENGTH_SHORT).show();
        }

    }
}
