package Model

class Conta{
    var nomeTitular = ""
    var numero = 0
    var agencia = ""
    var saldo = 0.0
    var dataDeAbertura: Data? = null

    fun sacar(valor: Double):Boolean{
        return if (this.saldo > valor){
            this.saldo -= valor
            true
        } else false
    }

    fun deposita(valor: Double){ this.saldo += valor }

    fun calculaRendimento(): Double {return this.saldo * 0.1}

    fun recuperaDadosParaImpressao(): String {
        var dados = "Titular: ${this.nomeTitular}"
        dados += "\nNúmero: ${this.numero}"
        dados += "\nSaldo: ${this.saldo}"
        dados += "\nData: ${this.dataDeAbertura!!.impressaoData()}"
        return dados
    }

}