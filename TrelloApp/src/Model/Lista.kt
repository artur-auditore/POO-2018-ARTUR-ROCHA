package Model

class Lista(var nome: String){

    var cartoes = arrayListOf<Cartao>()
    var aberta = false
    var arquivada = false

    fun abrirLista(){
        this.aberta = true
    }

    fun fecharLista(){
        this.aberta = false
    }

    fun isOpen(): Boolean {
        return this.aberta
    }

    fun estaArquivada(): Boolean {
        return this.arquivada
    }

    fun novoCartao(titulo: String, descricao: String){
        val cartao = Cartao(titulo)
        cartao.descricao = descricao
        this.cartoes.add(cartao)
    }

    fun verCartoes(): String{
        var dados = ""
        for (cartao in this.cartoes) if (!cartao.estaArquivado()){
            dados += "${cartao.titulo}\n"
        }
        return dados
    }

    fun copiarCartao(titulo: String){
        var cartaoCopiado = Cartao(titulo)

        for (cartao in this.cartoes) if (cartao.titulo == titulo){
            cartaoCopiado = cartao
        }

        this.cartoes.add(cartaoCopiado)
    }

    fun arquivarCartao(titulo: String){
        for (cartao in this.cartoes) if (cartao.titulo == titulo){
            cartao.arquivado = true
        }
    }

    fun verCartoesArquivados(): String{
        var dados = ""
        for (cartao in this.cartoes) if (cartao.estaArquivado()){
            dados += "${cartao.titulo}\n"
        }

        return dados
    }

}