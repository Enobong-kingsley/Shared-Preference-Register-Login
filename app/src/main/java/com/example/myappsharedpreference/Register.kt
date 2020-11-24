package com.example.myappsharedpreference

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val userName = findViewById<EditText>(R.id.editText1)
        val password = findViewById<EditText>(R.id.editText2)
        val email = findViewById<EditText>(R.id.editText3)
        val btnRegister = findViewById<Button>(R.id.register)
        val backToLogin = findViewById<TextView>(R.id.back_to_login)

        btnRegister.setOnClickListener {



            val preferences: SharedPreferences = getSharedPreferences("MYPREFS", MODE_PRIVATE)
            val newUser: String = userName.getText().toString()
            val newPassword: String = password.getText().toString()
            val newEmail: String = email.getText().toString()
            val editor: SharedPreferences.Editor = preferences.edit()


            editor.putString(newUser, newUser)
            editor.commit()
            editor.putString(newPassword, newPassword)
            editor.commit()
            editor.putString(newUser + newPassword + "data", """ $newUser $newEmail """.trimIndent())
            editor.commit()
        }
        backToLogin.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
    }
}