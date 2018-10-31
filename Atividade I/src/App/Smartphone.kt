package App

import Model.*

fun main(args: Array<String>) {

    val android = Android()
    android.versão = "8.1.0" + "\nAndroid Oreo"

    val menu = "**** Simulador de apps Android ****" +
            "\n1 - Instalar app" +
            "\n2 - Abrir app" +
            "\n3 - Fechar apps abertos" +
            "\n4 - Desinstalar um app" +
            "\n5 - Apps Instalados" +
            "\n6 - Versão do Android" +
            "\n7 - Desligar" +
            "\n0 - Ajuda"

    println(menu)

    loop@ while (true){
        val opcao = readLine()!!.toInt()

        when (opcao){

            1 ->{
                
                println("Instalar novo app")
                print("Nome: ")
                val nome = readLine()!!.toString()

                android.installApp(nome)
                println("Instalado.")
            }
            2 ->{

                println("Abrir qual app?")
                println(android.listarApps())

                val nome = readLine()!!.toString()

                android.openApp(nome)
                println("$nome aberto.")
            }
            3 ->{

                println("Fechar todos os apps? (y/n)")
                val op = readLine()!!.toString()

                if (op == "y"){
                    android.closeApp()
                    println("Apps Encerrados.")
                }
            }
            4 ->{

                println("Qual app desinstalar?")
                println(android.listarApps())
                val nome = readLine()!!.toString()

                android.uninstallApp(nome)
                println("$nome desinstalado.")
            }
            5 ->{

                println(android.listarApps())
            }
            6 ->{
                println(android.versaoAndroid())
            }
            7 ->{
                println("Desligado.")
                break@loop
            }
            0 ->{
                println(menu)
            }
            else ->{
                println("Digite uma opção válida!")
            }
        }
    }
}