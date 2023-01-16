package com.example.librarymanagerapp.Entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ReaderWithBook (
    @Embedded val reader: Reader,
    @Relation( parentColumn = "readerID",
        entityColumn = "readerID",
    associateBy = Junction(ReadersAndBooks::class)
    )
    val books :List<Book>


        )
