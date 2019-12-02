package com.example.android_level5_assignment1.Database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android_level5_assignment1.Models.Note

    @Dao
    interface NoteDao {

        @Insert
        suspend fun insertNote(note: Note)

        @Query("SELECT * FROM noteTable LIMIT 1")
        fun getNotepad(): LiveData<Note?>

        @Update
        suspend fun updateNote(note: Note)
    }

