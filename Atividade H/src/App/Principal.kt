package App

import Service.Banco

fun main(args: Array<String>) {
    val banco = Banco()
    banco.nome = "Nubank"

    val menuPrincipal = "******** " + banco.nome + " ********" +
            "\nPara obter ajuda presione h" +
            "\n1 - Abrir Conta" +
            "\n2 - Depositar via Envelope" +
            "\n3 - Login" +
            "\n4 - Infomações de todas as contas" +
            "\n0 - Fechar\n"

    println(menuPrincipal)

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

                    if (tipo == 5){ //se a conta for do tipo capitalização irá retornar um inteiro

                        println("Para este tipo de conta você precisa escolher um valor" +
                                "\nfixo para depósito. Por favor, digite o valor:")
                        val depositoFixo = readLine()!!.toDouble()
                        banco.setDeposito(depositoFixo)

                        println("Você definiu o valor de depósito fixo para $depositoFixo reais.")
                    }

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
                    println("Depósito Realizado com sucesso.")
                } else {
                    println("Não é possível depositar.")
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
                        val opc: Int = readLine()!!.toInt()

                        //Sacar
                        if (opc == 1) {

                            print("Valor a sacar: ")
                            val valor: Double = readLine()!!.toDouble()
                            print("Senha: ")
                            val senhaConta: Int = readLine()!!.toInt()

                            if (banco.sacar(senhaConta, valor)) {
                                println("Saque realizado com sucesso.")
                                println(banco.saldoDisponivel())

                            } else {
                                println("Erro. Não foi possível realizar o saque.")
                            }

                        //Depositar
                        } else if (opc == 2) {
                            /*É possível depositar na conta digital via boleto, porém
                             não é especificado qual tipo de depósito*/

                            print("Valor a depositar: ")
                            val valor: Double = readLine()!!.toDouble()

                            if (banco.depositar(nConta, valor)) {
                                println("Depósito Realizado com sucesso.")
                                println(banco.saldoDisponivel())
                            } else {
                                println("Erro. Não foi possível depositar.")
                            }

                        //Transferir
                        } else if (opc == 3) {

                            print("Número da Conta a transferir: ")
                            val numeroConta: Int = readLine()!!.toInt()
                            print("Valor: ")
                            val valor: Double = readLine()!!.toDouble()

                            if (banco.transferir(numeroConta, valor)) {
                                println("Tranferência realizada com sucesso.")
                                println(banco.saldoDisponivel())

                            } else {

                                println("Erro. Não foi possível realizar a transferência.")
                            }

                        //Simular rendimento
                        }else if (opc == 4){

                            println("Simulação de Rendimento:" +
                                    "\nSaldo depois do rendimento: " + banco.render())

                            /*Aplica o rendimento
                             (é como se tivesse passado o tempo necessário para o saldo render)*/
                            println("Deseja aplicar o rendimento? (y/n)")
                            val aplica = readLine()!!.toString()
                            if (aplica == "y"){
                                println("Saldo atual: " + banco.aplicaRendimento())
                            }

                        //Imprime informações da Conta
                        } else if (opc == 5) {
                            println(banco.imprimeDados())

                        //Sair
                        } else if (opc == 6) {

                            banco.sair(nConta)
                            println(menuPrincipal)
                            break

                        //Ajuda
                        } else if(opc == 0){

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
                println(menuPrincipal)
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