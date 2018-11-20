package Service

import Model.Usuario
import java.lang.StringBuilder

class Trello {

    private var usuarios = arrayListOf<Usuario>()

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
        val username = StringBuilder(); username.append(nome.toLowerCase() + "12")
        return username.toString()
    }

    fun logout() {
        for (usuario in usuarios) if (usuario.isLogged()){
            usuario.logout()
        }
    }

    //Métodos específicos para operações com quadros

    fun novoQuadro(titulo: String) {
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

        return "Não há quadros."
    }

    fun verQuadrosArquivados(): String{
        for (usuario in usuarios) if (usuario.isLogged()){
            return usuario.verQuadrosArquivados()
        }

        return "Não há quadros."
    }

    fun copiarQuadro(titulo: String, novoTitulo: String, opc: String){
        for (usuario in usuarios) if (usuario.isLogged()){
            usuario.copiarQuadro(titulo, novoTitulo, opc)
        }
    }

    //Métodos específicos para operações com listas

    fun novaLista(titulo: String) {
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.novaLista(titulo)
        }
    }

    fun abrirLista(titulo: String) {
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
        return "Não há cartões no arquivo"
    }
}