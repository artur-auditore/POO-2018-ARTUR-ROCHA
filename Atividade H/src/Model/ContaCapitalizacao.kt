package Model

open class ContaCapitalizacao: Conta(){

    var depositoFixo = 0.0
    var prazoEstabelecido = false
    var qtdSaques = 1

    fun mudaPrazo(){
        this.prazoEstabelecido = true
    }

    fun isInPrazo(): Boolean {

        return this.prazoEstabelecido
    }

    override fun saca(valor: Double): Boolean {

        return if (this.qtdSaques < 0 && isInPrazo()) super.saca(valor) else false
    }

    override fun deposita(valor: Double): Boolean {
        return if (valor == this.depositoFixo){
            super.deposita(valor)
        } else{
            false
        }
    }

    fun calculaRendimento(): Double {
        return this.saldo * 0.01
    }

    fun simularRendimento(): Double{
        var saldoSimulado = this.saldo
        saldoSimulado += this.calculaRendimento()
        return saldoSimulado
    }

    fun aplicaRendimento(): Double{
        this.saldo += calculaRendimento()
        return this.saldo
    }
}