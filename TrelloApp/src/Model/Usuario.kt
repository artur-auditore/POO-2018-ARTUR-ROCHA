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

    fun fecharQuadro(){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.fecharQuadro()
        }
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

    fun copiarLista(titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.copiarLista(titulo)
        }
    }

    fun novoCartao(titulo: String, descricao: String){
        for (quadro in this.quadros) if (quadro.isOpen())
            quadro.novoCartao(titulo, descricao)
    }

    fun verCartoes(): String{
        for (quadro in this.quadros) if (quadro.isOpen()){
            return quadro.verCartoes()
        }

        return ""
    }

    fun copiarCartao(titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.copiarCartao(titulo)
        }
    }

    fun copiarCartao(titulo: String, nomeLista: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.copiarCartao(titulo, nomeLista)
        }
    }

    fun copiarCartao(titulo: String, nomeLista: String, nomeQuadro: String){
        val cartaoCopiado = Cartao(titulo)

        for (quadro in this.quadros) if (quadro.nome == nomeQuadro){
            for (lista in quadro.listas) if (lista.nome == nomeLista){
                lista.cartoes.add(cartaoCopiado)
            }
        }
    }

    fun fecharLista() {
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.fecharLista()
        }
    }
}