package com.example.walterorando.yrproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.DatabaseUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.walterorando.yrproject.models.HomeItems;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by Walter Orando on 4/18/2016.
 */
public class LoginDataBaseAdapter
{
    static final String DATABASE_NAME = "login.db";
    // Login table name
    public static final String TABLE_USER = "LOGIN";

    static final int DATABASE_VERSION = 2;
    private static final String KEY_ID = "ID";
    private static final String KEY_NAME = "USERNAME";
    private static final String KEY_PASSWORD = "PASSWORD";
    private static final String KEY_FULLNAMES = "FULLNAMES";
    private static final String KEY_DP ="DISPLAYPHOTO";
    private static final String KEY_EMAIL = "EMAIL";
    public static final int NAME_COLUMN = 1;
    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_USER + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT NOT NULL,"
            + KEY_PASSWORD + " TEXT NOT NULL,"
            + KEY_FULLNAMES + " TEXT NOT NULL,"
            + KEY_EMAIL + " TEXT NOT NULL"
           /*+ KEY_DP + " TEXT NOT NULL"*/+ ")";
    // Variable to hold the database instance
    public SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    public DataBaseHelper dbHelper;
    public  LoginDataBaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  LoginDataBaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();

        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String Username,String Password,String Fullnames,String Email)
    {
       HomeItems image = new HomeItems();
        String dp = image.getPath();

        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", Username);
        newValues.put("PASSWORD",Password);
        newValues.put("FULLNAMES",Fullnames);
        newValues.put("EMAIL",Email);
       // newValues.put("DISPLAYPHOTO",dp);

        // Insert the row into your table
        db.insert("LOGIN", null, newValues);
        db.close();
        Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public int deleteEntry(String Username)
    {
        //String id=String.valueOf(ID);
        String where="USERNAME=?";
        int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{Username}) ;
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }
    public String getSingleEntry(String Username)
    {
        String Password = new String();
        Cursor cursor=db.query("LOGIN", null, "USERNAME=?", new String[]{Username}, null, null, null);
        if(cursor.getCount() < 1) // Username Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }else if(cursor.moveToFirst()) {
            do {
                Password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
            }while(cursor.moveToNext());

        }if (!cursor.isClosed()) { cursor.close();}
return Password;
    }
    public void  updateEntry(String Username,String Password, String Fullnames,String Email)
    {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("USERNAME", Username);
        updatedValues.put("PASSWORD",Password);
        updatedValues.put("FULLNAMES",Fullnames);
        updatedValues.put("EMAIL",Email);
       // updatedValues.put("DISPLAYPHOTO",dp);

        String where="USERNAME = ?";
        db.update("LOGIN",updatedValues, where, new String[]{Username});
    }
    public HashMap<String, String> getUserDetails(){
        HashMap<String,String> user = new HashMap<String, String>();
        String selectQuery = "select * from LOGIN";
    db = dbHelper.getReadableDatabase();
     Cursor cursor = db.rawQuery("select * from LOGIN",null);
        cursor.moveToFirst();
        if(cursor.getCount() < 1) // No data Exist
        {
            cursor.close();
           return user;
        }else if(cursor.moveToFirst()) {
            do {
                user.put("USERNAME",cursor.getString(1));
                user.put("PASSWORD",cursor.getString(2));
                user.put("FULLNAMES",cursor.getString(3));
                user.put("EMAIL",cursor.getString(4));
           //   user.put("DISPLAYPHOTO", cursor.getString(5));
               String details = cursor.getString(cursor.getColumnIndex("USERNAME"));
            }while(cursor.moveToNext());

        }if (!cursor.isClosed()) { cursor.close();}

        return user;
    }

    private HomeItems cursorToMyImage(Cursor cursor) {
        HomeItems image = new HomeItems();
        image.setPath(
                cursor.getString(cursor.getColumnIndex(KEY_DP)));
        image.setTitle(
                cursor.getString(cursor.getColumnIndex(KEY_NAME)));

        return image;
    }
}
