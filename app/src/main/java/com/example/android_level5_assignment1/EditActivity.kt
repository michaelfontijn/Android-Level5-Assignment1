package com.example.android_level5_assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android_level5_assignment1.ViewModels.EditViewModel
import kotlinx.android.synthetic.main.activity_edit.*
import java.util.*

class EditActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NOTE = "EXTRA_NOTE"
    }

    private lateinit var editViewModel: EditViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        fabSave.setOnClickListener {
            editViewModel.note.value?.apply {
                title = etTitle.text.toString()
                lastUpdated = Date()
                text = etNote.text.toString()
            }

            editViewModel.updateNote()
        }
    }


    private fun initViewModel() {
        editViewModel = ViewModelProviders.of(this).get(EditViewModel::class.java)
        editViewModel.note.value = intent.extras?.getParcelable(EXTRA_NOTE)!!

        editViewModel.note.observe(this, Observer { note ->
            if (note != null) {
                etTitle.setText(note.title)
                etNote.setText(note.text)
            }
        })

        editViewModel.error.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        editViewModel.success.observe(this, Observer { success ->
            if (success) finish()
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> { // Used to identify when the user has clicked the back button
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
