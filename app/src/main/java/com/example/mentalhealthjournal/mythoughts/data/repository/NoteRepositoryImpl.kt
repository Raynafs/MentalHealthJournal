package com.example.mentalhealthjournal.mythoughts.data.repository

import com.example.mentalhealthjournal.mythoughts.data.data_source.NoteDao
import com.example.mentalhealthjournal.mythoughts.domain.model.Note
import com.example.mentalhealthjournal.mythoughts.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao : NoteDao /**This is from Room*/
): NoteRepository{ /**This comes from the domain layer the actual implementation is done here*/
/**Control+I brings all this functions*/

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(Id: Int): Note? {
        return dao.getNoteById(Id)
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }
}