package com.example.librarymanagerapp.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.librarymanagerapp.Entity.Book
import com.example.librarymanagerapp.Entity.Reader
import com.example.librarymanagerapp.Entity.ReaderAndBookInfo
import com.example.librarymanagerapp.Entity.ReadersAndBooks


@Dao
interface ReadersAndBooksDAO {
    @Insert
    fun insert(readersAndBooks: ReadersAndBooks)

    @Query("select first_name, last_name,phone_number, title,author from ReadersAndBooks  join Book using(bookID) join Reader using(readerID) ")
    fun showConnection() : List<ReaderAndBookInfo>

    @Query("delete from ReadersAndBooks where bookID =:bookIdToDelete")
    fun deleteByBookId( bookIdToDelete:Int)
    @Query("select count(*) from ReadersAndBooks where bookID=:idKsiazkiDoZwrocenia")
    fun checkIdBookExist(idKsiazkiDoZwrocenia:Int) :Int


}