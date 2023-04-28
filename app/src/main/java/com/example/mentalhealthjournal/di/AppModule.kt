package com.example.mentalhealthjournal.di

import android.app.Application
import androidx.room.Room
import com.example.mentalhealthjournal.mythoughts.data.data_source.NoteDatabase
import com.example.mentalhealthjournal.mythoughts.data.repository.NoteRepositoryImpl
import com.example.mentalhealthjournal.mythoughts.domain.repository.NoteRepository
import com.example.mentalhealthjournal.mythoughts.domain.use_case.DeleteNote
import com.example.mentalhealthjournal.mythoughts.domain.use_case.GetNotes
import com.example.mentalhealthjournal.mythoughts.domain.use_case.NotesUsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent:: class)
object AppModule {
    @Provides
    @Singleton
    fun  provideNoteDatabase (app: Application): NoteDatabase {

        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }
    @Provides
    @Singleton

    fun provideNoteRepository(db:NoteDatabase):NoteRepository{

        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton

    fun provideNoteUseCases(repository: NoteRepository):NotesUsesCases {

        return NotesUsesCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository)
        )
    }

}