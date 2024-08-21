fun calculadora(opcion:Int):Float{
    println("Ingresa el primer numero:")
    val numero1 = readln().toFloat()
    println("Ingresa el segundo numero:")
    val numero2 = readln().toFloat()
    return when(opcion){
        1 -> numero1 + numero2
        2 -> numero1 - numero2
        3 -> numero1 * numero2
        else -> {
            if(numero2 == 0.0f){
                println("Error al dividir entre cero.")
                return 0.0f
            }
            numero1 / numero2}
    }
}

fun main(){
    do {
        println("==== Menú ====\n\t1. Suma\n\t2. Resta\n\t3. Multiplicación\n\t4. División\n\t5. Salir")
        val opcion = readln().toIntOrNull()
        if (opcion == null || opcion !in 1..5) {
            println("Opción no válida. Intenta de nuevo.\n\n\n\n\n")
            continue
        }
        if(opcion == 5) break
        println("Resultado: ${calculadora(opcion)}\nEnter para continuar...")
        var continuar = readln().toString()
    }while(true)
}