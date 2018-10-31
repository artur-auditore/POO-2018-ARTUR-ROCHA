
package Model

open class ContaCorrente: Conta(){

    override fun deposita(valor: Double): Boolean {
        this.saldo *= 0.99
        return super.deposita(valor)

    }


}