package com.example.pinterest

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val username = intent.getStringExtra("USERNAME") ?: "Unknown User"
        val usernameTextView = findViewById<TextView>(R.id.username)
        usernameTextView.text = username

        val backButton = findViewById<ImageButton>(R.id.go_back)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}
