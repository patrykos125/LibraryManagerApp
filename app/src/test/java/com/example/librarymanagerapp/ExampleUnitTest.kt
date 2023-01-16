package com.example.librarymanagerapp

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


class ExampleUnitTest {



    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun postalCodeValidTest() {
        val addReaderActivity= AddReaderActivity()
        val validPostalCode :Boolean = addReaderActivity.validPostalCode("24-320")
        assertTrue(validPostalCode)

    }
    @Test
    fun postalCodeNotValidTest() {
        val addReaderActivity= AddReaderActivity()
        val validPostalCode :Boolean = addReaderActivity.validPostalCode("24320")
        assertFalse(validPostalCode)

    }
    @Test
    fun postalCodeEmptyTest() {
        val addReaderActivity= AddReaderActivity()
        val validPostalCode :Boolean = addReaderActivity.validPostalCode("6")
        assertFalse(validPostalCode)

    }
}