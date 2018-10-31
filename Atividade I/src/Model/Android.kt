package Model

import Model.App

class Android{

    val apps = arrayListOf<App>()
    var versão = ""

    fun installApp(nome: String){

        val app = App()
        app.nome = nome
        app.install = true
        apps.add(app)
    }

    fun uninstallApp(nome: String){

        for (app in apps)
            if (app.nome == nome) {
                apps.remove(app)
            }
    }

    fun openApp(nome: String): Boolean {

        for (app in apps) if (app.nome == nome) {
                app.open = true
                return app.open
            }
        return false
    }

    fun closeApp(): Boolean {
        for (app in apps) if (app.isAberto()){
            app.open = false
            return app.open
        }
        return true
    }

    fun listarApps(): String {

        var dados = ""
        for (app in apps){
            dados += app.nome + "\n"
        }
        return dados
    }

    fun versaoAndroid(): String{
        return this.versão
    }
}