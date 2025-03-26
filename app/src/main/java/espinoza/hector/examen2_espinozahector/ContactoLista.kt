package espinoza.hector.examen2_espinozahector

import androidx.core.content.ContextCompat
import androidx.test.core.app.ApplicationProvider

object ContactoLista {


    private val contactos = mutableListOf<Contacto>()

    init {
        contactos.add(Contacto("Lucía", "Peña", "Secretaría de Salud Pública", "lucia.pena@email.com", "6641234567", ContextCompat.getColor(ApplicationProvider.getApplicationContext(), R.color.red)))
        contactos.add(Contacto("Gilberto", "Borrego", "Gamesa", "gilberto.borrego@email.com", "6629876543", ContextCompat.getColor(ApplicationProvider.getApplicationContext(), R.color.blue)))
        contactos.add(Contacto("Beatriz", "Vizcarra", "Gelatina", "beatriz.vizcarra@email.com", "6673219876", ContextCompat.getColor(ApplicationProvider.getApplicationContext(), R.color.green)))
        contactos.add(Contacto("Karla", "Monreal", "ITSON", "karla.monreal@email.com", "6445551234", ContextCompat.getColor(ApplicationProvider.getApplicationContext(), R.color.magenta)))
        contactos.add(Contacto("Laura", "García", "Pinnacle", "laura.garcia@email.com", "6567894321", ContextCompat.getColor(ApplicationProvider.getApplicationContext(), R.color.cyan)))
        contactos.add(Contacto("Iván", "Tapia", "Wizeline", "ivan.tapia@email.com", "6634567890", ContextCompat.getColor(ApplicationProvider.getApplicationContext(), R.color.yellow)))
        contactos.add(Contacto("Gibrán", "Durán", "IBM", "gibran.duran@email.com", "6652348765", ContextCompat.getColor(ApplicationProvider.getApplicationContext(), R.color.dark_gray)))
        contactos.add(Contacto("Carlos", "González", "Carl’s Jr.", "carlos.gonzalez@email.com", "6627654321", ContextCompat.getColor(ApplicationProvider.getApplicationContext(), R.color.light_gray)))
        contactos.add(Contacto("Alma", "Chávez", "Caffenio", "alma.chavez@email.com", "6648765432", ContextCompat.getColor(ApplicationProvider.getApplicationContext(), R.color.black)))
    }

    // Método para obtener la lista de contactos
    fun obtenerContactos(): List<Contacto> {
        return contactos
    }

    // Método para agregar un nuevo contacto a la lista
    fun agregarContacto(contacto: Contacto) {
        contactos.add(contacto)
    }
}