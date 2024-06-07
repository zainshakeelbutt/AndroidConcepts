package com.o5appstudio.androidconcepts.androidarchitecture.roomdatabaseapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [RoomContact::class],  exportSchema = false, version = 3)
@TypeConverters(Converters::class)
abstract class ContactDatabase : RoomDatabase(){

    abstract fun contactDao() : ContactDao

    companion object{

        var migration_2_3 = object : Migration(2,3){
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE RoomContact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }

        @Volatile
        private var INSTANCE : ContactDatabase? =null
        fun getDatabase(context:Context): ContactDatabase {
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,ContactDatabase::class.java,"RoomContactDB")
                        .addMigrations(migration_2_3)
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}