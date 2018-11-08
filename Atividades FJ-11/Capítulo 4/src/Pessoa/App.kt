package Pessoa

fun main(args: Array<String>) {
    val pessoa = Pessoa("Artur", 21)

    pessoa.fazAniversario()
    pessoa.fazAniversario()

    println("Idade Atual: ${pessoa.idade}")
}