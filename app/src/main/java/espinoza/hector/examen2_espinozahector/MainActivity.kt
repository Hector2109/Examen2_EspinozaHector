package espinoza.hector.examen2_espinozahector

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var adapter: ContactoAdapter? = null
    private val REQUEST_CODE_ADD_CONTACT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val agregarContacto: Button = findViewById(R.id.btn_agregar_contacto)

        ContactoLista.cargarContactos(this)

        val listaContactos = ContactoLista.obtenerContactos()

        adapter = ContactoAdapter(listaContactos, this)

        val listView: ListView = findViewById(R.id.vista_contactos)
        listView.adapter = adapter

        agregarContacto.setOnClickListener {
            val intent = Intent(this, AgregarContactoActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_CONTACT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_ADD_CONTACT && resultCode == RESULT_OK) {
            val nombre = data?.getStringExtra("nombre") ?: ""
            val apellido = data?.getStringExtra("apellido") ?: ""
            val telefono = data?.getStringExtra("telefono") ?: ""
            val email = data?.getStringExtra("email") ?: ""
            val compania = data?.getStringExtra("compania") ?: ""
            val colorPerfil = ContextCompat.getColor(this, R.color.red)

            val nuevoContacto = Contacto(nombre, apellido, compania, email, telefono, colorPerfil)

            ContactoLista.agregarContacto(nuevoContacto)

            adapter?.notifyDataSetChanged()
        }
    }
}


class ContactoAdapter(var contactos: List<Contacto>, val context: Context) : BaseAdapter() {

    override fun getCount(): Int {
        return contactos.size
    }

    override fun getItem(position: Int): Any {
        return contactos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val contacto = contactos[position]
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vista = inflator.inflate(R.layout.informacion_basica_item, null)

        val imageProfile: ImageView = vista.findViewById(R.id.imgagen_perfil)
        imageProfile.setColorFilter(contacto.colorPerfil, PorterDuff.Mode.SRC_IN)

        val nombre: TextView = vista.findViewById(R.id.tv_nombre)
        nombre.text = "${contacto.nombre} ${contacto.apellido}"

        val tvCompania: TextView = vista.findViewById(R.id.tv_compania)
        tvCompania.text = contacto.compania

        val deleteButton: ImageView = vista.findViewById(R.id.delete)

        deleteButton.setOnClickListener {
            ContactoLista.eliminarContacto(contacto)
            contactos = ContactoLista.obtenerContactos()
            notifyDataSetChanged()

        }

        imageProfile.setOnClickListener {
            val intent = Intent(context, DetalleActivity::class.java).apply {
                putExtra("nombre", contacto.nombre)
                putExtra("apellido", contacto.apellido)
                putExtra("email", contacto.email)
                putExtra("telefono", contacto.telefono)
                putExtra("compania", contacto.compania)
                putExtra("perfil", contacto.colorPerfil)
            }
            context.startActivity(intent)
        }

        return vista
    }
}