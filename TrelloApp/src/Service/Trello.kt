package Service

import Model.Etiqueta
import Model.Usuario
import java.lang.StringBuilder

open class Trello {

    var usuarios = arrayListOf<Usuario>()
    var cores = arrayListOf("Amarelo", "Verde", "Laranja", "Vermelho", "Roxo", "Azul")
    //Metodos para criação e login de usuário

    fun novoCadastro(nome: String, email: String, senha: String) {
        val usuario = Usuario(nome, email, senha)
        usuario.username = gerarUsername(nome)

        usuarios.add(usuario)
    }

    fun logar(emailOrUsername: String, senha: String): Boolean {
        for (usuario in usuarios)
            if (usuario.email == emailOrUsername ||
                    usuario.username == emailOrUsername && usuario.senha == senha)
                return usuario.logar()

        return false
    }

    fun gerarUsername(nome: String): String {

        val username = StringBuilder()
        username.append(nome.toLowerCase()+"3")
        return username.toString()

    }

    fun logout() {
        for (usuario in usuarios) if (usuario.isLogged()){
            usuario.logout()
        }
    }

    //Métodos específicos para operações com quadros

    fun novoQuadro(titulo: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.novoQuadro(titulo)
        }

    }

    fun abrirQuadro(titulo: String) {
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.abrirQuadro(titulo)
        }
    }

    fun fecharQuadro() {
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.fecharQuadro()
        }
    }

    fun arquivarQuadro(titulo: String){
        for (usuario in usuarios) if (usuario.isLogged()){
            return usuario.arquivar(titulo)
        }
    }

    fun verQuadros(): String {
        for (usuario in usuarios) if (usuario.isLogged())
            return usuario.verQuadros()

        return ""
    }

    fun verQuadrosArquivados(): String{
        for (usuario in usuarios) if (usuario.isLogged()){
            return usuario.verQuadrosArquivados()
        }

        return ""
    }

    fun copiarQuadro(titulo: String, novoTitulo: String, opc: String){
        for (usuario in usuarios) if (usuario.isLogged()){
            usuario.copiarQuadro(titulo, novoTitulo, opc)
        }
    }

    fun renomearQuadro(titulo: String, novoTitulo: String){
        for (usuario in usuarios) if (usuario.isLogged()){
            usuario.renomearQuadro(titulo, novoTitulo)
        }
    }

    fun verLogs(): String{
        for (usuario in usuarios) if (usuario.isLogged()){
            return usuario.verLogs()
        }

        return ""
    }

    //Métodos específicos para operações com listas

    fun novaLista(titulo: String) {
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.novaLista(titulo)
        }

    }

    fun abrirLista(titulo: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.abrirLista(titulo)
        }

    }

    fun fecharLista() {
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.fecharLista()
        }
    }

    fun verListas(): String {
        for (usuario in usuarios) if (usuario.isLogged()) {
            return usuario.verListas()
        }

        return ""
    }

    fun verListas(titulo: String): String {
        for (usuario in usuarios) if (usuario.isLogged()) {
            return usuario.verListas(titulo)
        }

        return ""
    }

    fun copiarLista(titulo: String) {
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.copiarLista(titulo)
        }
    }

    fun verListasArquivadas(): String{
        for (usuario in usuarios) if (usuario.isLogged()) {
            return usuario.verListasArquivadas()
        }

        return ""
    }

    fun arquivarLista(titulo: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.arquvarLista(titulo)
        }
    }

    fun renomearLista(titulo: String, novoTitulo: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.renomearLista(titulo, novoTitulo)
        }
    }

    fun moverLista(titulo: String, posicao: Int){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.moverLista(titulo, posicao)
        }
    }

    //Métodos específicos para operações com cartões

    fun novoCartao(titulo: String, descricao: String) {
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.novoCartao(titulo, descricao)
        }

    }

    fun verCartoes(): String {
        for (usuario in usuarios) if (usuario.isLogged()) {
            return usuario.verCartoes()
        }

        return ""
    }

    fun copiarCartao(titulo: String) {
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.copiarCartao(titulo)
        }
    }

    fun copiarCartao(titulo: String, nomeLista: String) {
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.copiarCartao(titulo, nomeLista)
        }
    }

    fun copiarCartao(titulo: String, nomeLista: String, nomeQuadro: String) {
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.copiarCartao(titulo, nomeLista, nomeQuadro)
        }
    }

    fun arquivarCartao(titulo: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.arquivarCartao(titulo)
        }
    }

    fun verCartoesArquivados(): String{
        for (usuario in usuarios) if (usuario.isLogged()) {
            return usuario.verCartoesArquivados()
        }
        return ""
    }

    fun renomearCartao(titulo: String, novoTitulo: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.renomearCartao(titulo, novoTitulo)
        }
    }

    fun abrirCartao(titulo: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.abrirCartao(titulo)
        }
    }

    fun addOrChangeDescription(descricao: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.addOrChangeDescription(descricao)
        }
    }

    fun fecharCartao(){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.fecharCartao()
        }
    }

    fun moverCartao(titulo: String, tituloLista: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.moverCartao(titulo, tituloLista)
        }
    }

    fun moverCartao(titulo: String, tituloLista: String, tituloQuadro: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.moverCartao(titulo, tituloLista, tituloQuadro)
        }
    }

    //Referente a comentários

    fun comentar(comentario: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.comentar(comentario)
        }
    }

    fun editarComentario(comentario: String, novoComentario: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.editarComentario(comentario, novoComentario)
        }
    }

    fun excluirComentario(comentario: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.excluirComentario(comentario)
        }
    }

    fun verComentarios(): String{
        for (usuario in usuarios) if (usuario.isLogged()) {
            return usuario.verComentarios()
        }

        return ""
    }

    //Métodos para etiquetas

    fun definirEtiqueta(index: Int, descricao: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.definirEtiquetas(this.cores[index], descricao)
        }
    }

    fun listarEtiquetas(): String{
        var dados = ""
        for (i in 0 until this.cores.size)
            dados += "${i+1}. ${this.cores[i]}\n"

        return dados
    }

    fun excluirEtiquera(etiqueta: String, titulo: String){
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.excluirEtiqueta(etiqueta, titulo)
        }
    }
}