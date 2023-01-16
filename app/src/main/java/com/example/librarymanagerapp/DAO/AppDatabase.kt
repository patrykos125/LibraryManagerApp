package com.example.librarymanagerapp.DAO

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.librarymanagerapp.Entity.Book
import com.example.librarymanagerapp.Entity.Reader
import com.example.librarymanagerapp.Entity.ReadersAndBooks

abstract class AppDatabase :RoomDatabase(){

    @Database(entities = [Book::class, Reader::class, ReadersAndBooks::class],
        version = 1)
    abstract class AppDataBase : RoomDatabase() {
        abstract fun readerDao() :ReaderDAO
        abstract fun bookDAO(): BookDAO
        abstract fun readersAndBooksDAO():ReadersAndBooksDAO


    }
}