package Model

class ContaDigital: ContaCorrente() {

    override fun saca(valor: Double): Boolean {
        return false
    }
}