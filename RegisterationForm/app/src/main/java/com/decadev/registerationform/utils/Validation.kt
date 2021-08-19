package com.decadev.registerationform.utils

import android.widget.Spinner
import com.decadev.registerationform.model.Users


//method to validate name isn't empty
fun nameValidation(name: String): Boolean {
    return name.isNotEmpty()
}

//method to vali                            date right phone number format is inputted
fun phoneNumberValidation(mobile: String): Boolean {
    var result = false
    if (mobile.startsWith("+234") && mobile.length == 14) result = true
    if (mobile.startsWith("234") && mobile.length == 13) result = true
    if ((mobile.startsWith("070") || mobile.startsWith("080")
                    || mobile.startsWith("081")
                    || mobile.startsWith("090")) && mobile.length == 11) result = true
    return result
}

//method to validate email format is correct
fun emailValid(email: String): Boolean {

  var result = false
    var backText = email.takeLastWhile { it != '@' }
    if (email.contains("@") && backText.contains('.') && email.endsWith("com")) result = true

    return result
}

//method that validates the gender options are selected
fun genderValid(gender: String): Boolean {
    return gender != "Gender"
}

//method that checks all inputs are inputted in the right format and if format is wrong, it returns the wrong format accordingly
fun userValidation(user : Users) : String {
    var result = "success"

    if(!genderValid(user.gender)) result = "select gender"
    if (!emailValid(user.email)) result = "wrong email format"
    if (!phoneNumberValidation(user.mobile)) result = "invalid phone Number format"
    if (!nameValidation(user.name)) result = "name is required"

    return result
}