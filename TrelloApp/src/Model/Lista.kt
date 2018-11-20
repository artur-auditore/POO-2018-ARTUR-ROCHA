package Model

class Lista(var nome: String){

    var cartoes = arrayListOf<Cartao>()
    var aberta = false

    fun abrirLista(){
        this.aberta = true
    }

    fun fecharLista(){
        this.aberta = false
    }

    fun isOpen(): Boolean {
        return this.aberta
    }

    fun novoCartao(titulo: String, descricao: String){
        val cartao = Cartao(titulo)
        cartao.descricao = descricao
        this.cartoes.add(cartao)
    }

    fun verCartoes(): String{
        var dados = ""
        for (cartao in this.cartoes) dados += "${cartao.titulo}\n"
        return dados
    }
}