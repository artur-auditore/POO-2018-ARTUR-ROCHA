package Model

class Quadro (var nome: String){

    private var listas = arrayListOf<Lista>()

    fun novaLista(nome: String){
        val lista = Lista(nome)
        this.listas.add(lista)
    }
}
