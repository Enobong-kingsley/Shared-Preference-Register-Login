package com.example.myappsharedpreference

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_info)

        val preferences: SharedPreferences = getSharedPreferences("MYPREFS", MODE_PRIVATE)
        val display: String? = preferences.getString("display", "")
        val displayInfo = findViewById<TextView>(R.id.display)
        displayInfo.text = display
    }
}