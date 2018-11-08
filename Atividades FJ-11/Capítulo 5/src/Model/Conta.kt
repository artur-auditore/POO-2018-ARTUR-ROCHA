package Model

class Conta(var nomeTitular:String){ //Construtor primário

    constructor() : this("") //Construtor secundário

    //Em Kotlin não precisa de getter e setter
    var idenficador = 0
    var numero = 0
    var agencia = ""
    var saldo = 0.0
    var dataDeAbertura: Data? = null


}