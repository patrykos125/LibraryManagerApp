package com.example.librarymanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import com.example.librarymanagerapp.DAO.AppDatabase

class ShowBorrowedBooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_borrowed_books)
     fillTextView();
    }





    private fun fillTextView() {

        val dataBase = Room.databaseBuilder(applicationContext,
            AppDatabase.AppDataBase::class.java,"libraryDatabase").allowMainThreadQueries()
            .build()
        val showConnection = dataBase.readersAndBooksDAO().showConnection()
        findViewById<TextView>(R.id.borrowedBookDisplayerTextView).text=showConnection.toString()
    }
}