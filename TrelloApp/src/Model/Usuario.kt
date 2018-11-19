package Model

class Usuario(var nome: String,
    var email: String,
    var senha: String){

    constructor() : this("", "", "")

    lateinit var username: String
    var logado = false
    var quadros = arrayListOf<Quadro>()

    fun logar(): Boolean {
        this.logado = true
        return true
    }

    fun logout (){
        this.logado = false
    }

    fun isLogged(): Boolean{
        return this.logado
    }

    fun novoQuadro(titulo: String){
        val quadro = Quadro(titulo)
        this.quadros.add(quadro)
    }

    fun verQuadros():String{
        for (quadro in this.quadros) return "${quadro.nome}\n"
        return ""
    }

    fun novaLista(titulo: String, tituloQuadro: String){
        for (quadro in this.quadros) if (quadro.nome == tituloQuadro)
            quadro.novaLista(titulo)
    }
}