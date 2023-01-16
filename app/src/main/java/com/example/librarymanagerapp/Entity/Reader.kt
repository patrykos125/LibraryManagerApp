package com.example.librarymanagerapp.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Reader")
data class Reader (
        @ColumnInfo(name = "first_name")
        var firstName :String?,
        @ColumnInfo(name = "last_name")
        var lastName :String?,
        @ColumnInfo(name = "postal_code")
        var postalCode :String?,
        @ColumnInfo(name = "street")
        var street :String?,
        @ColumnInfo(name = "phone_number")
        var phoneNumber :String?,

        ){
        @PrimaryKey(autoGenerate = true)
        var readerID :Int=0
        override fun toString(): String {
                return "readerID= $readerID $firstName $lastName $postalCode $street tel:$phoneNumber\n\n"
        }


}


