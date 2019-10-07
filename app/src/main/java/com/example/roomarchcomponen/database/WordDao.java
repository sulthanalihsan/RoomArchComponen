package com.example.roomarchcomponen.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomarchcomponen.entity.Word;

import java.util.List;

@Dao
public interface WordDao {
    //query
    @Query("SELECT * FROM word_pad ORDER BY word ASC")
    LiveData<List<Word>> getAphabetWord();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_pad")
    void deleteAll();


}
