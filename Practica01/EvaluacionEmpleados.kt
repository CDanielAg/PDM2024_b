fun performance(dinero:Float, puntos:Int): String{   //Funcion principal requiere una variable flotante y un entero, retorna un string
    var rendimiento:Float = dinero * (puntos/10.0f)    //Es importante dividir entre un float para evitar complicaciones con el tipo de dato
    return when (rendimiento) { //Se utiliza return when para evitar repetir el return
        in 0.0..3000.0 -> "Inaceptable con ${rendimiento}"
        in 4000.0..6000.0 -> "Aceptable con ${rendimiento}"
        in 7000.0..10000.0 -> "Meritorio con ${rendimiento}"
        else -> "No calculable"
    }
}

fun main() {
    var sueldo = 10000.0f
    var puntos = 8
    println(performance(sueldo,puntos))  //ejecutando la funcion
}