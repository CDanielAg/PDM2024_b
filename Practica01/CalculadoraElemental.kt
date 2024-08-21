fun calculadora(opcion:Int):Float{     //Función principal, requiere una variable entera y retorna un flotante
    println("Ingresa el primer numero:")
    val numero1 = readln().toFloat()  //lee el primer número
    println("Ingresa el segundo numero:")
    val numero2 = readln().toFloat() //lee el segundo número
    return when(opcion){      //se usa return when para evitar repetir la palabra return
        1 -> numero1 + numero2
        2 -> numero1 - numero2
        3 -> numero1 * numero2
        else -> {
            if(numero2 == 0.0f){     //se utiliza un if para no permitir las divisiones entre cero
                println("Error al dividir entre cero.")
                return 0.0f
            }
            numero1 / numero2}
    }
}

fun main(){
    do {
        println("==== Menú ====\n\t1. Suma\n\t2. Resta\n\t3. Multiplicación\n\t4. División\n\t5. Salir") //se usa \n y \t para el salto de linea y tab
        val opcion = readln().toIntOrNull()
        if (opcion == null || opcion !in 1..5) {     // Se confirma que el número no sea nulo ni este fuera de 1 a 5
            println("Opción no válida. Intenta de nuevo.\n\n\n\n\n")
            continue
        }
        if(opcion == 5) break //Si la opcion es 5 se rompe el ciclo con break
        println("Resultado: ${calculadora(opcion)}\nEnter para continuar...")
        var continuar = readln().toString()  //se utiliza una variable x para simular una pausa
    }while(true) //se utiliza true para indicar que el ciclo sera infinito a menos que se rompa
}