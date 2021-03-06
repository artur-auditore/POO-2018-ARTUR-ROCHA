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

    //Métodos referentes a listas

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
        for (i in 0 until this.listas.size) if (!this.listas[i].estaArquivada()){
            dados += "${i+1}. ${this.listas[i].nome}\n"
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
        for (i in 0 until this.listas.size) if (this.listas[i].estaArquivada()){
            dados += "${i+1}. ${this.listas[i].nome}\n"
        }
        return dados
    }

    fun renomearLista(titulo: String, novoTitulo: String){
        for (lista in this.listas) if (lista.nome == titulo){
            lista.nome = novoTitulo
        }
    }

    fun copiarLista(titulo: String){
        val listaCopiada = Lista(titulo)

        for (lista in this.listas) if (lista.nome == titulo){
            for (cartao in lista.cartoes) listaCopiada.cartoes.add(cartao)
        }

        this.listas.add(listaCopiada)
    }

    fun moverLista(titulo: String, posicao: Int){
        val listTemp = arrayListOf<Lista>()

        for (lista in this.listas) if (lista.nome == titulo){
            listTemp.add(lista)
            this.listas.remove(lista)
        }
        //não funciona ainda
        for (i in posicao downTo 0)
            this.listas[i+1] = this.listas[i]
        this.listas[posicao] = listTemp[0]
    }

    //Métodos referentes a cartões

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

    fun moverCartao(titulo: String, tituloLista: String){
        for (lista in this.listas) if (lista.nome == tituloLista){
            lista.moverCartao(titulo)
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

    fun renomearCartao(titulo: String, novoTitulo: String){
        for (lista in this.listas) if (lista.isOpen()){
            lista.renomearCartao(titulo, novoTitulo)
        }
    }

    fun abrirCartao(titulo: String){
        for (lista in this.listas) if (lista.isOpen()){
            lista.abrirCartao(titulo)
        }
    }

    fun addOrChangeDescription(descricao: String){
        for (lista in this.listas) if (lista.isOpen()){
            lista.addOrChangeDescription(descricao)
        }
    }

    fun fecharCartao(){
        for (lista in this.listas) if (lista.isOpen()){
            lista.fecharCartao()
        }
    }

    //Referente a comentarios

    fun comentar(cometario: String){
        for (lista in this.listas) if (lista.isOpen()){
            lista.comentar(cometario)
        }
    }

    fun editarComentario(comentario: String, novoComentario: String){
        for (lista in this.listas) if (lista.isOpen()){
            lista.editarComentario(comentario, novoComentario)
        }
    }

    fun excluirComentario(comentario: String){
        for (lista in this.listas) if (lista.isOpen()){
            lista.excluirComentario(comentario)
        }
    }

    fun verComentarios(): String{
        for (lista in this.listas) if (lista.isOpen()){
            return lista.verComentarios()
        }

        return ""
    }

    //Métodos para etiquetas

    fun definirEtiqueta(cor: String, descricao: String){
        for (lista in this.listas) if (lista.isOpen()){
            lista.definirEtiquetas(cor, descricao)
        }
    }

    fun excluirEtiqueta(etiqueta: String, titulo: String){
        for (lista in this.listas) if (lista.isOpen()){
            lista.excluirEtiqueta(etiqueta, titulo)
        }
    }
}
