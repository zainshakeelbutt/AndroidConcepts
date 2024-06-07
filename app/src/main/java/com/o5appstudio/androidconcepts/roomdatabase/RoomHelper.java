package com.o5appstudio.androidconcepts.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Expe.class, exportSchema = false, version = 1)
public abstract class RoomHelper extends RoomDatabase {
    private static  final  String  DB_NAME = "expenseDB";
    private static RoomHelper instance;

    public static synchronized RoomHelper getDb(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, RoomHelper.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return  instance;
    }

    public abstract ExpDao expenseDao();

}
