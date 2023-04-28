package com.example.mentalhealthjournal.mythoughts.domain.utils

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
