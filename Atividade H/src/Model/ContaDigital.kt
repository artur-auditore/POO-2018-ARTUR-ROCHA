package Model

class ContaDigital: ContaCorrente() {

    override fun calculaRendimento(): Double{
        return this.saldo * 0.02
    }

    override fun simularRendimento(): Double{
        this.saldo += this.calculaRendimento()
        return this.saldo
    }

    override fun deposita(valor: Double): Boolean {
        return false
    }

    override fun saca(valor: Double): Boolean {
        return false
    }

}