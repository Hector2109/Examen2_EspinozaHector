package espinoza.hector.examen2_espinozahector

import java.io.Serializable

data class Contacto(val nombre:String,
                    val apellido: String,
                    val compania:String,
                    val email: String,
                    val telefono: String,
                    val colorPerfil: Int):Serializable
