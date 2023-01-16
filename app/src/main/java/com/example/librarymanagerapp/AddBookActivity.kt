package com.example.librarymanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.librarymanagerapp.DAO.AppDatabase
import com.example.librarymanagerapp.Entity.Book
import java.util.*

class AddBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        tieButton()
    }


    private fun validDataFromEditTexts(){

        val title = findViewById<EditText>(R.id.titleEditText).text.toString()
        val titleOk : Boolean =validNotEmptyOrNotBlank(title)
        if(!titleOk){
            Toast.makeText(this,R.string.WrongTitleToast, Toast.LENGTH_SHORT).show()}


        val author = findViewById<EditText>(R.id.AuthorEditText).text.toString()
        val authorOk : Boolean =validNotEmptyOrNotBlank(author)
        if(!authorOk){
            Toast.makeText(this,R.string.WrongAuthorToast, Toast.LENGTH_SHORT).show()}

        val publishYear = findViewById<EditText>(R.id.publishYearEditText).text.toString()
        val publishYearOk : Boolean =validPublishYear(publishYear)
        if(!publishYearOk){
            Toast.makeText(this,R.string.WrongPublishYearToast, Toast.LENGTH_SHORT).show()}

        val bookQuantity = findViewById<EditText>(R.id.booksQuantityEditText).text.toString()
        val bookQuantityOk :Boolean = validBookQuantity(bookQuantity)
        if(!bookQuantityOk){
            Toast.makeText(this,R.string.WrongBookQuantityToast, Toast.LENGTH_SHORT).show()}


        if(titleOk && authorOk && publishYearOk && bookQuantityOk){
            addDataToDatabase(title,author,publishYear,bookQuantity)
            Toast.makeText(this,R.string.BookAddToDatabaseToast, Toast.LENGTH_SHORT).show()}


        }

    private fun addDataToDatabase(
        title: String,
        author: String,
        publishYear: String,
        bookQuantity: String
    ) {
        val book =Book(title,author,publishYear,bookQuantity.toInt())

        val dataBase = Room.databaseBuilder(applicationContext,
            AppDatabase.AppDataBase::class.java,"libraryDatabase").allowMainThreadQueries()
            .build()

        dataBase.bookDAO().insert(book)
    }








     private fun tieButton(){
        findViewById<Button>(R.id.AddBookToDatabaseButton).setOnClickListener{validDataFromEditTexts()}

    }

    private fun validBookQuantity(bookQuantity: String): Boolean {
        return bookQuantity.toInt()>0 && bookQuantity.toInt()<= Calendar.getInstance().get(Calendar.YEAR)

    }

    private fun validPublishYear(publishYear: String): Boolean {
        return publishYear.toInt()>0 && publishYear.toInt()<= Calendar.getInstance().get(Calendar.YEAR)
    }



    private fun validNotEmptyOrNotBlank(strToValid:String):Boolean{
        return !(strToValid.isBlank()||strToValid.isEmpty())
    }
}