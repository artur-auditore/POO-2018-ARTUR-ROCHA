package App

import Service.Trello
import org.omg.CORBA.portable.InputStream
import java.io.File
import java.io.FileInputStream

fun main(args: Array<String>) {

    val trello = Trello()
    val menuLogin = "**** Trello App ****" +
            "\n1. Login" +
            "\n2. Cadastre-se" +
            "\n0. Sair"

    println(menuLogin)
    loop@ while (true){
        print("Opção: ")
        val opcao = readLine()!!.toString()

        when (opcao){

            "1" ->{

                println("E-mail/Nome de usuário:")
                val emailOrUsername = readLine()!!.toString()
                println("Senha:")
                val senha = readLine()!!.toString()

                if (trello.logar(emailOrUsername, senha)){
                    println("Bem vindo!")

                    val menuUsuario = "1. Novo quadro" +
                            "\n2. Ver quadros" +
                            "\n3. Abrir quadro" +
                            "\n0. Sair" +
                            "\nPara obter ajuda pressione h"

                    println(menuUsuario)
                    loop1@ while (true){
                        print("Opção: ")
                        val opcaoUsuario = readLine()!!.toString()

                        when(opcaoUsuario){

                            //Novo quadro
                            "1" ->{

                                println("Título:")
                                val titulo = readLine()!!.toString()

                                if (titulo.trim() == "") {
                                    println("Nome inválido. Tente novamente.")
                                } else {
                                    trello.novoQuadro(titulo)
                                    println("$titulo criado. Adicione listas...")
                                }
                            }
                            //Listagem por nome dos quadros
                            "2" ->{

                                println(trello.verQuadros())
                            }
                            //Abrir quadro
                            "3" ->{
                                println("Qual quadro deseja abrir?")
                                println(trello.verQuadros())
                                val nomeQuadro = readLine()!!.toString()

                                trello.abrirQuadro(nomeQuadro)
                                println("Quadro aberto.")

                                val menuQuadro = "1. Adicionar Lista" +
                                        "\n2. Abrir Lista" +
                                        "\n3. Ver Listas" +
                                        "\n4. Copiar Lista" +
                                        "\n5. Mover Lista" +
                                        "\n6. Arquivar" +
                                        "\n0. Voltar" +
                                        "\nPara obter ajuda pressione h"

                                println(menuQuadro)
                                loop2@ while (true){
                                    print("Opção:")
                                    val opcaoQuadro = readLine()!!.toString()
                                    when(opcaoQuadro){

                                        //Adicionar Lista
                                        "1" ->{
                                            println("Título:")
                                            val titulo = readLine()!!.toString()

                                            if (titulo.trim() == ""){
                                                println("Título inválido. Tente novamente.")
                                            } else{
                                                trello.novaLista(titulo)
                                                println("$titulo criada.")
                                            }
                                        }
                                        //Abrir Lista
                                        "2" ->{
                                            println("Qual lista deseja abrir?")
                                            println(trello.verListas())
                                            val nomeLista = readLine()!!.toString()

                                            trello.abrirLista(nomeLista)
                                            println("Lista aberta.")

                                            val menuCartao = "1. Novo cartão" +
                                                    "\n2. Abrir cartão" +
                                                    "\n3. Mover" +
                                                    "\n4. Copiar" +
                                                    "\n5. Arquvar" +
                                                    "\n0. Sair" +
                                                    "\nPara obter ajuda pressione h"

                                            println(menuCartao)
                                            loop3@ while (true){
                                                print("Opção: ")
                                                val opcaoCartao = readLine()!!.toString()

                                                when(opcaoCartao){

                                                    //Novo cartão
                                                    "1" ->{

                                                        println("Título: ")
                                                        val tituloCartao = readLine()!!.toString()
                                                        println("Descrição")
                                                        val descCartao = readLine()!!.toString()
                                                        if (tituloCartao.trim() == ""){
                                                            println("Forneça um título inválido")
                                                        } else {
                                                            trello.novoCartao(tituloCartao, descCartao)
                                                        }

                                                    }

                                                    "0" -> break@loop3
                                                    "h" -> println(menuCartao)
                                                    else -> println("Opção inválida.")
                                                }
                                            }

                                        }

                                        "0" -> break@loop2
                                        "h" -> println(menuQuadro)
                                        else -> println("Opção inválida.")

                                    }


                                }

                            }
                            //Novo Cartão
                            "4" ->{

                            }
                            //Cartões(???)
                            "6" ->{

                            }
                            "h" -> println(menuUsuario)

                            "0" -> break@loop1

                            else -> println("Opção inválida.")
                        }
                    }

                } else println("E-mail/Nome de usuário ou senha incorretos.")
            }

            "2" ->{

                println("Nome:")
                val nome = readLine()!!.toString()
                println("E-mail:")
                val email = readLine()!!.toString()
                println("Senha:")
                val senha = readLine()!!.toString()

                if (nome.trim() == "" || email.trim() == "" || senha.trim() == "") {

                    println("Dados inválidos. Tente novamente\n$menuLogin")
                } else {

                    trello.novoCadastro(nome, email, senha)
                    println("Usuário cadastrado com sucesso!" +
                            "\nSeu nome de usuário é ${trello.gerarUsername(nome)}\n")
                }
            }
            "0" -> break@loop

            else -> println("Opção inválida.")
        }

    }
}