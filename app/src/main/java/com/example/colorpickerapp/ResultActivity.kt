package com.example.colorpickerapp

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val color = intent.getStringExtra("COLOR")
        val bgLayout = findViewById<LinearLayout>(R.id.bg_layout)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val btnBack = findViewById<Button>(R.id.btn_back) // TAMBAH BACK BUTTON

        if (color != null) {
            try {
                bgLayout.setBackgroundColor(Color.parseColor("#$color"))
                tvResult.text = getString(R.string.result, color)
            } catch (e: Exception) {
                val errorIntent = Intent()
                errorIntent.putExtra("ERROR", true)
                setResult(Activity.RESULT_OK, errorIntent)
                finish()
            }
        }

        // TAMBAH BACK BUTTON FUNCTIONALITY
        btnBack.setOnClickListener {
            finish() // Kembali ke MainActivity tanpa restarting app
        }
    }
}
