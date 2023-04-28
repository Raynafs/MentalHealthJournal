package com.example.mentalhealthjournal.mythoughts.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mentalhealthjournal.ui.theme.*

/** Just like a table */
@Entity
data class Note(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: String,
    val color: Int
) {
    companion object{

        val noteColors = listOf(RedOrange, LightBlue, LightGreen, Violet, RedPink)

    }
}
