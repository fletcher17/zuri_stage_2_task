package com.decadev.registerationform

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.decadev.registerationform.model.Users
import com.decadev.registerationform.utils.userValidation
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var userName: TextView
    lateinit var phoneNumber: TextView
    lateinit var email1 : TextView
    lateinit var gender : Spinner
    lateinit var button : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // The various views in the activity
        userName = findViewById(R.id.name_form)
        phoneNumber = findViewById(R.id.phoneno_textView1)
        email1 = findViewById(R.id.email_textView1)
        gender = findViewById(R.id.gender_textView)
        button = findViewById(R.id.submit_button)



// When button is clicked, all information inputted would be submitted
        button.setOnClickListener {

            val name = userName.text.toString()
            val phoneNo = phoneNumber.text.toString()
            val emailAddress = email1.text.toString()
            val sex = gender.selectedItem.toString()

            var newUser = Users(name,phoneNo,emailAddress,sex)

            // uservalidation is checked for each input and if correct, intent gets activated else snackbar shows informing of the wrong input format.
            if(userValidation(newUser) == "success"){
                val intent = Intent(this, DataActivity::class.java)
                intent.putExtra("Name", name)
                intent.putExtra("PhoneNumber", phoneNo)
                intent.putExtra("Email", emailAddress)
                intent.putExtra("Gender", sex)
                startActivity(intent)
            } else {
                Snackbar.make(it, userValidation(newUser),Snackbar.LENGTH_LONG).show()
            }


        }

    }
}