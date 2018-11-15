package App

import Service.Urna

fun main(args: Array<String>) {

    val urna = Urna()

    val PrMenu = "1. Nova Eleição" +
            "\n2. Fechar eleições abertas" +
            "\n3. Estatísticas" +
            "\n4. Ver status das eleições" +
            "\n0. Sair" +
            "\nPara obter ajuda pressione h"
    println(PrMenu)

    loop@ while (true){
        print("Opção: ")
        val frOpc = readLine()

        when(frOpc){

            //cria uma nova eleição pedindo os dados
            "1" ->{

                print("Título desta eleilção: ")
                val titulo = readLine().toString()
                print("Quantidade de eleitores: ")
                val qtdEleitores = readLine()!!.toInt()

                urna.novaEleicao(titulo) //cria uma nova eleição, abre-a e é adicionada ao array.
                urna.distribuirTokens(qtdEleitores) //distribui os tokens de acordo a quantidade digitada.

                //mostra todos os tokens dos eleitores habilitados para votação
                println("Eleição criada e aberta para votação" +
                        "\nTokens:" +
                        "\n${urna.obterTokens()}")
            }

            //operações simples com as eleições cadastradas.
            "2" ->{

                println("Qual eleição deseja encerrar as votações?")
                println(urna.dadosEleicoes())
                val tituloEleicao = readLine().toString()

                urna.fecharEleicao(tituloEleicao)
                println("$tituloEleicao encerrada. Votações podem ser consultadas na opção 3.")
            }

            //estatísticas de votos.
            "3" ->{

            }

            //verifica o estado de cada eleição, se está aberta para voração ou fechada.
            "4" ->{

                println(urna.dadosEleicoes())
            }

            //Encerra o programa
            "0" ->{
                println("Encerrado.")
                break@loop
            }
            "h" ->{
                println(PrMenu)
            }
            else -> println("Opção inválida")
        }
    }
}