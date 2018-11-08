package Casa

import Porta.Porta


class Casa{
    var cor = ""
    var porta1 = Porta()
    var porta2 = Porta()
    var porta3 = Porta()

    fun pinta(cor: String){
        this.cor = cor
    }

    fun quantidadeDePortasAbertas(): Int {
        var count: Int = 0
        if (this.porta1.estaAberta()) count++
        if (this.porta2.estaAberta()) count++
        if (this.porta3.estaAberta()) count++

        return count
    }
}