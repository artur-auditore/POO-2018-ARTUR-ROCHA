package Model

class Data(var dia: Int,
    var mes: Int,
    var ano: Int){

    fun impressaoData(): String{
        var dados = ""
        dados += "${this.dia}/${this.mes}/${this.ano}"

        return dados
    }

}
