package Model

class Git{

    val repositorios = arrayListOf<Repositorio>()
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

    fun abrir(nome: String): String {
        var c = ""
        for (repositorio: Repositorio in repositorios)
            if (repositorio.isAberto()){
                c = repositorio.abrir(nome)
            }
        return c
    }

    fun editar(nome: String, novoConteudo: String){
        for (repositorio: Repositorio in repositorios)
            if (repositorio.isAberto())
                repositorio.editar(nome, novoConteudo)

    }

    fun excluir(nome: String){
        //todo essa merda não quer funcionar
//        for (repositorio: Repositorio in repositorios)
//            if (repositorio.isAberto())
//                repositorio.excluir(nome)
    }

    fun excluirTudo(){
        for (repositorio: Repositorio in repositorios) if (repositorio.isAberto())
            repositorio.excluirTudo()
    }

    fun addStageArea(nome: String){
        for (repositorio: Repositorio in repositorios) if (repositorio.isAberto())
            repositorio.addStageArea(nome)
    }

    fun addAllStageArea(){
        for (repositorio: Repositorio in repositorios) if (repositorio.isAberto())
            repositorio.addAllStageArea()
    }

    fun listarArquivos(): String {
        var dados = ""
        for (repositorio: Repositorio in repositorios)
            if (repositorio.isAberto())
                dados = repositorio.listarArquivos()
        return dados
    }

    fun commit(frase: String): Boolean {

        for (repositorio: Repositorio in repositorios)
            if (repositorio.isAberto())
                repositorio.commitar(frase)
        return true

    }

    fun sincronizarRepositorios(nomeRepositorio: String){ //Apenas arquivos por enquanto
        for (repositorio: Repositorio in repositorios){
            if (repositorio.nome == nomeRepositorio){
                for (arquivo: Arquivo in repositorio.arquivos)
                    if (arquivo.addStageArea && arquivo.commits.size >= 1){

                        arquivo.addRepRemoto()
                        repositorioRemoto.arquivos.add(arquivo)
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