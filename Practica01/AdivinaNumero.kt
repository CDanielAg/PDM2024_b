fun main() {
    val numero = (1..30).random() //variable con un numero entero random del 1 al 30
    println("Intenta adivinar el número(1-30):")
    var respuesta:Int? = null    //Se crea una variable y esta predefinida en null
    do{
        respuesta = readln().toInt() //Se lee el imput por el teclado y el valor se transforma en entero
        if (respuesta == null || respuesta !in 1..30) {
            println("Por favor, ingresa un número válido entre 1 y 30.")
            continue //Se utiliza continue para saltar a la siguiente iteración del while
        }
        else if (respuesta > numero) println("El número es más pequeño.")
        else if (respuesta < numero) println("El número es más grande")
        else {
            println("Ganaste felicidades")
            break
        }
    }while(true)
}