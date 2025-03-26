package espinoza.hector.examen2_espinozahector

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AgregarContactoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agregar_contacto)

        val edNombre: EditText = findViewById(R.id.ed_nombre)
        val edApellido: EditText = findViewById(R.id.ed_apellidos)
        val edTelefono: EditText = findViewById(R.id.ed_telefono)
        val edEmail: EditText = findViewById(R.id.ed_email)
        val edCompania: EditText = findViewById(R.id.ed_compania)

        val guardar: Button = findViewById(R.id.btn_agregar_contacto)



        guardar.setOnClickListener {
            val nombre = edNombre.text.toString()
            val apellido = edApellido.text.toString()
            val telefono = edTelefono.text.toString()
            val email = edEmail.text.toString()
            val compania = edCompania.text.toString()

            if (nombre.isEmpty()) {
                edNombre.error = "Este campo no puede estar vacío"
                return@setOnClickListener
            }
            if (apellido.isEmpty()) {
                edApellido.error = "Este campo no puede estar vacío"
                return@setOnClickListener
            }
            if (telefono.isEmpty()) {
                edTelefono.error = "Este campo no puede estar vacío"
                return@setOnClickListener
            }
            if (email.isEmpty()) {
                edEmail.error = "Este campo no puede estar vacío"
                return@setOnClickListener
            }


            val nuevoContacto = Contacto(
                nombre,
                apellido,
                compania,
                email,
                telefono,
                ContextCompat.getColor(this, R.color.red)
            )
            val resultIntent = Intent()
            resultIntent.putExtra("nuevoContacto", nuevoContacto)
            setResult(RESULT_OK, resultIntent)

            finish()
        }



    }
}
