package Service
import Model.*
import java.util.Random

class Banco{
    var nome: String = ""
    var contas = arrayListOf<Conta>()

    fun novaConta(opcao: Int, nomeTitular: String, cpfTitular: String, senha: Int) {

        when (opcao) {
            1 ->{
                val conta = ContaCorrente()
                conta.titular.nome = nomeTitular
                conta.titular.cpf = cpfTitular
                conta.senha = senha
                conta.saldo = 0.0
                conta.numeroConta = gerarNumeroDaConta()
                contas.add(conta)
            }
            2 ->{
                val conta = ContaPoupança()
                conta.titular.nome = nomeTitular
                conta.titular.cpf = cpfTitular
                conta.senha = senha
                conta.saldo = 0.0
                conta.numeroConta = gerarNumeroDaConta()
                contas.add(conta)
            }
            3 ->{
                val conta = ContaDigital()
                conta.titular.nome = nomeTitular
                conta.titular.cpf = cpfTitular
                conta.senha = senha
                conta.saldo = 0.0
                conta.numeroConta = gerarNumeroDaConta()
                contas.add(conta)
            }
            4 ->{
                val conta = ContaInvestimento()
                conta.titular.nome = nomeTitular
                conta.titular.cpf = cpfTitular
                conta.senha = senha
                conta.saldo = 0.0
                conta.numeroConta = gerarNumeroDaConta()
                contas.add(conta)
            }
        }
    }

    fun depositar(numeroConta: Int, valor: Double): Boolean {

        for (conta: Conta in contas){
            if (conta.numeroConta == numeroConta){
                return conta.deposita(valor)
            }
        }
        return false

    }

    fun sacar(senha: Int, valor: Double): Boolean{

        for (conta: Conta in contas){
            if (senha == conta.senha && valor > 0){
                return conta.saca(valor)
            }
        }
        return false
    }

    fun transferir(nContaTransfere: Int, nContaRecebe: Int, valor: Double): Boolean {

        for (conta: Conta in contas){
            if (nContaTransfere == conta.numeroConta){
                conta.saldo -= valor
            }
        }

        for (conta: Conta in contas){
            if (nContaRecebe == conta.numeroConta){
               return conta.deposita(valor)
            }
        }
        return false
    }

    fun render(): Double {
        for (conta in contas)
            if (conta.isLogada())
                when (conta){
                    is ContaPoupança -> return conta.simularRendimento()
                    is ContaInvestimento -> return conta.simularRendimento()
                }
        return 0.0
    }

    fun obterNumConta(): Int {

        return if (contas.size == 1){
            contas[0].numeroConta
        } else{

            contas[contas.size - 1].numeroConta
        }

    }

    fun gerarNumeroDaConta(): Int {

        val random = Random()
        return random.nextInt(9999 - 1111)
    }

    fun logarConta(numeroConta: Int, senha: Int): Boolean{

        for (conta: Conta in contas){
            if(conta.numeroConta == numeroConta && conta.senha == senha){
                conta.logarConta()
                return conta.isLogada()
            }
        }
        return false
    }

    fun sair(numeroConta: Int): Boolean{

        for (conta: Conta in contas){
            if (numeroConta == conta.numeroConta){
                return conta.logout()
            }
        }
        return true
    }

    fun imprimeDados(): String{
        for (conta: Conta in contas){
            if (conta.isLogada()){
                return conta.dados()
            }
        }
        return ""
    }

    fun imprimeDadosArray(): String{
        var dados = ""
        for (conta: Conta in contas){
            dados += "Titular: " + conta.titular.nome
            dados += "\nCPF: " + conta.titular.cpf
            dados += "\nSenha: " + conta.senha
            dados += "\nConta: " + conta.numeroConta
            dados += "\nSaldo: " + conta.saldo
            dados += "\nEstado: " + conta.logada + "\n"
        }
        return dados
    }
}