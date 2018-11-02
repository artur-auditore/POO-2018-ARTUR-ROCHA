package Model

class ContaCapitalizacao: Conta(){

    var depositoFixo = 0.0
    var prazoEstabelecido = false

    fun mudaPrazo(){
        this.prazoEstabelecido = true
    }

    fun isInPrazo(): Boolean {
        return this.prazoEstabelecido
    }

    override fun deposita(valor: Double): Boolean {
        return if (valor == this.depositoFixo){
            super.deposita(valor)
        } else{
            false
        }
    }

}