package Model

open class ContaPoupança: Conta(){

    fun calculaRendimento(){
        this.saldo = this.saldo + this.saldo * 0.05
    }
}