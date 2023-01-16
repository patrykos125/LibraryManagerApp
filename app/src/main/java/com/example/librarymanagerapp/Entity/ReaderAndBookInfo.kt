package com.example.librarymanagerapp.Entity

data class ReaderAndBookInfo (
   var first_name:String,
  var  last_name:String,
   var phone_number :String,
   var  title:String,
   var  author : String
        ){
    override fun toString(): String {
        return "$first_name $last_name tel:$phone_number $title author= $author\n\n"
    }
}
