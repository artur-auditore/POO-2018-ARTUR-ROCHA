package App

import Service.Banco
import Model.Conta

fun main(args: Array<String>) {
    val banco = Banco()
    banco.nome = "Nubank"

    val menu = "******** " + banco.nome + " ********" +
            "\nPara obter ajuda presione h" +
            "\n1 - Abrir Conta" +
            "\n2 - Depositar via Envelope" +
            "\n3 - Login" +
            "\n4 - Infomações de todas as contas" +
            "\n0 - Fechar\n"

    println(menu)

    loop@ while (true) {
        print("Opção: ")
        val op = readLine()!!.toString()

        when (op) {

            //Abrir Conta
            "1" -> {

                print("CPF: ")
                val cpf: String = readLine()!!.toString()
                print("Nome: ")
                val nome: String = readLine()!!.toString()
                print("Senha: ")
                val senha: Int = readLine()!!.toInt()
                print("Confirme a senha: ")
                val confirmSenha: Int = readLine()!!.toInt()

                if (senha == confirmSenha) {
                    println("Qual tipo de Conta deseja criar? " +
                            "\n1 - Conta Corrente" +
                            "\n2 - Conta Poupança" +
                            "\n3 - Conta Digital" +
                            "\n4 - Conta Investimento" +
                            "\n5 - Conta Capitalização")

                    val tipo = readLine()!!.toInt()

                    banco.novaConta(tipo, nome, cpf, senha)
                    println("Conta criada com sucesso\n" +
                            "Numero de sua conta: " + banco.obterNumConta())

                } else {
                    println("Dados Inválidos. Tente Novamente.\n")
                }

            }

            //Depósito via envelope
            "2" -> {

                print("Número da Conta: ")
                val nConta: Int = readLine()!!.toInt()
                print("Valor: ")
                val valor: Double = readLine()!!.toDouble()

                if (banco.depositar(nConta, valor)) {
                    println("Depósito Realizado com sucesso.\n")
                } else {
                    println("Erro. Tente Novamente\n")
                }
            }

            //Login
            "3" -> {

                print("Número da Conta: ")
                val nConta: Int = readLine()!!.toInt()
                print("Senha: ")
                val senha: Int = readLine()!!.toInt()

                if (banco.logarConta(nConta, senha)) {

                    val menu = "Operações: " +
                            "\n1 - Saque" +
                            "\n2 - Depósito" +
                            "\n3 - Transferência" +
                            "\n4 - Simulação de Rendimento" +
                            "\n5 - Informações da Conta" +
                            "\n6 - Sair" +
                            "\n0 - Ajuda"

                    println(menu)
                    while (true) {
                        print("Opção: ")
                        val op: Int = readLine()!!.toInt()

                        //Sacar
                        if (op == 1) {
                            if (banco.typeBoolConta()){
                                println("Conta digital. Impossível sacar.")
                            } else {

                                print("Valor a sacar: ")
                                val valor: Double = readLine()!!.toDouble()
                                print("Senha: ")
                                val senha: Int = readLine()!!.toInt()

                                if (banco.sacar(senha, valor)) {
                                    println("Saque realizado com sucesso.")
                                    println(banco.saldoDisponivel(senha))

                                } else {
                                    println("Erro. Tente novamente.")
                                }
                            }

                        //Depositar
                        } else if (op == 2) {
                            /*É possível depositar na conta digital via boleto, porém
                             não é especificado qual tipo de depósito*/

                            print("Valor a depositar: ")
                            val valor: Double = readLine()!!.toDouble()

                            if (banco.depositar(nConta, valor)) {
                                println("Depósito Realizado com sucesso.\n")
                            } else {
                                println("Erro. Tente Novamente\n")
                            }

                        //Transferir
                        } else if (op == 3) {

                            print("Número da Conta a transferir: ")
                            val nConta: Int = readLine()!!.toInt()
                            print("Valor: ")
                            val valor: Double = readLine()!!.toDouble()

                            if (banco.transferir(banco.obterNumConta(), nConta, valor)) {
                                println("Tranferência realizada com sucesso.")

                            } else {

                                println("Erro. Tente Novamente.")
                            }

                        //Simular rendimento
                        }else if (op == 4){
                            println("Simulação de Rendimento:" +
                                    "\nSaldo depois do rendimento: " + banco.render())

                        //Imprime informações da Conta
                        } else if (op == 5) {
                            println(banco.imprimeDados())

                        //Sair
                        } else if (op == 6) {

                            banco.sair(nConta)
                            break

                        //Ajuda
                        } else if(op == 0){

                            println(menu)
                        } else{

                            println("Opção inválida! Tente novamente.")
                        }
                    }

                } else {
                    println("Número da Conta ou senha inválidos. Tente novamente.")
                }
            }

            //Apenas para conferência
            "4" -> {
                val senhaInfo = "contas"
                println("Senha: ")
                val senha: String = readLine()!!.toString()

                if (senha == senhaInfo) {
                    println("Contas registradas: " + banco.contas.size)
                    println(banco.imprimeDadosArray())
                }
            }

            //Ajuda
            "h" ->{
                println(menu)
            }

            //Encerra o programa
            "0" -> {
                println("Encerrado.")
                break@loop

            }
            else -> {

                println("Opção Inválida. Tente novamente.")
            }
        }
    }
}