package Model

class Quadro (var nome: String){

    var listas = arrayListOf<Lista>()

    fun novaLista(nome: String){
        val lista = Lista(nome)
        listas.add(lista)
    }
}
