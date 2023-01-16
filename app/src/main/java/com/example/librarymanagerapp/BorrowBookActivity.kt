package com.example.librarymanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.librarymanagerapp.DAO.AppDatabase
import com.example.librarymanagerapp.Entity.ReadersAndBooks

class BorrowBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrow_book)



        fillField()
        tieButton()
    }
    var bookId :String=""
    var readerId :String=""

    private fun tieButton() {
        findViewById<Button>(R.id.sendKeys).setOnClickListener { getInputForFields() }
    }

    private fun getInputForFields() {

        bookId = findViewById<EditText>(R.id.bookIdEditText).text.toString();
        readerId = findViewById<EditText>(R.id.readerIdEditText).text.toString();

        val bookIdOk = validKeys(bookId);
        val readerIdOk = validKeys(readerId);

        if (bookIdOk && readerIdOk && checkIdBookExistinDatabase() && checkIdReaderExistinDatabase()) {

           var  dataBase = Room.databaseBuilder(
                applicationContext, AppDatabase.AppDataBase::class.java, "libraryDatabase"
            ).allowMainThreadQueries().build()

            dataBase.readersAndBooksDAO().insert(ReadersAndBooks(readerId.toInt(), bookId.toInt()))
            Toast.makeText(this, R.string.borrowBookToast, Toast.LENGTH_SHORT).show()

        } else {
            if (!bookIdOk || !checkIdBookExistinDatabase()) {
                Toast.makeText(this, R.string.invalidBookId, Toast.LENGTH_SHORT).show()
            }
            if (!readerIdOk || !checkIdReaderExistinDatabase()) {

                Toast.makeText(this, R.string.invalidReaderId, Toast.LENGTH_SHORT).show()

            }

        }


    }

    private fun fillField() {

        val dataBase = Room.databaseBuilder(
            applicationContext, AppDatabase.AppDataBase::class.java, "libraryDatabase"
        ).allowMainThreadQueries().build()




        findViewById<TextView>(R.id.availableBooksTextView).text =
            dataBase.bookDAO().getAll().toString();

        findViewById<TextView>(R.id.rejestredReadersTextView).text =
            dataBase.readerDao().getAll().toString()

    }

    private fun validKeys(keyId: String): Boolean {


        return keyId.matches("\\d++".toRegex()) && keyId.toInt() >= 0
    }
    private fun checkIdBookExistinDatabase():Boolean{
       var dataBase = Room.databaseBuilder(
            applicationContext, AppDatabase.AppDataBase::class.java, "libraryDatabase"
        ).allowMainThreadQueries().build()

        return  dataBase.bookDAO().checkIdBookExist(bookId.toInt())>0


    }
    private fun checkIdReaderExistinDatabase():Boolean{
        var dataBase = Room.databaseBuilder(
            applicationContext, AppDatabase.AppDataBase::class.java, "libraryDatabase"
        ).allowMainThreadQueries().build()

        return  dataBase.readerDao().checkIdReaderExist(readerId.toInt())>0


    }
}