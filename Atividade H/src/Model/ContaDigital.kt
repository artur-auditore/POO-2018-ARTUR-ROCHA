package Model

class ContaDigital: ContaCorrente() {

    override fun calculaRendimento(): Double{
        return this.saldo * 0.03
    }

    override fun simularRendimento(): Double{
        var saldoSimulado = this.saldo
        saldoSimulado += this.calculaRendimento()
        return saldoSimulado
    }

    override fun deposita(valor: Double): Boolean {
        return false
    }

    override fun saca(valor: Double): Boolean {
        return false
    }

    override fun aplicaRendimento(): Double {
        this.saldo += calculaRendimento()
        return this.saldo
    }

}