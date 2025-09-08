package com.example.colorpickerapp

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
            // TANPA try-catch - akan crash jika invalid
            bgLayout.setBackgroundColor(Color.parseColor("#$color"))
            tvResult.text = getString(R.string.result, color)
        }
    }
}
