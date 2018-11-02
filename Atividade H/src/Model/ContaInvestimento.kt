package Model

class ContaInvestimento: ContaPoupança(){

    var prazo = false

    fun mudaPrazo(){
        this.prazo = true
    }

    fun chegouPrazo(): Boolean {
        return this.prazo
    }

    override fun saca(valor: Double): Boolean {
        return if (chegouPrazo()){
            super.saca(valor)
        } else{
            val perda = this.calculaRendimento() * 0.2
            this.saldo -= valor + perda
            true
        }

    }

    override fun calculaRendimento(): Double {
        return this.saldo * 0.02
    }

    override fun simularRendimento(): Double {
        var saldoSimulado = this.saldo
        saldoSimulado += calculaRendimento()
        return saldoSimulado
    }

    override fun aplicaRendimento(): Double {
        this.saldo += calculaRendimento()
        return this.saldo
    }
}