    package com.example.projectetabalet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button

    class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)
        val btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener{
            val intent = Intent(this, selectorNivells::class.java)
            startActivity(intent)
        }
    }
}