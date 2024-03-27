package com.appdeveloper.demo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.ui.AppBarConfiguration

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var appBarConfiguration: AppBarConfiguration

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logBtn = findViewById<Button>(R.id.loginBtn)

        logBtn.setOnClickListener {

            val homeIntent = Intent(this, HomeActivity::class.java)
            startActivity(homeIntent)
        }
    }
}