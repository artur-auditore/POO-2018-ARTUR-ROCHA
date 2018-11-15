package Service

class Urna{

    var eleições = arrayListOf<Eleição>()

    fun novaEleicao(titulo: String){

        val eleicao = Eleição()
        eleicao.titulo = titulo
        eleicao.abrirEleição()
        eleições.add(eleicao)
    }

    fun fecharEleicao(titulo: String){
        for (eleicao in eleições) if (titulo == eleicao.titulo)
            eleicao.fecharEleição()
    }

    fun obterTokens(): String {
        for (eleicao in eleições) if (eleicao.isOpen())
            return eleicao.obterTokens()
        return ""
    }

    fun distribuirTokens(qtdEleitores: Int) {
        for (eleicao in eleições) if (eleicao.isOpen())
            eleicao.distribuirTokens(qtdEleitores)
    }

    fun dadosEleicoes(): String{
        var dados = ""
        for (eleicao in eleições){
            dados += "${eleicao.titulo} -> estado: ${eleicao.estadoStringEleicao()}\n"
        }
        return dados
    }
}