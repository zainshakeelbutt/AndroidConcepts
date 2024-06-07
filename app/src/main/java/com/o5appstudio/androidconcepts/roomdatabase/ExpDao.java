package com.o5appstudio.androidconcepts.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpDao {

    @Query("Select * From expense")
    List<Expe> getAllExpense();

    @Insert
    void insertData(Expe expense);

    @Update
    void updateData(Expe expense);

    @Delete
    void deleteData(Expe expense);
}
