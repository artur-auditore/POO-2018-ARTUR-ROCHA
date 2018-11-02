package Model

class ContaDigital: Conta() {

    fun calculaRendimento(): Double{
        return this.saldo * 0.03
    }

    fun simularRendimento(): Double{
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

    fun aplicaRendimento(): Double {
        this.saldo += calculaRendimento()
        return this.saldo
    }

}