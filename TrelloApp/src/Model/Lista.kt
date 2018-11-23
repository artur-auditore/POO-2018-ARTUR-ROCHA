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

    //Métodos referentes a cartão

    fun novoCartao(titulo: String, descricao: String){
        val cartao = Cartao(titulo)
        cartao.descricao = descricao
        this.cartoes.add(cartao)
    }

    fun verCartoes(): String{
        var dados = ""
        for (i in 0 until  this.cartoes.size) if (!this.cartoes[i].estaArquivado()){
            dados += "$i. ${this.cartoes[i].titulo}\n"
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

    fun moverCartao(titulo: String){
        var cartaoCopiado = Cartao(titulo)

        for (cartao in this.cartoes) if (cartao.titulo == titulo){
            cartaoCopiado = cartao
            this.cartoes.remove(cartao)
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
        for (i in 0 until  this.cartoes.size) if (this.cartoes[i].estaArquivado()){
            dados += "$i. ${this.cartoes[i].titulo}\n"
        }

        return dados
    }

    fun renomearCartao(titulo: String, novoTitulo: String){
        for (cartao in this.cartoes) if (cartao.titulo == titulo){
            cartao.titulo = novoTitulo
        }
    }

    fun abrirCartao(titulo: String){
        for (cartao in this.cartoes) if (cartao.titulo == titulo){
            cartao.abrir()
        }
    }

    fun fecharCartao(){
        for (cartao in this.cartoes) if (cartao.isOpen()){
            cartao.fechar()
        }
    }

    //Métodos referentes a comentários

}