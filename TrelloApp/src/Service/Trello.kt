package Service

import Model.Cartao
import Model.Usuario
import java.lang.StringBuilder

class Trello {

    var usuarios = arrayListOf<Usuario>()


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

    fun copiarLista(titulo: String) {
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.copiarLista(titulo)
        }
    }

    fun fecharQuadro() {
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.fecharQuadro()
        }
    }

    fun fecharLista() {
        for (usuario in usuarios) if (usuario.isLogged()) {
            usuario.fecharLista()
        }
    }

    fun logout() {
        for (usuario in usuarios) if (usuario.isLogged()){
            usuario.logout()
        }
    }
}