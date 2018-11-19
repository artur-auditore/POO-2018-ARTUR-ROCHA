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

    fun abrirQuadro(titulo: String){
        for (quadro in this.quadros) if (quadro.nome == titulo){
            quadro.abrirQuadro()
        }
    }

    fun verQuadros():String{
        var dados = ""
        for (quadro in this.quadros) dados += "${quadro.nome}\n"
        return dados
    }

    fun novaLista(titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen())
            quadro.novaLista(titulo)
    }

    fun abrirLista(titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.abrirLista(titulo)
        }
    }

    fun verListas(): String{
        for (quadro in this.quadros) if (quadro.isOpen())
            return quadro.verListas()

        return ""
    }
}