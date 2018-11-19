package Model

class Quadro {

    lateinit var nome: String
    var listas = arrayListOf<Lista>()

    fun novaLista(nome: String){
        val lista = Lista(nome)
    }
}
