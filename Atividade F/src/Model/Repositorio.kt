package Model

class Repositorio{

    var nome = ""
    var aberto = false
    val arquivos = arrayListOf<Arquivo>()

    fun abrir(): Boolean{
        this.aberto = true
        return this.aberto
    }

    fun fechar(): Boolean{
        if (abrir())
            this.aberto = false
        return this.aberto
    }

    fun isAberto(): Boolean {
        if (this.aberto)
            return true
        return false
    }

    fun novoArquivo(nome: String, conteudo: String){

        val arquivo = Arquivo()
        arquivo.nome = nome
        arquivo.conteudo = conteudo

        arquivos.add(arquivo)
    }

    fun abrir(nome: String): String {
        var conteudo = ""
        for (arquivo: Arquivo in arquivos)
            if (arquivo.nome == nome) {
                conteudo = arquivo.mostrarConteudo()
            }

        return conteudo
    }

    fun renomear(nome: String, novoNome: String){

        for (arquivo: Arquivo in arquivos) if (arquivo.nome == nome){
            arquivo.renomear(novoNome)
            arquivo.modificado()
        }

    }

    fun excluir(nome: String){ //todo não esquecer
        for (arquivo: Arquivo in arquivos)
            if (arquivo.nome == nome){
                arquivos.remove(arquivo)
            }
    }

    fun excluirTudo(){
        for (arquivo: Arquivo in arquivos)
            arquivos.remove(arquivo)
    }

    fun editar(nome: String, novoConteudo: String){
        for (arquivo: Arquivo in arquivos)
            if (arquivo.nome == nome)
                arquivo.editar(novoConteudo)
    }

    fun commitar(texto: String){
        for (arquivo: Arquivo in arquivos)
            if (arquivo.addStageArea)
                arquivo.commit(texto)
    }

    fun listarArquivos(): String {
        var dados = ""
        for (arquivo: Arquivo in arquivos){
            dados += "\n" + arquivo.nome
        }

        return dados
    }

    fun addStageArea(nome: String){
        for (arquivo: Arquivo in arquivos)
            if (arquivo.nome == nome)
                arquivo.addStageArea()
    }

    fun addAllStageArea(){
        for (arquivo: Arquivo in arquivos)
            arquivo.addStageArea()
    }

    fun status(){
        //todo fazer metodo status
    }

}
