package Model

class Cartao(var titulo: String) {

    lateinit var descricao: String
    var arquivado = false
    var aberto = false
    var etiquetas = arrayListOf<Etiqueta>()
    var comentarios = arrayListOf<String>()

    fun estaArquivado(): Boolean {
        return this.arquivado
    }

    fun abrir(){
        this.aberto = true
    }

    fun fechar(){
        this.aberto = false
    }

    fun isOpen(): Boolean {
        return this.aberto
    }
}
