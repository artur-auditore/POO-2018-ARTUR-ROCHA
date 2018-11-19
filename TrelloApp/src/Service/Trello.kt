package Service

import Model.Quadro
import Model.Usuario
import java.lang.StringBuilder

class Trello{

    var usuarios = arrayListOf<Usuario>()


    fun novoCadastro(nome: String, email: String, senha: String){
        val usuario = Usuario()
        usuario.nome = nome
        usuario.email = email
        usuario.senha = senha
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

    fun gerarUsername(nome: String): String{
        val username = StringBuilder(); username.append(nome.toLowerCase()+"12")
        return username.toString()
    }

    fun novoQuadro(titulo: String){
        for (usuario in usuarios) if (usuario.isLogged()){
            usuario.novoQuadro(titulo)
        }
    }
}