package App

import Model.Conta

fun main(args: Array<String>) {

    val conta = Conta("Artur")
    conta.saldo = 50.0

    val conta2 = Conta()
    conta2.nomeTitular = "Trevor"
    conta2.saldo = 40.0
}