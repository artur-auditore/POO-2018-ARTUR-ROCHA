package Model

class Git{

    val repositorios = arrayListOf<Repositorio>()
    val pasta = arrayListOf<Arquivo>()
    val repositorioRemoto = RepositorioRemoto()

    fun novoRepositorio(nome: String){
        val repositorio = Repositorio()
        repositorio.nome = nome
        repositorios.add(repositorio)
    }

    fun abrirRepositorio(nome: String): Boolean{
        for (repositorio: Repositorio in repositorios){
            if (repositorio.nome == nome){
                repositorio.abrir()
                return true
            }
        }
        return false
    }

    fun fecharRepositorio(){
        for (repositorio: Repositorio in repositorios)
            if (repositorio.isAberto())
                repositorio.fechar()
    }

    fun verfificarVazio(): Boolean {
        for (repostorio: Repositorio in repositorios)
            if (repostorio.arquivos.isEmpty()) {
                return true
            }
        return false
    }

    fun listarRepositorios(): String {
        var dados = ""
        for (rep: Repositorio in repositorios){
            dados += rep.nome + "\n"
        }
        return dados
    }

    fun novoArquivo(nome: String, conteudo: String){

        for (repositorio: Repositorio in repositorios)
            if (repositorio.isAberto()) repositorio.novoArquivo(nome, conteudo)
    }

    fun renomear(nome: String, novoNome: String){

        for (repositorio: Repositorio in repositorios)
            if (repositorio.isAberto()) repositorio.renomear(nome, novoNome)
    }

    fun abrir(nome: String): String{
        for (repositorio: Repositorio in repositorios)
            if (repositorio.isAberto()) return repositorio.abrir(nome)
        return ""
    }

    fun editar(nome: String, conteudo: String){
        for (repositorio: Repositorio in repositorios)
            if (repositorio.isAberto()) repositorio.editar(nome, conteudo)

    }

    fun excluir(nome: String){

        for (repositorio: Repositorio in repositorios) if (repositorio.isAberto()){
                return repositorio.excluir(nome)
            }
    }


    fun addStageArea(nome: String): Boolean {
        for (arquivo: Arquivo in pasta) if (arquivo.nome == nome){
            arquivo.addStageArea()
            return true
        }
        return false
    }

    fun addAllStageArea(){
        for (arquivo: Arquivo in pasta) arquivo.addStageArea()
    }

    fun listarArquivos(): String {

        for (repositorio: Repositorio in repositorios)
            if (repositorio.isAberto())
                return repositorio.listarArquivos()
        return ""
    }

    fun commit(frase: String): Boolean {

        for (repositorio: Repositorio in repositorios)
            if (repositorio.isAberto())
                repositorio.commitar(frase)
        return true

    }

    fun sincronizarRepositorios(nome: String){ //Apenas arquivos por enquanto
        for (repositorio: Repositorio in repositorios){
            if (repositorio.nome == nome){
                for (arquivo: Arquivo in repositorio.arquivos){
                    if (arquivo.addStageArea && arquivo.commits.size >= 1){
                        arquivo.addRepRemoto()
                        repositorioRemoto.arquivos.add(arquivo)
                    }
                }
            }
        }
    }

    fun clone(nome: String) {
        for (arquivo: Arquivo in repositorioRemoto.arquivos){
            for (repositorio: Repositorio in repositorios){
                if (repositorio.nome == nome){
                    repositorio.arquivos.add(arquivo)
                }
            }
        }
    }


}