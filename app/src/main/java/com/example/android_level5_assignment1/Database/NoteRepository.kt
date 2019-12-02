package com.example.android_level5_assignment1.Database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.android_level5_assignment1.Models.Note



class NoteRepository(context: Context) {

    private val noteDao: NoteDao
    init {
        val database = NotepadRoomDatabase.getDatabase(context)
        noteDao = database!!.noteDao()
    }

    fun getNotepad(): LiveData<Note?> {
        return noteDao.getNotepad()
    }

    suspend fun updateNotepad(note: Note) {
        noteDao.updateNote(note)
    }

}


