package com.o5appstudio.androidconcepts.sqldatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = ("CREATE TABLE $TABLE_CONTACT ("
                + "$KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$KEY_NAME TEXT, "
                + "$KEY_NUMBER TEXT)")
        db.execSQL(createTableQuery)

//        db.execSQL(
//            "CREATE TABLE " + TABLE_CONTACT +
//                    "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT," + KEY_NUMBER + " TEXT" + ")"
//        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACT")
        onCreate(db)
    }

    fun addContact(name: String?, phone: String?) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_NAME, name)
        contentValues.put(KEY_NUMBER, phone)
        db.insert(TABLE_CONTACT, null, contentValues)
    }
    fun fetchContacts() : ArrayList<ContactModel> {
        val db = this.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_CONTACT", null)
        var arrContacts = ArrayList<ContactModel>()
        while (cursor.moveToNext()){
            val model = ContactModel()
            model.id = cursor.getInt(0)
            model.name = cursor.getString(1)
            model.phone = cursor.getString(2)
            arrContacts.add(model)
        }
        return arrContacts
    }

    fun updateContact(contactModel: ContactModel){

        val database = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(KEY_NUMBER,contactModel.phone)

        database.update(TABLE_CONTACT,contentValues, KEY_ID +" = "+contactModel.id, null)

    }

    fun deleteContact(id:Int) : Boolean{
        val database = this.writableDatabase
        val result = database.delete(TABLE_CONTACT, "$KEY_ID=?", arrayOf(id.toString()))
        return result > 0
    }



    companion object {
        private const val DATABASE_NAME = "ContactsDB"
        private const val DATABASE_VERSION = 1
        private const val TABLE_CONTACT = "contacts"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_NUMBER = "phone"
    }
}