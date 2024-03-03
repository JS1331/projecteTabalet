package com.example.tabalet;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Level4 extends AppCompatActivity {

    private ImageView conejosinpintar;
    private ImageView pajaro;
    private ImageView conejo;
    private ImageView caracolsinpintar;
    private ImageView pajarosinpintar;
    private ImageView caracol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_4);

        // Asignar referencias de las ImageView desde el layout
        conejosinpintar = findViewById(R.id.conejosinpintar);
        pajaro = findViewById(R.id.pajaro);
        conejo = findViewById(R.id.conejo);
        caracolsinpintar = findViewById(R.id.caracolsinpintar);
        pajarosinpintar = findViewById(R.id.pajarosinpintar);
        caracol = findViewById(R.id.caracol);

        // Configurar listeners de arrastrar y soltar para cada objeto
        conejo.setOnTouchListener(new MyTouchListener());
        pajaro.setOnTouchListener(new MyTouchListener());
        caracol.setOnTouchListener(new MyTouchListener());

        // Configurar listeners de soltar para las siluetas
        conejosinpintar.setOnDragListener(new MyDragListener(R.drawable.conejosinpintar));
        caracolsinpintar.setOnDragListener(new MyDragListener(R.drawable.caracolsinpintar));
        pajarosinpintar.setOnDragListener(new MyDragListener(R.drawable.tatuaje_de_pajaro));

        // Configurar listener de clic para el botón "Comprobar"
        findViewById(R.id.btncomprobar3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRelaciones();
            }
        });
    }

    private void comprobarRelaciones() {
        boolean relacionCorrecta = true;

        // Verificar si cada imagen está relacionada correctamente
        if (conejosinpintar.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.conejo).getConstantState())) {
            // Conejo está correctamente relacionado
        } else {
            relacionCorrecta = false;
        }

        if (caracolsinpintar.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.caracol).getConstantState())) {
            // Conejo está correctamente relacionado
        } else {
            relacionCorrecta = false;
        }

        if (pajarosinpintar.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.tatuaje_de_pajaro).getConstantState())) {
            // Conejo está correctamente relacionado
        } else {
            relacionCorrecta = false;
        }


        if (relacionCorrecta) {
            Toast.makeText(this, "Todas las imágenes están correctamente relacionadas", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Al menos una imagen no está correctamente relacionada", Toast.LENGTH_SHORT).show();
        }
    }

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(null, shadowBuilder, view, 0);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {
        private final int targetImageResource;

        public MyDragListener(int targetImageResource) {
            this.targetImageResource = targetImageResource;
        }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DROP:
                    View draggedView = (View) event.getLocalState();
                    ImageView draggedImageView = (ImageView) draggedView;
                    ImageView targetImageView = (ImageView) v;

                    Rect targetRect = new Rect();
                    targetImageView.getGlobalVisibleRect(targetRect);

                    if (targetRect.contains((int) event.getX(), (int) event.getY())) {
                        targetImageView.setImageResource(targetImageResource);
                        Toast.makeText(Level4.this, "Imagen relacionada correctamente", Toast.LENGTH_SHORT).show();
                        return true;
                    } else {
                        Toast.makeText(Level4.this, "Intenta soltar la imagen en la silueta", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                default:
                    break;
            }
            return true;
        }
    }
}
