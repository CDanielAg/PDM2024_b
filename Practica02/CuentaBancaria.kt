class CuentaBancaria (//Constructor de cuenta bancaria
    private var saldo:Float,
    private var limite:Float
){
    //funciones gets
    fun getLimite():Float = limite
    fun getSaldo():Float = saldo
    //funciones sets
    fun setLimite(cambio:Float) {
        if(cambio>0) limite = cambio
        else println("Valor ingresado no valido")
    }
    fun setSaldo(cambio:Float){ saldo = cambio}
    //funcion retirar
    fun retirar(retiro: Float) {
        require(retiro > 0) { "El monto a retirar debe ser positivo." } //se usa require para mostrar un mensaje de error
        when {
            retiro > limite -> println("El monto a retirar excede el límite de retiro por ${retiro - limite}.")
            retiro > saldo -> println("Saldo insuficiente. Saldo actual: ${saldo}.")
            else -> {
                saldo -= retiro
                println("Monto retirado: $retiro. Saldo actual: $saldo.")
            }
        }
    }
}

fun main() {
    //crea un obvjeto de la clase
    val cuenta1 = CuentaBancaria(2349f, 1000f)

    println("Saldo de la cuenta: ${cuenta1.getSaldo()}")
    println("Límite actual: ${cuenta1.getLimite()}")

    cuenta1.setLimite(3000f)
    println("Nuevo límite: ${cuenta1.getLimite()}")

    cuenta1.retirar(100f)
    cuenta1.retirar(250f)
    cuenta1.retirar(500f)
    cuenta1.retirar(-100f)
}