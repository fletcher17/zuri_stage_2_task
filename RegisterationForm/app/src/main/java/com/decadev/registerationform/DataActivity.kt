package com.decadev.registerationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class DataActivity : AppCompatActivity() {

    lateinit var userName: TextView
    lateinit var phoneNumb : TextView
    lateinit var email2 : TextView
    lateinit var gender : TextView
    lateinit var male_imageView : ImageView
    lateinit var image2 : ImageView
    lateinit var image3 : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        //Views in the activity
        userName = findViewById(R.id.userName_textView)
        phoneNumb = findViewById(R.id.activity_data_phoneNumber_textView_value)
        email2 = findViewById(R.id.email_textView1)
        gender = findViewById(R.id.gender_textView)
        male_imageView = findViewById(R.id.imageView)
        image2 = findViewById(R.id.imageView2)
        image3 = findViewById(R.id.imageView3)

        //intent gets called
        var intent = intent

        //data delivered by the intent is being gotten/received
        val name = intent.getStringExtra("Name")
        val phoneNumber = intent.getStringExtra("PhoneNumber")
        val emailReceived = intent.getStringExtra("Email")
        val sex = intent.getStringExtra("Gender")


        //selects the image to be displayed according to the gender
        if(sex == "Male") male_imageView.isVisible = true else if( sex == "Female") image2.isVisible = true else image3.isVisible = true


        //TextView are being changed/inserted from the data received from the intent
        userName.text = name
        phoneNumb.text = phoneNumber
        email2.text = emailReceived
        gender.text = sex


    }
}