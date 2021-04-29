package com.decadev.registerationform.utils

import org.junit.Assert.*
import org.junit.Test

class ValidationKtTest {

    var nameTest1 = "kunle"
    var nameTest2 = ""
    var mobileTest1 = "2349022320123"
    var phoneNumberStartsWith080 = "08022320123"
    var mobileTest3 = ""
    var mobileTest4 = "+23409022320123"
    var mobileTest5 = "+2348022323123"
    var mobileTest6 = "07032334553"
    var emailTest1 = "ezekielolufemi09@yahoo.com"
    var genderTest1 = "Male"
    var genderTest2 = "Female"
    var genderTest3 = "Don\'t want to disclose"
    var genderTest4 = "Gender"


    @Test
    fun userName_validation_test() {
        assertEquals(true, nameValidation(nameTest1))
        assertEquals(false, nameValidation(nameTest2))
    }


    @Test
    fun phoneNumber_validation_test() {
        assertEquals(true, phoneNumberValidation(mobileTest1))
        assertEquals(false, phoneNumberValidation(mobileTest3))
        assertEquals(false, phoneNumberValidation(mobileTest4))
        assertEquals(true, phoneNumberValidation(mobileTest5))
        assertEquals(true, phoneNumberValidation(mobileTest6))
    }

    @Test
    fun phone_number_starts_with_080_return_true() {
        assertEquals(true, phoneNumberValidation(phoneNumberStartsWith080))
    }



    @Test
    fun email_validation_test() {
        assertEquals(true, emailValid(emailTest1))

    }

    @Test
    fun gender_validation_test() {
        assertEquals(true, genderValid(genderTest1))
        assertEquals(true, genderValid(genderTest2))
        assertEquals(true, genderValid(genderTest3))
        assertEquals(false, genderValid(genderTest4))
    }
}