package com.example.librarymanagerapp.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.librarymanagerapp.Entity.Book
import com.example.librarymanagerapp.Entity.Reader

@Dao
interface ReaderDAO {

    @Query("select * from Reader")
    fun getAll(): List<Reader>

    @Insert
    fun insert(reader: Reader)
    @Insert
    fun insertAll(vararg reader: Reader)
    @Delete
    fun delete(reader: Reader)
    @Query("select count(*) from Reader where readerID=:id")
    fun checkIdReaderExist(id:Int) :Int


}