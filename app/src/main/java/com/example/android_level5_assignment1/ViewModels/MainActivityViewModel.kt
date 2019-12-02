package com.example.android_level5_assignment1.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.android_level5_assignment1.Database.NoteRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository = NoteRepository(application.applicationContext)

    val note = noteRepository.getNotepad()
}
