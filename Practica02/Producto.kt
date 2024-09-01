class Producto(
    private var precio: Float,
    private var descuento: Int
) {
    // Init para validar que el descuento esté entre 0 y 100
    init {
        require(descuento in 0..100) { "El descuento debe estar entre 0 y 100." }
    }
    // SETTERS
    fun setPrecio(monto: Float) {
        if (monto > 0) precio = monto
        else println("Ingreso un monto no válido")
    }
    fun setDescuento(porcentaje: Int) {
        if (porcentaje in 0..100) descuento = porcentaje
        else println("Porcentaje de descuento debe estar entre 0 y 100")
    }
    // GETTERS
    fun getPrecio(): Float = precio
    fun getDescuento(): Int = descuento

    // Función para aplicar el descuento al precio
    fun aplicarDescuento() {precio = precio * (1 - descuento / 100f)}
}

// Ejemplo de uso
fun main() {
    val producto = Producto(100f, 10)

    println("Precio inicial: ${producto.getPrecio()}")
    println("Descuento inicial: ${producto.getDescuento()}%")

    producto.aplicarDescuento()
    println("Precio después de aplicar descuento: ${producto.getPrecio()}")

    producto.setPrecio(200f)
    println("Nuevo precio: ${200f}")
    producto.setDescuento(15)
    println("Nuevo descuento en: 15%")
    producto.aplicarDescuento()

    println("Nuevo precio después de aplicar descuento: ${producto.getPrecio()}")
}
