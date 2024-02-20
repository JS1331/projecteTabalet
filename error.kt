package com.example.projectetabalet

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class error: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.error)
        val btnContinuar = findViewById<Button>(R.id.btnContinue)

        btnContinuar.setOnClickListener(){
            closeIntent()
        }
    }

    fun closeIntent(){

        finish()
    }
}