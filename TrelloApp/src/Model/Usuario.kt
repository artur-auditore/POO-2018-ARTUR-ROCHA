package Model

class Usuario(var nome: String,
    var email: String,
    var senha: String){


    lateinit var username: String
    private var logado = false
    private var quadros = arrayListOf<Quadro>()

    fun logar(): Boolean {
        this.logado = true
        return true
    }

    fun logout (){
        this.logado = false
    }

    fun isLogged(): Boolean{
        return this.logado
    }

    fun novoQuadro(titulo: String){
        val quadro = Quadro(titulo)
        this.quadros.add(quadro)
    }

    fun abrirQuadro(titulo: String){
        for (quadro in this.quadros) if (quadro.nome == titulo){
            quadro.abrirQuadro()
        }
    }

    fun arquivar(titulo: String){
        for (quadro in this.quadros) if (quadro.nome == titulo){
            quadro.arquivado = true
        }
    }

    fun verQuadros():String{
        var dados = ""
        for (quadro in this.quadros) if (!quadro.estaArquivado()){
            dados += "${quadro.nome}\n"
        }
        return dados
    }

    fun verQuadrosArquivados(): String{
        var dados = ""
        for (quadro in this.quadros) if (quadro.estaArquivado()){
            dados += "${quadro.nome}\n"
        }
        return dados
    }

    fun fecharQuadro(){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.fecharQuadro()
        }
    }

    fun copiarQuadro(titulo: String, novoTitulo: String, opc: String){
        val quadroCopiado: Quadro

        if (opc == "y"){
            quadroCopiado = Quadro(novoTitulo)

            for (quadro in this.quadros) if (quadro.nome == titulo)
                for (lista in quadro.listas) quadroCopiado.listas.add(lista)


            this.quadros.add(quadroCopiado)

        } else {
            quadroCopiado = Quadro(novoTitulo)

            for (quadro in this.quadros) if (quadro.nome == titulo)
                for (lista in quadro.listas) quadroCopiado.listas.add(lista)


            for (lista in quadroCopiado.listas) lista.cartoes.clear()
            this.quadros.add(quadroCopiado)
        }
    }

    fun novaLista(titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen())
            quadro.novaLista(titulo)
    }

    fun abrirLista(titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.abrirLista(titulo)
        }
    }

    fun verListas(): String{
        //Vê listas do quadro que está aberto
        for (quadro in this.quadros) if (quadro.isOpen())
            return quadro.verListas()

        return "Não há listas."
    }

    fun verListas(titulo: String): String{
        //Vê listas de um quadro específico
        for (quadro in this.quadros) if (quadro.nome == titulo){
            return quadro.verListas()
        }

        return "Não há listas."
    }

    fun arquvarLista(titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.arquivarLista(titulo)
        }
    }

    fun verListasArquivadas(): String{
        for (quadro in this.quadros) if (quadro.isOpen()){
            return quadro.verListasArquivadas()
        }

        return "Não há listas."
    }

    fun copiarLista(titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.copiarLista(titulo)
        }
    }

    fun novoCartao(titulo: String, descricao: String){
        for (quadro in this.quadros) if (quadro.isOpen())
            quadro.novoCartao(titulo, descricao)
    }

    fun verCartoes(): String{
        for (quadro in this.quadros) if (quadro.isOpen()){
            return quadro.verCartoes()
        }

        return ""
    }

    fun copiarCartao(titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.copiarCartao(titulo)
        }
    }

    fun copiarCartao(titulo: String, nomeLista: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.copiarCartao(titulo, nomeLista)
        }
    }

    fun copiarCartao(titulo: String, nomeLista: String, nomeQuadro: String){
        for (quadro in this.quadros) if (quadro.nome == nomeQuadro){
            quadro.copiarCartao(titulo, nomeLista)
        }
    }

    fun arquivarCartao(titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.arquivarCartao(titulo)
        }
    }

    fun verCartoesArquivados(): String{
        for (quadro in this.quadros) if (quadro.isOpen()){
            return quadro.verCartoesArquivados()
        }

        return ""
    }

    fun fecharLista() {
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.fecharLista()
        }
    }
}