package espinoza.hector.examen2_espinozahector

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle)

        var imagenPerfil: ImageView = findViewById(R.id.img_perfil)
        var nombre: TextView = findViewById(R.id.tv_nombre)
        var compania: TextView = findViewById(R.id.tv_compania)
        var email: TextView = findViewById(R.id.tv_email)
        var telefono: TextView = findViewById(R.id.tv_telefono)
        val llamar: Button = findViewById(R.id.btn_llamar)

        var bundle = intent.extras

        if (bundle != null) {
            imagenPerfil.setColorFilter(bundle.getInt("perfil"), PorterDuff.Mode.SRC_IN)

            val nombreContacto = bundle.getString("nombre" )
            val apellidoContacto = bundle.getString("apellido")
            nombre.text = "$nombreContacto $apellidoContacto"

            compania.text = bundle.getString("compania", "Sin compañía")
            email.text = bundle.getString("email", "Sin email")
            telefono.text = bundle.getString("telefono", "Sin teléfono")
        }

        llamar.setOnClickListener {
            val intent = Intent(this, LlamarActivity::class.java)
            intent.putExtra("nombre", bundle?.getString("nombre"))
            intent.putExtra("apellido", bundle?.getString("apellido"))

            startActivity(intent)
        }


    }
}