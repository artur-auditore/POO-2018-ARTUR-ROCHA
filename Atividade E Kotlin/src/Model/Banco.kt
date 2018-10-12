package Model
import java.util.Random

class Banco{
    var nome: String = ""
    var contas = arrayListOf<Conta>()

    fun novaConta(nomeTitular: String, cpfTitular: String, senha: Int) {

        val conta = Conta()
        conta.titular.nome = nomeTitular
        conta.titular.cpf = cpfTitular
        conta.senha = senha
        conta.saldo = 0.0
        conta.numeroConta = gerarNumeroDaConta()

        contas.add(conta)

    }

    fun depositar(numeroConta: Int, valor: Double): Boolean {

        for (conta: Conta in contas){
            if (conta.numeroConta == numeroConta){
                return conta.deposita(valor)
            }
        }
        return false
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
                return conta.logarConta()
            }
        }
        return false
    }

    fun validarSaque(senha: Int, valor: Double): Boolean{

        for (conta: Conta in contas){
            if (senha == conta.senha && conta.isLogada() && valor > 0){
                return conta.saca(valor)
            }
        }
        return false
    }

    fun transferir(nConta: Int, valor: Double): Boolean {

        for (conta: Conta in contas){
            if (nConta == conta.numeroConta){

            }
        }
        return false
    }

    fun imprimeDados(): String{
        for (conta: Conta in contas){
            if (conta.isLogada()){
                return conta.dados()
            }
        }
        return ""
    }
}
