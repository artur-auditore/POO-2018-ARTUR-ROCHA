package Model

open class ContaPoupança: Conta(){

    open fun calculaRendimento(): Double {
        return this.saldo * 0.05
    }

    open fun simularRendimento(): Double{
        this.saldo += calculaRendimento()
        return this.saldo
    }
}