package Model

open class ContaPoupança: Conta(){

    val qtdSaquesMax = 2
    var countSaques = 0


    open fun calculaRendimento(): Double {
        return this.saldo * 0.01
    }

    open fun simularRendimento(): Double{
        var saldoSimulado = this.saldo
        saldoSimulado += this.calculaRendimento()
        return saldoSimulado
    }

    open fun aplicaRendimento(): Double{
        this.saldo += calculaRendimento()
        return this.saldo
    }

    override fun saca(valor: Double): Boolean {
        this.countSaques ++

        return if (this.countSaques > this.qtdSaquesMax){
            this.saldo -= (this.saldo * 0.001)
            true
        } else {
            super.saca(valor)
        }
    }
}