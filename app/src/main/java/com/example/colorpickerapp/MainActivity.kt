package com.example.colorpickerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // TAMBAH ActivityResult untuk commit 3
    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val data = result.data
        val error = data?.getBooleanExtra("ERROR", false) ?: false
        if (error) {
            Toast.makeText(this, getString(R.string.invalid), Toast.LENGTH_LONG).show()
        }
    }

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
                // FIX: Ganti R.string.short dengan R.string.length_error
                Toast.makeText(this, getString(R.string.length_error), Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("COLOR", color)
                // GANTI startActivity dengan launcher untuk commit 3
                launcher.launch(intent)
            }
        }
    }
}
