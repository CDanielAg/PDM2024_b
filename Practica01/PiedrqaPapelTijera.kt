//Función random de : https://stackoverflow.com/questions/45685026/how-can-i-get-a-random-number-in-kotlin
fun game(opcion:String):String{
    val respuesta = listOf("piedra","papel","tijeras").random()
    println("La computadora eligió: $respuesta")
    if (respuesta == opcion) return "empate"
    if ((respuesta == "piedra" && opcion == "tijeras") || (respuesta == "tijeras" && opcion == "papel") || (respuesta == "papel" && opcion == "piedra"))
        return "pierdes"
    else return "ganas"
}

fun main(){
    println("Elige una opción:\n1. Piedra\n2. Papel \n3. Tijeras")
    val input = readln() ?: ""
    val opcion = when (input){
        "1" -> "piedra"
        "2" -> "papel"
        "3" -> "tijeras"
        else -> {println("Opción no v'alida");return}
    }
    val resultado = game(opcion)
    println("Resultado: $resultado")
}