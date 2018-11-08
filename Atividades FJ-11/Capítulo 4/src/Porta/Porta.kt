package Porta

class Porta{
    var aberta = false
    var cor = ""
    var dimensaoX = 0
    var dimensaoY = 0
    var dimensaoZ = 0


    fun abre() {
        this.aberta = true
    }

    fun fecha(){
        this.aberta = false
    }

    fun estaAberta(): Boolean{
        return this.aberta
    }

    fun pinta(cor: String){
        this.cor = cor
    }
}