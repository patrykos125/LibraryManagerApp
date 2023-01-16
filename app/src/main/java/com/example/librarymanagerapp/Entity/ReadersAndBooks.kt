package com.example.librarymanagerapp.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ReadersAndBooks" )
data class ReadersAndBooks (
    @ColumnInfo
    var readerID : Int,
    @ColumnInfo
    var bookID : Int,

){
    @PrimaryKey(autoGenerate = true)
var connectionID : Int=0;

}

