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

    fun verComentarios(): String{
        var dados = ""
        for (i in 0 until this.comentarios.size){
            dados += "${i+1}. ${this.comentarios[i]}\n"
        }
        return dados
    }

    fun definirEtiqueta(cor: String, descricao: String){
        val etiqueta = Etiqueta(cor, descricao)
        this.etiquetas.add(etiqueta)
    }

    fun verEtiquetasDoCartao(): String{
        var dados = ""
        for (i in 0 until this.etiquetas.size){
            dados += "${i+1}. ${this.etiquetas[i].cor}"
        }

        return dados
    }
}
