// Clase abstracta Material
abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    // Metodo para mostrar detalles
    abstract fun mostrarDetalles()
}

class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion){
    override fun mostrarDetalles() {
        println("\tLibro:\n" +
                "Título: $titulo\n" +
                "Autor: $autor\n" +
                "Año de Publicación: $anioPublicacion\n" +
                "Género: $genero\n" +
                "Número de Páginas: $numeroPaginas")
    }
}
class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista:\n" +
                "Título: $titulo\n" +
                "Autor: $autor\n" +
                "Año de Publicación: $anioPublicacion\n" +
                "ISSN: $issn\n" +
                "Volumen: $volumen\n" +
                "Número: $numero\n" +
                "Editorial: $editorial")
    }
}

data class Usuario( //data class
    val nombre: String,
    val apellido: String,
    val edad: Int
)

interface IBiblioteca { //interfaz
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestamo(usuario: Usuario, material: Material): String
    fun devolucion(usuario: Usuario, material: Material): String
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material){materialesDisponibles.add(material)}

    override fun registrarUsuario(usuario: Usuario) {
        if (!usuarios.containsKey(usuario)) {
            usuarios[usuario] = mutableListOf()
        }
    }

    override fun prestamo(usuario: Usuario, material: Material): String {
        if (material in materialesDisponibles) {
            if (usuarios.containsKey(usuario)) {
                materialesDisponibles.remove(material)
                usuarios[usuario]?.add(material)
                return "Prestamo aprobadoa ${usuario.nombre}"
            }
        }
        return "Usuario no registrado"
    }

    override fun devolucion(usuario: Usuario, material: Material): String {
        if (usuarios.containsKey(usuario) && material in usuarios[usuario]!!) {
            usuarios[usuario]?.remove(material)
            materialesDisponibles.add(material)
            return "Devolucion completada a ${usuario.nombre}"
        }
        return "Usuario o material no registrado"
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales Disponibles:")
        for (material in materialesDisponibles) {
            material.mostrarDetalles()
        }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        if (usuarios.containsKey(usuario)) {
            println("Materiales Reservados por ${usuario.nombre} ${usuario.apellido}:")
            for (material in usuarios[usuario]!!) {
                material.mostrarDetalles()
            }
        } else {
            println("Usuario no registrado.")
        }
    }
}
//Probando las clases
fun main() {
    val biblioteca = Biblioteca()

    // Creando materiales
    val libro1 = Libro(
        titulo = "Don Quijote de la Mancha",
        autor = "Miguel de Cervantes",
        anioPublicacion = 1605,
        genero = "Novela",
        numeroPaginas = 1023
    )

    val libro2 = Libro(
        titulo = "El Principito",
        autor = "Antoine de Saint-Exupéry",
        anioPublicacion = 1943,
        genero = "Fábula",
        numeroPaginas = 96
    )

    val libro3 = Libro(
        titulo = "La Ciudad y los Perros",
        autor = "Mario Vargas Llosa",
        anioPublicacion = 1963,
        genero = "Novela",
        numeroPaginas = 254
    )

    val revista1 = Revista(
        titulo = "National Geographic",
        autor = "Editorial National Geographic",
        anioPublicacion = 2023,
        issn = "0027-9358",
        volumen = 75,
        numero = 4,
        editorial = "National Geographic Society"
    )

    // Crear instancias de usuarios
    val usuario1 = Usuario(nombre = "Daniel", apellido = "Aguilar", edad = 20)
    val usuario2 = Usuario(nombre = "Luis", apellido = "Gamez", edad = 22)

    // Registrar materiales
    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(libro2)
    biblioteca.registrarMaterial(libro3)
    biblioteca.registrarMaterial(revista1)
    // Registrar usuarios
    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    // Mostrar materiales disponibles
    println("Materiales disponibles en la biblioteca:")
    biblioteca.mostrarMaterialesDisponibles()

    // Prestamo de materiales
    println("\nRealizando prestamo de material:")
    println(biblioteca.prestamo(usuario1, libro1))
    println(biblioteca.prestamo(usuario2, libro2))

    // Mostrar materiales disponibles después del prestamo
    biblioteca.mostrarMaterialesDisponibles()

    // Mostrar materiales reservados por usuario1
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)

    // Devolucion de material
    println("\nRealizando devolución de material:")
    println(biblioteca.devolucion(usuario1, libro1))

    // Mostrar materiales disponibles despues de la devolucion
    biblioteca.mostrarMaterialesDisponibles()

    // Mostrar materiales reservados por usuario1 despues de la devolucion
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)
    println("No muestra nada porque ya se realizo la devolucion del libro prestado")
}

