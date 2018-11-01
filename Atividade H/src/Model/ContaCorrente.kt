
package Model

open class ContaCorrente: Conta(){

    override fun deposita(valor: Double): Boolean {
        this.saldo *= 0.999
        return super.deposita(valor)

    }

    fun calculaRendimento(): Double{
        return this.saldo * 0.005
    }

    //Conta corrente rende menos
    open fun simularRendimento(): Double{
        var saldoSimulado = this.saldo
        saldoSimulado += this.calculaRendimento()
        return saldoSimulado
    }

}