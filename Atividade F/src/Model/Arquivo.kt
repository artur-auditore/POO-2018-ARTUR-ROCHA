package Model

class Arquivo {

    var nome = ""
    var conteudo = ""

    var addStageArea = false
    var addRepRemoto = false
    var commits = arrayListOf<String>()
    var modificado = 0

    fun abrir(): String { //Apenas mostra o conteúdo
        return this.conteudo
    }

    fun editar(conteudo: String): Boolean {
        this.conteudo = conteudo
        return true
    }

    fun renomear(nome: String): Boolean {
        this.nome = nome
        return true
    }

    fun addStageArea(): Boolean {
        this.addStageArea = true
        return this.addStageArea
    }

    fun addRepRemoto(): Boolean{
        this.addRepRemoto = true
        return this.addRepRemoto
    }

    fun commit(commit: String){
        commits.add(commit)
    }

    fun modificado(){

        this.modificado++
    }

}