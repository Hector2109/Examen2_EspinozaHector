package espinoza.hector.examen2_espinozahector

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.test.core.app.ApplicationProvider

object ContactoLista {

    private val contactos = mutableListOf<Contacto>()

    // Cambié esta parte para aceptar un contexto y obtener colores correctamente
    fun cargarContactos(context: Context) {
        contactos.add(Contacto("Lucía", "Peña", "Secretaría de Salud Pública", "lucia.pena@email.com", "6641234567", ContextCompat.getColor(context, R.color.red)))
        contactos.add(Contacto("Gilberto", "Borrego", "Gamesa", "gilberto.borrego@email.com", "6629876543", ContextCompat.getColor(context, R.color.blue)))
        contactos.add(Contacto("Beatriz", "Vizcarra", "Gelatina", "beatriz.vizcarra@email.com", "6673219876", ContextCompat.getColor(context, R.color.green)))
        contactos.add(Contacto("Karla", "Monreal", "ITSON", "karla.monreal@email.com", "6445551234", ContextCompat.getColor(context, R.color.magenta)))
        contactos.add(Contacto("Laura", "García", "Pinnacle", "laura.garcia@email.com", "6567894321", ContextCompat.getColor(context, R.color.cyan)))
        contactos.add(Contacto("Iván", "Tapia", "Wizeline", "ivan.tapia@email.com", "6634567890", ContextCompat.getColor(context, R.color.yellow)))
        contactos.add(Contacto("Gibrán", "Durán", "IBM", "gibran.duran@email.com", "6652348765", ContextCompat.getColor(context, R.color.dark_gray)))
        contactos.add(Contacto("Carlos", "González", "Carl’s Jr.", "carlos.gonzalez@email.com", "6627654321", ContextCompat.getColor(context, R.color.light_gray)))
        contactos.add(Contacto("Alma", "Chávez", "Caffenio", "alma.chavez@email.com", "6648765432", ContextCompat.getColor(context, R.color.black)))
    }

    fun obtenerContactos(): List<Contacto> {
        return contactos
    }

    fun agregarContacto(contacto: Contacto) {
        contactos.add(contacto)
    }

    fun eliminarContacto(contacto: Contacto) {
        contactos.remove(contacto)
    }
}