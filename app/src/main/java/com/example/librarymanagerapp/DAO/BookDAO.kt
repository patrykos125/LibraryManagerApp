package com.example.librarymanagerapp.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.librarymanagerapp.Entity.Book

@Dao
interface BookDAO {
    @Query("select * from Book")
    fun getAll(): List<Book>

    @Insert
    fun insert(book: Book)

    @Insert
    fun insertAll(vararg book: Book)

    @Delete
    fun delete(book: Book)

    @Query("select count(*) from Book where bookID=:id")
    fun checkIdBookExist(id:Int) :Int




}