package com.latihan.android.cfreelance_2nd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class UserDatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME = "CFreelance_Data.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "user";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";


    public UserDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PASSWORD + " TEXT);";
        // CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, email TEXT, password TEXT;

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void createUser(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USERNAME, username);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Failed to Register!", Toast.LENGTH_SHORT).show();;
        } else {
            Toast.makeText(context, "Your account has been registered!", Toast.LENGTH_SHORT).show();
        }
    }
}
