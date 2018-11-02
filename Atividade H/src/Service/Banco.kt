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
            5 ->{
                val conta = ContaCapitalizacao()
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

        for (conta in contas){
            if (conta.numeroConta == numeroConta){
                return conta.deposita(valor)
            }
        }
        return false

    }

    fun sacar(senha: Int, valor: Double): Boolean{

        for (conta in contas){
            if (senha == conta.senha && valor > 0){
                return conta.saca(valor)
            }
        }
        return false
    }

    fun transferir(nContaRecebe: Int, valor: Double): Boolean {

        for (conta in contas){
            if (conta.isLogada()){
                conta.saldo -= valor
            }
        }

        for (conta in contas){
            if (nContaRecebe == conta.numeroConta){
               conta.saldo += valor
                return true
            }
        }
        return false
    }

    fun render(): Double {
        for (conta in contas)
            if (conta.isLogada())
                when (conta) {
                    is ContaPoupança -> return conta.simularRendimento()
                    is ContaInvestimento -> return conta.simularRendimento()
                    is ContaDigital -> return conta.simularRendimento()
                    is ContaCorrente -> return conta.simularRendimento()
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

    private fun gerarNumeroDaConta(): Int {

        val random = Random()
        return random.nextInt(9999 - 1111)
    }

    fun logarConta(numeroConta: Int, senha: Int): Boolean{

        for (conta in contas){
            if(conta.numeroConta == numeroConta && conta.senha == senha){
                conta.logarConta()
                return conta.isLogada()
            }
        }
        return false
    }

    fun sair(numeroConta: Int): Boolean{

        for (conta in contas){
            if (numeroConta == conta.numeroConta){
                return conta.logout()
            }
        }
        return true
    }

    fun setDeposito(deposito: Double){
        for (conta in contas)
            if (conta is ContaCapitalizacao)
                conta.depositoFixo = deposito
    }

    fun typeConta(): Int{
        for (conta in contas)
            when (conta){
                is ContaCorrente -> return 1
                is ContaPoupança -> return 2
                is ContaDigital -> return 3
                is ContaInvestimento -> return 4
                is ContaCapitalizacao -> return 5
            }
        return 0
    }

    fun aplicaRendimento(): Double {
        for (conta in contas)
            if (conta.isLogada())
                when(conta){
                    is ContaCorrente -> return conta.aplicaRendimento()
                    is ContaPoupança -> return conta.aplicaRendimento()
                    is ContaDigital -> return conta.aplicaRendimento()
                    is ContaInvestimento -> return conta.aplicaRendimento()
                }
        return 0.0
    }

    fun typeStringConta(): String {
        for (conta in contas)
            if (conta.isLogada())
                when(conta){
                    is ContaCorrente -> return "Conta corrente"
                    is ContaPoupança -> return "Conta poupança"
                    is ContaDigital -> return "Conta digital"
                    is ContaInvestimento -> return "Conta investimento"
                    is ContaCapitalizacao -> return "Conta capitalização"
            }
        return ""
    }

    fun saldoDisponivel(): String {
        for (conta in contas)
            if (conta.isLogada())
                "Saldo disponível: " + conta.saldo
        return ""
    }

    fun imprimeDados(): String{
        for (conta in contas)
            if (conta.isLogada())
                return conta.dados() + "\nTipo de Conta: " + typeStringConta()

        return ""
    }

    fun imprimeDadosArray(): String{
        var dados = ""
        for (conta in contas){
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