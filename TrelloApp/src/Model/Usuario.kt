package Model

class Usuario(var nome: String,
    var email: String,
    var senha: String){


    lateinit var username: String
    private var logado = false
    private var quadros = arrayListOf<Quadro>()
    var logs = arrayListOf<String>()

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

    //Métodos referentes a quadros

    fun novoQuadro(titulo: String){
        val quadro = Quadro(titulo)
        this.quadros.add(quadro)

        this.logs.add("$nome criou o quadro $titulo.")
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

        this.logs.add("$nome arquivou o quadro $titulo.")
    }

    fun verQuadros():String{
        var dados = ""
        for (i in 0 until this.quadros.size) if (!quadros[i].estaArquivado()){
            dados += "$i. ${this.quadros[i].nome}\n"
        }
        return dados
    }

    fun verQuadrosArquivados(): String{
        var dados = ""
        for (i in 0 until this.quadros.size) if (this.quadros[i].estaArquivado()){
            dados += "${i+1}. ${this.quadros[i].nome}\n"
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

            //Dá bug e apaga os cartões das listas do quadro copiado também '-'
            for (lista in quadroCopiado.listas) lista.cartoes.clear()
            this.quadros.add(quadroCopiado)
        }
        this.logs.add("$nome copiou $titulo para $novoTitulo.")
    }

    fun renomearQuadro(titulo: String, novoTitulo: String){
        for (quadro in this.quadros) if (quadro.nome == titulo){
            quadro.nome = novoTitulo
        }
        this.logs.add("$nome renomeou $titulo para $novoTitulo.")
    }

    //Métodos referentes a listas

    fun novaLista(titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.novaLista(titulo)
            this.logs.add("$nome adicionou $titulo a ${quadro.nome}.")
        }
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
            this.logs.add("$nome arquivou a lista $titulo do quadro ${quadro.nome}")
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

        this.logs.add("$nome copiou a lista $titulo.")
    }

    fun renomearLista(titulo: String, novoTitulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.renomearLista(titulo, novoTitulo)
        }
    }

    fun moverLista(titulo: String, posicao: Int){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.moverLista(titulo, posicao)
        }

        this.logs.add("$nome moveu a lista $titulo.")
    }

    fun fecharLista() {
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.fecharLista()
        }
    }

    //Métodos referentes a cartões

    fun novoCartao(titulo: String, descricao: String){
        for (quadro in this.quadros) if (quadro.isOpen()) {
            quadro.novoCartao(titulo, descricao)
            this.logs.add("$nome adicionou $titulo a ${quadro.nome}.")
        }
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
            this.logs.add("$nome copiou $titulo para a mesma lista.")
        }
    }

    fun copiarCartao(titulo: String, nomeLista: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.copiarCartao(titulo, nomeLista)
            this.logs.add("$nome copiou $titulo para a lista $nomeLista.")
        }
    }

    fun copiarCartao(titulo: String, nomeLista: String, nomeQuadro: String){
        for (quadro in this.quadros) if (quadro.nome == nomeQuadro){
            quadro.copiarCartao(titulo, nomeLista)
            this.logs.add("$nome copiou $titulo para a lista $nomeLista do quadro $nomeQuadro.")
        }
    }

    fun arquivarCartao(titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.arquivarCartao(titulo)
            this.logs.add("$nome arquivou o cartão $titulo.")
        }
    }

    fun verCartoesArquivados(): String{
        for (quadro in this.quadros) if (quadro.isOpen()){
            return quadro.verCartoesArquivados()
        }

        return ""
    }

    fun renomearCartao(titulo: String, novoTitulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.renomearCartao(titulo, novoTitulo)
            this.logs.add("$nome mudou o título de $titulo para $novoTitulo.")
        }
    }

    fun abrirCartao(titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.abrirCartao(titulo)
        }
    }

    fun addOrChangeDescription(descricao: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.addOrChangeDescription(descricao)
        }
    }

    fun fecharCartao(){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.fecharCartao()
        }
    }

    fun moverCartao(titulo: String, tituloLista: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.moverCartao(titulo, tituloLista)
            this.logs.add("$nome moveu $titulo para a lista $tituloLista.")
        }
    }

    fun moverCartao(titulo: String, tituloLista: String, tituloQuadro: String){
        for (quadro in this.quadros) if (quadro.nome == tituloQuadro) {
            quadro.moverCartao(titulo, tituloLista)
        }
    }

    fun verLogs(): String{
        var dados = ""
        for (i in 0 until this.logs.size)
            dados+="${i+1}. ${logs[i]}\n"

        return dados
    }

    //Referente a comentários

    fun comentar(comentario: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.comentar(comentario)
            this.logs.add("$nome comentou em um cartão do quadro ${quadro.nome}.")
        }
    }

    fun editarComentario(comentario: String, novoComentario: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.editarComentario(comentario, novoComentario)
        }
    }

    fun excluirComentario(comentario: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.excluirComentario(comentario)
            this.logs.remove("$nome comentou em um cartão do quadro ${quadro.nome}.")
        }
    }

    fun verComentarios(): String{
        for (quadro in this.quadros) if (quadro.isOpen()){
            return quadro.verComentarios()
        }

        return ""
    }

    //Métodos para etiquetas

    fun definirEtiquetas(cor: String, descricao: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.definirEtiqueta(cor, descricao)
        }
    }

    fun excluirEtiqueta(etiqueta: String, titulo: String){
        for (quadro in this.quadros) if (quadro.isOpen()){
            quadro.excluirEtiqueta(etiqueta, titulo)
        }
    }
}