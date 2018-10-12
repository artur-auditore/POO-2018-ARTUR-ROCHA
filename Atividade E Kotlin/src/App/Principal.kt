package App

import Model.Banco
import Model.Conta

fun main(args: Array<String>) {
    val banco = Banco()
    banco.nome = "Nubank"

    val menu = "*** BANCO ***" +
            "\n1 - Abrir Conta" +
            "\n2 - Depositar via Envelope" +
            "\n3 - Login" +
            "\n0 - Fechar\n"

    while (true){
        println(menu)
        val op: Int = readLine()!!.toInt()

        if (op == 1){
            println("CPF: ")
            val cpf: String = readLine()!!.toString()
            println("Nome: ")
            val nome: String = readLine()!!.toString()
            println("Senha: ")
            val senha: Int = readLine()!!.toInt()
            println("Confirme a senha: ")
            val confirmSenha: Int = readLine()!!.toInt()

            if (senha == confirmSenha){
                banco.novaConta(nome, cpf, senha)
                println("Conta criada com sucesso\n" +
                        "Numero de sua conta: " + banco.obterNumConta())

                println("Contas: " + banco.contas.size)



            } else{
                println("Dados Inválidos. Tente Novamente.\n")
            }

        } else if (op == 2){

            println("Número da Conta: ")
            val nConta: Int = readLine()!!.toInt()
            println("Valor: ")
            val valor: Double = readLine()!!.toDouble()

            if (banco.depositar(nConta, valor)){
                println("Depósito Realizado com sucesso.\n")
            } else{
                println("Erro. Tente Novamente\n")
            }

        } else if (op == 3){

            println("Número da Conta: ")
            val nConta: Int = readLine()!!.toInt()
            println("Senha: ")
            val senha: Int = readLine()!!.toInt()


            if (banco.logarConta(nConta, senha)){

                val menu = "Operações: " +
                        "\n1 - Saque" +
                        "\n2 - Depósito" +
                        "\n3 - Transferência" +
                        "\n4 - Informações da Conta"+
                        "\n5 - Sair"

                while (true){

                    println(menu)
                    val op: Int = readLine()!!.toInt()

                    //Sacar
                    if (op == 1){

                        println("Valor a sacar: ")
                        val valor: Double = readLine()!!.toDouble()
                        println("Senha: ")
                        val senha: Int = readLine()!!.toInt()

                        if (banco.validarSaque(senha, valor)){
                            println("Saque realizado com sucesso.")

                            for (conta: Conta in banco.contas){
                                if (senha == conta.senha){
                                    println("Saldo disponível: " + conta.saldo)
                                }
                            }

                        } else {
                            println("Erro. Tente novamente.")
                        }

                    //Depositar
                    } else if (op == 2){

                        println("Valor a depositar: ")
                        var valor: Double = readLine()!!.toDouble()

                        if (banco.depositar(nConta, valor)){
                            println("Depósito Realizado com sucesso.\n")
                        } else{
                            println("Erro. Tente Novamente\n")
                        }

                    //Transferir
                    } else if (op == 3){

                        println("Número da Conta a transferir: ")
                        var nConta: Int = readLine()!!.toInt()
                        println("Valor: ")
                        var valor: Double = readLine()!!.toDouble()

                        if (banco.transferir(nConta, valor)){
                        }

                    //Mostrar Informações da Conta
                    } else if (op == 4){
                        println(banco.imprimeDados())

                    //Sair
                    } else if(op == 5){
                        break
                    }
                }
            }else {
                println("Número da Conta ou senha inválidos. Tente novamente.")
            }

        } else if(op == 0){
            break

        } else{

            println("Opção Inválida. Tente novamente")
        }
    }
}