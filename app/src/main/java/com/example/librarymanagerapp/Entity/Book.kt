package com.example.librarymanagerapp.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Book")
data class Book (
        @ColumnInfo(name = "title")
        var title:String?,
        @ColumnInfo(name = "author")
        var author:String?,
        @ColumnInfo(name = "publish_year")
        var publishYear:String?,
        @ColumnInfo(name = "books_quantity")
        var booksQuantity:Int?,

        ){
        @PrimaryKey(autoGenerate = true)
        var bookID :Int=0
        override fun toString(): String {
                return "bookID=$bookID\n $title\n author=$author\n publishYear=$publishYear\n \n"
        }


}



