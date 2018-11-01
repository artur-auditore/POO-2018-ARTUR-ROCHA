package Model

open class ContaPoupança: Conta(){

    open fun calculaRendimento(): Double {
        return this.saldo * 0.01
    }

    open fun simularRendimento(): Double{
        var saldoSimulado = this.saldo
        saldoSimulado += this.calculaRendimento()
        return saldoSimulado
    }
}