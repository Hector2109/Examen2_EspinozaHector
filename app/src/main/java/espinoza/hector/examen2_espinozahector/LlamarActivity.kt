package espinoza.hector.examen2_espinozahector

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LlamarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_llamar)


        val colgar: ImageView = findViewById(R.id.colgar)
        val nombre: TextView = findViewById(R.id.tv_nombre)


        val bundle = intent.extras

        if (bundle != null) {
            val nombreContacto = bundle.getString("nombre")
            val apellidoContacto = bundle.getString("apellido")

            nombre.setText("$nombreContacto $apellidoContacto")

        }

        colgar.setOnClickListener(){
            finish()
        }



    }
}