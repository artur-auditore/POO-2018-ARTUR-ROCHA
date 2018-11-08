package Casa

fun main(args: Array<String>) {
    val casa = Casa()

    casa.pinta("Azul")
    casa.porta1.abre()
    casa.porta2.abre()

    println("Quantidade de portas abertas: ${casa.quantidadeDePortasAbertas()}")
}