package com.example.librarymanagerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tieButtons()


    }



    private fun tieButtons(){
        //add Reader
           findViewById<Button>(R.id.addReaderButton).setOnClickListener { startActivity(Intent(this,AddReaderActivity::class.java)) }
        //add Book
           findViewById<Button>(R.id.addBookButton).setOnClickListener { startActivity(Intent(this,AddBookActivity::class.java)) }
        //borrow book
           findViewById<Button>(R.id.borrowBookButton).setOnClickListener { startActivity(Intent(this,BorrowBookActivity::class.java)) }
        //return book
        findViewById<Button>(R.id.returnBookButton).setOnClickListener { startActivity(Intent(this,ReturnBookActivity::class.java)) }
        //show Borrowed Books
        findViewById<Button>(R.id.showBorrowedBooksButton).setOnClickListener { startActivity(Intent(this, ShowBorrowedBooksActivity::class.java)) }


    }



}