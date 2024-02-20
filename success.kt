package com.example.projectetabalet

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class success: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.succes)
        val btnContinuar = findViewById<Button>(R.id.btnContinue)

        btnContinuar.setOnClickListener(){
            closeIntent()
        }
    }

    fun closeIntent(){
        finish()
    }
}