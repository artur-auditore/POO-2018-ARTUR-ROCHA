package Model

class RepositorioRemoto{

    var nome = ""
    var aberto = false
    var arquivos = arrayListOf<Arquivo>()

    fun abrir(): Boolean {
        this.aberto = true
        return aberto
    }

    fun verfificarVazio(): Boolean {
        for (arquivo: Arquivo in arquivos)
            if (arquivos.isEmpty()) {
                return true
            }
        return false
    }

    fun listar(): String {
        var dados = ""

        for (arquivo: Arquivo in arquivos){
            dados += "\n" + arquivo.nome
        }
        return dados
    }

}