package Model

open class Conta{

    var titular: Titular = Titular()
    var numeroConta: Int = 0
    var saldo: Double = 0.0
    var senha: Int = 0
    var logada: Boolean = false

    fun logarConta(): Boolean{
        this.logada = true
        return logada
    }

    fun logout(): Boolean{
        this.logada = false
        return logada
    }

    fun isLogada(): Boolean {
        return logada
    }

    open fun deposita(valor: Double): Boolean{

        return if (valor in 10.0..3000.0){

            this.saldo += valor
            true
        } else{

            false
        }
    }

    open fun saca(valor: Double): Boolean{

        return if (this.saldo > valor){

            this.saldo -= valor
            true

        } else{
            false
        }
    }

    open fun dados(): String {
        var dados = "Titular: " + this.titular.nome
        dados += "\nCPF: " + this.titular.cpf
        dados += "\nConta: " + this.numeroConta
        dados += "\nSaldo: " + this.saldo

        return dados

    }
}