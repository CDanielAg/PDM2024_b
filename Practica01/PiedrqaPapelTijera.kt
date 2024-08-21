//Función random de : https://stackoverflow.com/questions/45685026/how-can-i-get-a-random-number-in-kotlin
fun game(opcion:String):String{   // Función principal requiere un string y retorna un string
    val respuesta = listOf("piedra","papel","tijeras").random()   //se utiliza listOF para crear una lista y utilizar rendom en ella
    println("La computadora eligió: $respuesta")
    if (respuesta == opcion) return "empate"
    if ((respuesta == "piedra" && opcion == "tijeras") || (respuesta == "tijeras" && opcion == "papel") || (respuesta == "papel" && opcion == "piedra")) //Lógica del juego
        return "pierdes"
    else return "ganas"
}

fun main(){
    println("Elige una opción:\n1. Piedra\n2. Papel \n3. Tijeras")
    val input = readln() ?: ""
    val opcion = when (input){ //Se utiliza when dentro de la variable para indicar que tomara el valor designado por el imput
        "1" -> "piedra"
        "2" -> "papel"
        "3" -> "tijeras"
        else -> {println("Opción no v'alida");return}
    }
    val resultado = game(opcion) //Ejecutar funcion principal
    println("Resultado: $resultado")
}