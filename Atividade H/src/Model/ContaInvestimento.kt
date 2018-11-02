package Model

class ContaInvestimento: ContaPoupança(){

    var investimento = 0.0

    override fun calculaRendimento(): Double {
        return this.saldo * 0.07
    }

    override fun simularRendimento(): Double {
        var saldoSimulado = this.saldo
        saldoSimulado += calculaRendimento() + investimento
        return saldoSimulado
    }

    override fun aplicaRendimento(): Double {
        this.saldo += calculaRendimento()
        return this.saldo
    }
}