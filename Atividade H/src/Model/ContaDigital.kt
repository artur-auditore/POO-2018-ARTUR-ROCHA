package Model

class ContaDigital: ContaCorrente() {

    fun calculoRendimento(): Double{
        return this.saldo * 0.02
    }

    override fun simularRendimento(): Double{
        this.saldo += this.calculoRendimento()
        return this.saldo
    }

}