package com.example.librarymanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.librarymanagerapp.DAO.AppDatabase

class ReturnBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_return_book)
        tieButton()
        schowBooks()
    }

    private fun schowBooks() {
        val dataBase = Room.databaseBuilder(applicationContext,
            AppDatabase.AppDataBase::class.java,"libraryDatabase").allowMainThreadQueries()
            .build()

        findViewById<TextView>(R.id.showBooksInReturnBookActivity).text=
            dataBase.bookDAO().getAll().toString()


    }

    private fun tieButton() {
        findViewById<Button>(R.id.returnBookButtonInActivity).setOnClickListener{returnBookInDatabase()
        }




    }

    private fun returnBookInDatabase(){
        val bookIdToReturn = findViewById<EditText>(R.id.idBookToReturn).text.toString()
        val bookIdToReturnOk=validIdBook(bookIdToReturn);

        val dataBase = Room.databaseBuilder(applicationContext,
            AppDatabase.AppDataBase::class.java,"libraryDatabase").allowMainThreadQueries()
            .build()

        if(bookIdToReturnOk && dataBase.readersAndBooksDAO().checkIdBookExist(bookIdToReturn.toInt())>0){
            dataBase.readersAndBooksDAO().deleteByBookId(bookIdToReturn.toInt())
            Toast.makeText(this,R.string.returnBookToastInReturnActivity,Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,R.string.invalidBookId, Toast.LENGTH_SHORT).show()

        }



    }
    private fun validIdBook(bookIdToReturn: String):Boolean {
        return bookIdToReturn.matches("\\d++".toRegex()) && bookIdToReturn.toInt() >= 0
    }


}