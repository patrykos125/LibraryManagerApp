package com.example.librarymanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.librarymanagerapp.DAO.AppDatabase
import com.example.librarymanagerapp.Entity.Reader

class AddReaderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_reader)

        tieButton()
    }

    private fun tieButton(){
        findViewById<Button>(R.id.AddReaderToDatabase).setOnClickListener{validDataFromEditTexts()}
    }

    private fun validDataFromEditTexts(){

        val firstName = findViewById<EditText>(R.id.firstNameEditText).text.toString();
        val firstNameOk : Boolean =validNotEmptyOrNotBlank(firstName)
        if(!firstNameOk){
            Toast.makeText(this,R.string.WrongFirstNameToast,Toast.LENGTH_SHORT).show()}


        val lastName = findViewById<EditText>(R.id.lastNameEditText).text.toString()
        val lastNameOk : Boolean =validNotEmptyOrNotBlank(lastName)
        if(!lastNameOk){
            Toast.makeText(this,R.string.WrongLastNameToast,Toast.LENGTH_SHORT).show()}

        val postalCode = findViewById<EditText>(R.id.postalCodeEditText).text.toString()
        val postalCodeOk : Boolean =validPostalCode(postalCode)
        if(!postalCodeOk){
            Toast.makeText(this,R.string.WrongPostalCodeToast,Toast.LENGTH_SHORT).show()}

        val street = findViewById<EditText>(R.id.streetEditText).text.toString()
        val streetOk :Boolean = validNotEmptyOrNotBlank(street)
        if(!streetOk){
            Toast.makeText(this,R.string.WrongStreetToast,Toast.LENGTH_SHORT).show()}

        val phoneNumber = findViewById<EditText>(R.id.phoneNumberEditText).text.toString()
        val phoneNumberOk :Boolean = validPhoneNumber(phoneNumber)
        if(!phoneNumberOk){
            Toast.makeText(this,R.string.WrongPhoneNumberToast,Toast.LENGTH_SHORT).show()}

        if(firstNameOk && lastNameOk && postalCodeOk && streetOk && phoneNumberOk){
            addDataToDatabase(firstName,lastName,postalCode,street,phoneNumber)
            Toast.makeText(this,R.string.ReaderAddToDatabaseToast,Toast.LENGTH_SHORT).show()
        }

    }

    private fun addDataToDatabase(
        firstName: String,
        lastName: String,
        postalCode: String,
        street: String,
        phoneNumber: String
    ) {
        val reader  =Reader(firstName, lastName, postalCode, street, phoneNumber)


        val dataBase = Room.databaseBuilder(applicationContext,
            AppDatabase.AppDataBase::class.java,"libraryDatabase").allowMainThreadQueries()
            .build()

        dataBase.readerDao().insert(reader)
    }

    fun validPostalCode(string: String): Boolean {
         return  string.matches("\\d{2}-\\d{3}".toRegex())

    }

    private fun validNotEmptyOrNotBlank(strToValid:String):Boolean{
        return !(strToValid.isBlank()||strToValid.isEmpty())
    }
    private fun validPhoneNumber(string: String): Boolean {
        return  string.matches("\\d{9}".toRegex())

    }






}