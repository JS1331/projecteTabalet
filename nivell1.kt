package com.example.projectetabalet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class nivell1: AppCompatActivity(){
    var count:Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level_1)
        val imatgeConill = findViewById<View>(R.id.imatgeConillLvl1)
        val botoComprobar = findViewById<Button>(R.id.btncomprobar)

        imatgeConill.setOnClickListener{
            count()
        }

        botoComprobar.setOnClickListener{
            comprobar()
        }
    }

     fun count(){
        count++
    }

    fun comprobar(){
        if(count == 3){
            val intent = Intent(this, success::class.java)
            startActivity(intent)
        }
        else{
            val intent = Intent(this, error::class.java)
            startActivity(intent)
        }
        finish()
    }
}  