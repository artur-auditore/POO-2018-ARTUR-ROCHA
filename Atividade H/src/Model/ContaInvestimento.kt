package Model

class ContaInvestimento: Conta(){

    var prazoEstabelecido = false

    fun mudaPrazo(){
        this.prazoEstabelecido = true
    }

    fun isInPrazo(): Boolean {
        return this.prazoEstabelecido
    }

    override fun saca(valor: Double): Boolean {
        return if (isInPrazo()){
            super.saca(valor)
        } else{
            val perda = this.calculaRendimento() * 0.2
            this.saldo -= valor + perda
            true
        }

    }

    fun calculaRendimento(): Double {
        return this.saldo * 0.02
    }

    fun simularRendimento(): Double {
        var saldoSimulado = this.saldo
        saldoSimulado += calculaRendimento()
        return saldoSimulado
    }

    fun aplicaRendimento(): Double {
        this.saldo += calculaRendimento()
        return this.saldo
    }
}