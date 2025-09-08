package com.example.colorpickerapp

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
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

        if (color != null) {
            try {
                // TAMBAH try-catch untuk commit 3
                bgLayout.setBackgroundColor(Color.parseColor("#$color"))
                tvResult.text = getString(R.string.result, color)
            } catch (e: Exception) {
                // Kirim error response ke MainActivity
                val errorIntent = Intent()
                errorIntent.putExtra("ERROR", true)
                setResult(Activity.RESULT_OK, errorIntent)
                finish() // Kembali ke MainActivity
            }
        }
    }
}
