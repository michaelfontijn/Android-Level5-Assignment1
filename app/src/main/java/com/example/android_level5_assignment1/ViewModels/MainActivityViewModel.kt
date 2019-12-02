package com.example.android_level5_assignment1.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.android_level5_assignment1.Database.NoteRepository
import com.example.android_level5_assignment1.Models.Note

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository = NoteRepository(application.applicationContext)

    val note : LiveData<Note?> = noteRepository.getNotepad()
}
