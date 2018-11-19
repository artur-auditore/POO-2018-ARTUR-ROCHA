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
                            "\n3. Nova Lista" +
                            "\n4. Novo Cartão" +
                            "\n5. Abrir Cartão" +
                            "\n6. Cartões" +
                            "\n0. Sair" +
                            "Para obter ajuda pressione h"

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
                            //Nova Lista
                            "3" ->{

                                println("Título:")
                                val titulo = readLine()!!.toString()
                                println("Para qual quadro deseja adicionar?")
                                println(trello.verQuadros())
                                val tituloQuadro = readLine()!!.toString()

                                if (titulo.trim() == ""){
                                    println("Título inválido. Tente novamente.")
                                } else{
                                    trello.novaLista(titulo, tituloQuadro)
                                }
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