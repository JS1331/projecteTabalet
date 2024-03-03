package com.example.tabalet

import android.R
import android.graphics.Rect
import android.os.Bundle
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.View.DragShadowBuilder
import android.view.View.OnDragListener
import android.view.View.OnTouchListener
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class nivell4 : AppCompatActivity() {
    private var conejosinpintar: ImageView? = null
    private var pajaro: ImageView? = null
    private var conejo: ImageView? = null
    private var caracolsinpintar: ImageView? = null
    private var pajarosinpintar: ImageView? = null
    private var caracol: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level_4)

        // Asignar referencias de las ImageView desde el layout
        conejosinpintar = findViewById<ImageView>(R.id.conejosinpintar)
        pajaro = findViewById<ImageView>(R.id.pajaro)
        conejo = findViewById<ImageView>(R.id.conejo)
        caracolsinpintar = findViewById<ImageView>(R.id.caracolsinpintar)
        pajarosinpintar = findViewById<ImageView>(R.id.pajarosinpintar)
        caracol = findViewById<ImageView>(R.id.caracol)

        // Configurar listeners de arrastrar y soltar para cada objeto
        conejo.setOnTouchListener(MyTouchListener())
        pajaro.setOnTouchListener(MyTouchListener())
        caracol.setOnTouchListener(MyTouchListener())

        // Configurar listeners de soltar para las siluetas
        conejosinpintar.setOnDragListener(MyDragListener(R.drawable.conejosinpintar))
        caracolsinpintar.setOnDragListener(MyDragListener(R.drawable.caracolsinpintar))
        pajarosinpintar.setOnDragListener(MyDragListener(R.drawable.tatuaje_de_pajaro))

        // Configurar listener de clic para el botón "Comprobar"
        findViewById<View>(R.id.btncomprobar3).setOnClickListener { comprobarRelaciones() }
    }

    private fun comprobarRelaciones() {
        var relacionCorrecta = true

        // Verificar si cada imagen está relacionada correctamente
        if (conejosinpintar!!.drawable.constantState == resources.getDrawable(R.drawable.conejo).constantState) {
            // Conejo está correctamente relacionado
        } else {
            relacionCorrecta = false
        }
        if (caracolsinpintar!!.drawable.constantState == resources.getDrawable(R.drawable.caracol).constantState) {
            // Conejo está correctamente relacionado
        } else {
            relacionCorrecta = false
        }
        if (pajarosinpintar!!.drawable.constantState == resources.getDrawable(R.drawable.tatuaje_de_pajaro).constantState) {
            // Conejo está correctamente relacionado
        } else {
            relacionCorrecta = false
        }
        if (relacionCorrecta) {
            Toast.makeText(
                this,
                "Todas las imágenes están correctamente relacionadas",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(
                this,
                "Al menos una imagen no está correctamente relacionada",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private inner class MyTouchListener : OnTouchListener {
        override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
            return if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                val shadowBuilder = DragShadowBuilder(view)
                view.startDrag(null, shadowBuilder, view, 0)
                true
            } else {
                false
            }
        }
    }

    internal inner class MyDragListener(private val targetImageResource: Int) :
        OnDragListener {
        override fun onDrag(v: View, event: DragEvent): Boolean {
            when (event.action) {
                DragEvent.ACTION_DROP -> {
                    val draggedView = event.localState as View
                    val draggedImageView = draggedView as ImageView
                    val targetImageView = v as ImageView
                    val targetRect = Rect()
                    targetImageView.getGlobalVisibleRect(targetRect)
                    return if (targetRect.contains(event.x.toInt(), event.y.toInt())) {
                        targetImageView.setImageResource(targetImageResource)
                        Toast.makeText(
                            this@Level4,
                            "Imagen relacionada correctamente",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    } else {
                        Toast.makeText(
                            this@Level4,
                            "Intenta soltar la imagen en la silueta",
                            Toast.LENGTH_SHORT
                        ).show()
                        false
                    }
                }

                else -> {}
            }
            return true
        }
    }
}