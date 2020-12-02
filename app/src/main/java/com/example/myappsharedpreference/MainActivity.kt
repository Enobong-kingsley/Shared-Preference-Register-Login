package com.example.myappsharedpreference

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.text_username)
        val etPassword = findViewById<EditText>(R.id.text_password)
        val btnLogin = findViewById<Button>(R.id.login)
        val btnRegister = findViewById<TextView>(R.id.registerMe)

        btnRegister.setOnClickListener {
            Toast.makeText(this,"done",Toast.LENGTH_LONG).show()
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {

            val user: String = etName.text.toString()
            val password: String = etPassword.text.toString()
            val preferences: SharedPreferences = getSharedPreferences("MYPREFS", MODE_PRIVATE)
            val userDetails: String? = preferences.getString(user + password + "data", "Username or Password is Incorrect.")
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.putString("display", userDetails)
            editor.commit()
            val displayScreen = Intent(this@MainActivity, DisplayScreen::class.java)
            startActivity(displayScreen)
        }
        btnRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

    }

}

