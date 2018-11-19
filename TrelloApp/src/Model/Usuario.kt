package Model

class Usuario{

    lateinit var nome: String
    lateinit var email: String
    lateinit var senha: String
    lateinit var username: String
    var logado = false

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
}