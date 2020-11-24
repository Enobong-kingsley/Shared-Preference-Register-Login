package com.example.myappsharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class StarterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter)

        val lgnBttn = findViewById<TextView>(R.id.loginbtn)
        val registerBttn = findViewById<TextView>(R.id.registerbtn)

        lgnBttn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        registerBttn.setOnClickListener {
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }
    }
}