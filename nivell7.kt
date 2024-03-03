package com.example.projectetabalet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class nivell7 : AppCompatActivity() {
    var cuadratClicked: Boolean = false
    var triangleClicked: Boolean = false
    var cercleClicked: Boolean = false
    var randNum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level_7)
        generateRandom()
        val cuadratView = findViewById<View>(R.id.imageViewCuadrat)
        val cercleView =  findViewById<View>(R.id.imageViewCercle)
        val triangleView =  findViewById<View>(R.id.imageViewTriangle)


        generateRandom()
        cuadratView.setOnClickListener(){
            cuadratClicked = true
            comprobar(randNum)
        }

        cercleView.setOnClickListener(){
            cercleClicked = true
            comprobar(randNum)
        }

        triangleView.setOnClickListener(){
            triangleClicked = true
            comprobar(randNum)
        }
    }

    private fun comprobar(randNum:Int) {
        if(randNum == 1 && cuadratClicked == true){
            val intent = Intent(this, success::class.java)
            startActivity(intent)
            finish()
        }
        else if(randNum == 2 && triangleClicked == true){
            val intent = Intent(this, success::class.java)
            startActivity(intent)
            finish()
        }
        else if(randNum == 3 && cercleClicked == true){
            val intent = Intent(this, success::class.java)
            startActivity(intent)
            finish()
        }
        else{
            val intent = Intent(this, error::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun generateRandom() {
        randNum = Random.nextInt(1, 4)
        val tvForma = findViewById<TextView>(R.id.tvForma)
        when (randNum) {
            1 -> tvForma.text = "Cuadrat"
            2 -> tvForma.text = "Triangle"
            3 -> tvForma.text = "Cercle"
        }
    }
}
