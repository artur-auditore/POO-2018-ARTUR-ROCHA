package Porta

fun main(args: Array<String>) {

    val porta = Porta()
    val porta2 = Porta()
    val porta1 = Porta()

    porta.pinta("verde")
    porta.dimensaoX = 30; porta.dimensaoY = 10; porta.dimensaoZ = 1
    porta1.pinta("vermelho")
    porta2.pinta("Laranja")

    porta1.abre()
    porta2.abre()
    porta.abre()
    porta1.fecha()

    println("Porta está aberta? ${porta.estaAberta()}")
    println("Porta está aberta? ${porta2.estaAberta()}")
    println("Porta está aberta? ${porta1.estaAberta()}")

}