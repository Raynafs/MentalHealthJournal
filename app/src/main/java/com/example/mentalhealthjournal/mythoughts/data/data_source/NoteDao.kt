package com.example.mentalhealthjournal.mythoughts.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mentalhealthjournal.mythoughts.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>
    /** Flow emits multiple values sequentially*/

    @Query("SELECT * FROM note WHERE Id= :Id")
    suspend fun getNoteById(Id: Int): Note?
    /**suspend functions can return only a single value*/

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)



}