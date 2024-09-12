package com.example.registration_page

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.temporal.IsoFields

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var username = findViewById<EditText>(R.id.usernameET)
        var password = findViewById<EditText>(R.id.password)
        var email = findViewById<EditText>(R.id.emailET)
        var button = findViewById<Button>(R.id.confirm_button)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button.setOnClickListener {
            if (email.text.contains("@")) {
                Toast.makeText(this, "Valid email", Toast.LENGTH_SHORT)
            } else {
                Toast.makeText(this, "Invalid e-mail", Toast.LENGTH_SHORT).show()
            }
            if (password.text.length < 9) {
                Toast.makeText(this, "Weak password", Toast.LENGTH_SHORT).show()
            }
            if (username.text.length < 3) {
                Toast.makeText(this, "Username too short", Toast.LENGTH_SHORT).show()
            }
            if (username.text.length > 3 && password.text.length > 9 && email.text.contains("@")) {
                Toast.makeText(this, "Registration complete", Toast.LENGTH_SHORT).show()
                val myIntent = Intent(this, MainPageActivity::class.java)
                startActivity(myIntent)
            }

        }
    }
}