package com.example.librarymanagerapp.Entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

class BookWithReader (
    @Embedded val book: Book,
    @Relation( parentColumn = "bookID",
        entityColumn = "bookID",
        associateBy = Junction(ReadersAndBooks::class)
    )
    val readers :List<Reader>


)


