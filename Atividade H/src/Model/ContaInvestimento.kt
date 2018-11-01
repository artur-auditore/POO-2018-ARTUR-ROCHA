package Model

class ContaInvestimento: ContaPoupança(){

    var investimento = 0.0

    override fun calculaRendimento(): Double {
        return this.saldo * 0.07
    }

    override fun simularRendimento(): Double {
        this.saldo += calculaRendimento() + investimento
        return this.saldo
    }
}