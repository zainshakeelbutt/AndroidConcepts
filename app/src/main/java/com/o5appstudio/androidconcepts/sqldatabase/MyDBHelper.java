//package com.o5appstudio.androidconcepts.sqldatabase;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//public class MyDBHelper extends SQLiteOpenHelper {
//    private static final String DATABASE_NAME = "ContactsDB";
//    private static final int DATABASE_VERSION = 1;
//    private static final String TABLE_CONTACT = "contacts";
//    private static final String KEY_ID = "id";
//    private static final String KEY_NAME = "name";
//    private static final String KEY_NUMBER = "phone";
//
//    public MyDBHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE " + TABLE_CONTACT +
//                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT," + KEY_NUMBER + " TEXT" + ")"
//        );
//
//        SQLiteDatabase database = this.getWritableDatabase();
//        database.close();
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_CONTACT);
//        onCreate(db);
//    }
//
//    public void addContact(String name, String phone){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(KEY_NAME,name);
//        contentValues.put(KEY_NUMBER,phone);
//        db.insert(TABLE_CONTACT, null,contentValues );
//    }
//
//}
