fun main() {
    val numero = (1..30).random()
    println("Intenta adivinar el número(1-30):")
    var respuesta:Int? = null
    do{
        respuesta = readln().toInt()
        if (respuesta == null || respuesta !in 1..30) {
            println("Por favor, ingresa un número válido entre 1 y 30.")
            continue
        }
        else if (respuesta > numero) println("El número es más pequeño.")
        else if (respuesta < numero) println("El número es más grande")
        else {
            println("Ganaste felicidades")
            break
        }
    }while(true)
}