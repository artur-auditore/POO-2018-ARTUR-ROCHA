package Model

class Quadro (var nome: String){

    var listas = arrayListOf<Lista>()
    var aberto = false
    var arquivado = false

    fun abrirQuadro(){
        this.aberto = true
    }

    fun fecharQuadro(){
        this.aberto = false
    }

    fun isOpen(): Boolean {
        return this.aberto
    }

    fun estaArquivado(): Boolean {
        return this.arquivado
    }

    fun novaLista(nome: String){
        val lista = Lista(nome)
        this.listas.add(lista)
    }

    fun abrirLista(nome: String){
        for (lista in this.listas) if (lista.nome == nome){
            lista.abrirLista()
        }
    }

    fun verListas():String{
        var dados = ""
        for (lista in this.listas) if (!lista.estaArquivada()){
            dados += "${lista.nome}\n"
        }
        return dados
    }

    fun fecharLista(){
        for (lista in this.listas) if (lista.isOpen()){
            lista.fecharLista()
        }
    }

    fun arquivarLista(titulo: String){
        for (lista in this.listas) if (lista.nome == titulo){
            lista.arquivada = true
        }
    }

    fun verListasArquivadas(): String {
        var dados = ""
        for (lista in this.listas) if (lista.estaArquivada()){
            dados += "${lista.nome}\n"
        }
        return dados
    }

    fun renomearLista(titulo: String, novoTitulo: String){
        for (lista in this.listas) if (lista.nome == titulo){
            lista.nome = novoTitulo
        }
    }

    fun novoCartao(titulo: String, descricao: String){
        for (lista in this.listas) if (lista.isOpen()){
            lista.novoCartao(titulo, descricao)
        }
    }

    fun verCartoes(): String{
        for (lista in this.listas) if (lista.isOpen()){
            return lista.verCartoes()
        }

        return ""
    }

    fun copiarCartao(titulo: String){
        for (lista in this.listas) if (lista.isOpen()){
            lista.copiarCartao(titulo)
        }
    }

    fun copiarCartao(titulo: String, nomeLista: String){

        for (lista in this.listas) if (lista.nome == nomeLista){
            lista.copiarCartao(titulo)
        }

    }

    fun arquivarCartao(titulo: String){
        for (lista in this.listas) if (lista.isOpen()){
            lista.arquivarCartao(titulo)
        }
    }

    fun verCartoesArquivados(): String{
        for (lista in this.listas) if (lista.isOpen()){
            return lista.verCartoesArquivados()
        }

        return ""
    }

    fun copiarLista(titulo: String){
        val listaCopiada = Lista(titulo)

        for (lista in this.listas) if (lista.nome == titulo){
            for (cartao in lista.cartoes) listaCopiada.cartoes.add(cartao)
        }

        this.listas.add(listaCopiada)
    }

}
