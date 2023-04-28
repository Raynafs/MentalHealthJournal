package com.example.mentalhealthjournal.mythoughts.domain.use_case

import com.example.mentalhealthjournal.mythoughts.domain.model.Note
import com.example.mentalhealthjournal.mythoughts.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke (note: Note){
        repository.deleteNote(note)
    }

}