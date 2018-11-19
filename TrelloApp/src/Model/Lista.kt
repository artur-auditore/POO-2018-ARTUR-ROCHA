package Model

class Lista(var nome: String){

    var cartoes = arrayListOf<Cartao>()

    fun novoCartao(titulo: String, descricao: String){
        val cartao = Cartao(titulo)
        cartao.descricao = descricao
        this.cartoes.add(cartao)
    }
}