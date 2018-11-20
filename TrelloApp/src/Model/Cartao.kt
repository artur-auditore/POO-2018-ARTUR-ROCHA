package Model

class Cartao(var titulo: String) {

    lateinit var descricao: String
    var arquivado = false
    var etiquetas = arrayListOf<Etiqueta>()
    var comentarios = arrayListOf<Comentario>()

    fun estaArquivado(): Boolean {
        return this.arquivado
    }
}
