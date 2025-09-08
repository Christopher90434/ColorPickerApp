package com.example.colorpickerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etColor = findViewById<EditText>(R.id.et_color)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)

        btnSubmit.setOnClickListener {
            val color = etColor.text.toString()

            if (color.isEmpty()) {
                Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_LONG).show()
            } else if (color.length < 6) {
                // GANTI dari R.string.short ke R.string.length_error
                Toast.makeText(this, getString(R.string.length_error), Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("COLOR", color)
                startActivity(intent)
            }
        }
    }
}
