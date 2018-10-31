package Model

class ContaDigital: ContaCorrente() {

    fun calculaRendimento(){
        this.saldo = this.saldo + this.saldo * 0.08
    }
}