package Service

import Model.Eleitor
import Model.Pergunta
import java.util.*

class Eleição{

    lateinit var titulo: String
    var aberta = false
    var perguntas = arrayListOf<Pergunta>()
    var eleitores = arrayListOf<Eleitor>()

    fun abrirEleição(){
        this.aberta = true
    }

    fun fecharEleição(){
        this.aberta = false
    }

    fun isOpen(): Boolean {
        return this.aberta
    }

    fun distribuirTokens(qtdEleitores: Int){

        for (i in 1..qtdEleitores) {
            val eleitor = Eleitor()
            eleitores.add(eleitor)
        }

        for (eleitor in eleitores)
            eleitor.token = gerarTokens()
    }

    fun obterTokens(): String{
        var tokens = ""
        for (eleitor in eleitores)
            tokens += "${eleitor.verToken()}\n"

        return tokens
    }

    fun gerarTokens(): Int {
        val ramdom = Random()
        return ramdom.nextInt(9999 - 1111)
    }

    fun estadoStringEleicao(): String {
        return if (isOpen()) "aberta" else "encerrada"
    }

}