package com.example.projectetabalet;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity
;import com.example.tabalet.R;

public class nivell8:AppCompatActivity() {
private lateinit var pieces: Array<ImageView>
private var selectedPiece: ImageView? = null
private var offsetX = 0
private var offsetY = 0

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level_8)

        //referencias a las imágenes
        pieces = arrayOf(
        findViewById(R.id.pice3),
        findViewById(R.id.pice1),
        findViewById(R.id.pice2)
        )

        // asigna imágenes a las variables del rompecabezas
        pieces[0].setImageResource(R.drawable.tabale3_lvl8)
        pieces[1].setImageResource(R.drawable.tabalet_lvl8)
        pieces[2].setImageResource(R.drawable.tablaet2_lvl8)

        // OnTouchListener piezas
        for (piece in pieces) {
        piece.setOnTouchListener { view, event ->
        if (event.action == MotionEvent.ACTION_DOWN) {
        val clipData = View.DragShadowBuilder(view)
        view.startDragAndDrop(null, clipData, view, 0)
        true
        } else false
        }
        }

        //  arrastra las piezas para ordenarlas
        for (piece in pieces) {
        piece.setOnDragListener { v, event ->
        when (event.action) {
        DragEvent.ACTION_DROP -> {
        val draggedView = event.localState as View
        val owner = draggedView.parent as androidx.gridlayout.widget.GridLayout
        val container = v as androidx.gridlayout.widget.GridLayout

        val ownerIndex = owner.indexOfChild(draggedView)
        val containerIndex = container.indexOfChild(v)

        owner.removeView(draggedView)
        container.removeView(v)
        owner.addView(v, ownerIndex)
        container.addView(draggedView, containerIndex)

        true
        }
        else -> true
        }
        }
        }

        // Botón para comprobar el orden
        val btnComprobar = findViewById<View>(R.id.btncomprobar5)
        btnComprobar.setOnClickListener {
        if (checkOrder()) {
        //  Toast si el orden es correcto
        Toast.makeText(this, "¡El orden es correcto!", Toast.LENGTH_SHORT).show()
        } else {
        // Toast si el orden es incorrecto
        Toast.makeText(this, "¡El orden es incorrecto!", Toast.LENGTH_SHORT).show()
        }
        }
        }
// orden de la lista
private fun checkOrder(): Boolean {
        val order = listOf("tabalet_lvl8", "tabalet2_lvl8", "tabalet3_lvl8")
        val currentOrder = pieces.map { resources.getResourceName(it.id) }
        return order == currentOrder
        }
}
