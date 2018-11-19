package Model

class Cartao {

    lateinit var titulo: String
    lateinit var descricao: String
    var etiquetas = arrayListOf<Etiqueta>()
    var comentarios = arrayListOf<Comentario>()
}
