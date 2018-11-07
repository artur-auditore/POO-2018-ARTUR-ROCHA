package App

import Model.Conta
import Model.Data

fun main(args: Array<String>) {
    val c1 = Conta()
    val c2 = Conta()

    c1.nomeTitular = "Artur"
    c1.numero = 2342
    c1.saldo = 1020.0
    c1.dataDeAbertura = Data(12, 11, 2014)

    c2.nomeTitular = "Artur"
    c2.numero = 2342
    c2.saldo = 1020.0
    c2.dataDeAbertura = Data(12, 11, 2014)

    println(c1.recuperaDadosParaImpressao())

    if (c1 == c2) println("Contas Iguais") else println("Contas Diferentes")
    //Contas diferentes
    //c2 = c1 retorna "Contas Iguais"

}