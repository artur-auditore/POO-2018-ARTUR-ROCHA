package Model

class Quadro (var nome: String){

    private var listas = arrayListOf<Lista>()
    var aberto = false

    fun abrirQuadro(){
        this.aberto = true
    }

    fun fecharQuadro(){
        this.aberto = false
    }

    fun isOpen(): Boolean {
        return this.aberto
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
        for (lista in this.listas) dados += "${lista.nome}\n"
        return dados
    }

    fun novoCartao(titulo: String, descricao: String){
        for (lista in this.listas) if (lista.isOpen()){
            lista.novoCartao(titulo, descricao)
        }
    }

    fun verCartoes(): String{
        
    }

    fun copiarLista(titulo: String){
        val listaCopiada = Lista(titulo)

        for (lista in this.listas) if (lista.nome == titulo){
            for (cartao in lista.cartoes) listaCopiada.cartoes.add(cartao)
        }

        this.listas.add(listaCopiada)
    }

}
