// Clase abstracta Shape
abstract class Shape {
    // Propiedades abstractas
    abstract val area: Float
    abstract val perimeter: Float

    // Metodos para imprimir
    fun printResults() {
        println("Área: $area")
        println("Perímetro: $perimeter")
    }
}
//Clase cuadrado
class Cuadrado(private val lado: Float): Shape(){
    override val area: Float
        get() = lado * lado

    override val perimeter: Float
        get() = 4 * lado
}
//Class circulo
class Circulo(private val radio: Float) : Shape() {
    override val area: Float
        get() = Math.PI.toFloat() * radio * radio

    override val perimeter: Float
        get() = 2 * Math.PI.toFloat() * radio
}
//Class rectangulo
class Rectangulo(private val largo: Float, private val ancho: Float) : Shape() {
    override val area: Float
        get() = largo * ancho

    override val perimeter: Float
        get() = 2f * (largo + ancho)
}
//En las anteriores clases se usa get() para definir directamente las variables en lugar de hacer funciones para definirlas manualmente

//Probando clases
fun main(){
    println("Cuadrado:")
    val cuadrado = Cuadrado(4f)
    cuadrado.printResults()
    println("\nCirculo:")
    val circulo = Circulo(4f)
    circulo.printResults()
    println("\nRectangulo:")
    val rectangulo = Rectangulo(3f,4f)
    rectangulo.printResults()
}
