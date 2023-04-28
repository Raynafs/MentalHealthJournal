package com.example.mentalhealthjournal.mythoughts.domain.repository

import com.example.mentalhealthjournal.mythoughts.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(Id: Int): Note?

    suspend fun insertNote(note:Note)

    suspend fun deleteNote (note:Note)
}