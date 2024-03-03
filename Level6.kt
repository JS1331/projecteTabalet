import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tabalet.R

class Level6 : AppCompatActivity() {
    private lateinit var tabaletgran: ImageView
    private lateinit var tabaletmedio: ImageView
    private lateinit var tabaletpeque: ImageView
    private lateinit var btncomprobar: Button

    private var clickedImages = mutableListOf<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level_6)

        tabaletgran = findViewById(R.id.tabaletgran)
        tabaletmedio = findViewById(R.id.tabaletmedio)
        tabaletpeque = findViewById(R.id.tabalet)
        btncomprobar = findViewById(R.id.btncomprobar4)

        tabaletgran.setOnClickListener {
            handleImageClick(tabaletgran)
        }

        tabaletmedio.setOnClickListener {
            handleImageClick(tabaletmedio)
        }

        tabaletpeque.setOnClickListener {
            handleImageClick(tabaletpeque)
        }

        btncomprobar.setOnClickListener {
            checkOrder()
        }
    }

    private fun handleImageClick(imageView: ImageView) {
        clickedImages.add(imageView)
    }

    private fun checkOrder() {
        val order = listOf(tabaletgran, tabaletmedio, tabaletpeque)
        if (clickedImages == order) {
            showToast("¡Orden correcto!")
        } else {
            showToast("Orden incorrecto, intenta de nuevo.")
        }
        clickedImages.clear()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
