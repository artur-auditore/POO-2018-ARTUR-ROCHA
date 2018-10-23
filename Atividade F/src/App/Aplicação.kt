package App

import Model.Git

fun main(args: Array<String>){

    val git = Git()

    println ("**************SIMULADOR GITHUB****************" +
            "\n1 - Novo Repositório" +
            "\n2 - Abrir Repositório" +
            "\n3 - Listar Repositórios" +
            "\n4 - Abrir Repositório Remoto" +
            "\n5 - Sincronizar repositório local com o remoto" +
            "\n6 - Clone do repositório remoto" +
            "\n0 - Sair")

    loop@ while (true){
        print("Opção: ")
        val opcao = readLine()!!.toInt()

        when (opcao){
            1-> {
                //Criação de Repositório local

                print("Nome do Repositório: ")
                val nome = readLine()!!.toString()
                git.novoRepositorio(nome)
                println("Repositório Criado.")

            }
            2-> {
                //Abre repositório, se o array estiver vazio será impossível abrir algum

                if (git.repositorios.isEmpty()){
                    println("Nenhum repositório criado! Crie um e tente novamente.")

                } else {
                    println("Qual repositório deseja abrir? ")
                    println(git.listarRepositorios())
                    val nome = readLine()!!.toString()
                    git.abrirRepositorio(nome)

                    println("\n1 - Novo Arquivo" +
                            "\n2 - Renomear" +
                            "\n3 - Excluir" +
                            "\n4 - Abrir" + //Edita também
                            "\n5 - Adicionar à Stage Área" +
                            "\n6 - Adicionar todos à Stage Área" + //semelhante ao "git add *"
                            "\n7 - Excluir todos" +
                            "\n8 - Listar (por nome)" +
                            "\n9 - Fazer commit" +
                            "\n0 - Sair")

                    loop1@ while(true){
                        val opcao = readLine()!!.toInt()

                        when(opcao){
                            1 ->{
                                //Novo Arquivo

                                print("Nome: ")
                                val nome = readLine()!!.toString()

                                if (nome.trim() == "")
                                    println("Tente novamente com um novo nome.")

                                println("Conteúdo:")
                                val conteudo = readLine()!!.toString()

                                git.novoArquivo(nome, conteudo)
                                println("Arquivo criado.")
                            }
                            2 ->{
                                //Renomear

                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {

                                    print("Qual arquivo deseja renomear?")
                                    println(git.listarArquivos())

                                    val nome = readLine()!!.toString()
                                    print("Novo nome: ")
                                    val novoNome = readLine()!!.toString()

                                    git.renomear(nome, novoNome)
                                    println("Renomeado.")

                                }

                            }
                            3 ->{
                                //Excluir

                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {

                                    print("Qual arquivo deseja excluir?")
                                    println(git.listarArquivos())
                                    val nome = readLine()!!.toString()

                                    git.excluir(nome)
                                    println("Apagado.")

                                }

                            }
                            4 ->{
                                //TODO Abrir arquivo (a pretensão é editar também)

                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {

                                    println("Qual arquivo deseja abrir?")
                                    println(git.listarArquivos())

                                    val nomeArquivo = readLine()!!.toString()
                                    println(git.abrir(nomeArquivo))

                                    println("Deseja editar?(y/n)")
                                    val yn = readLine()!!.toString()

                                    if (yn == "y"){
                                        val novoConteudo = readLine()!!.toString()
                                        git.editar(nomeArquivo, novoConteudo)
                                        println("Modificado.")

                                    }

                                }

                            }
                            5 ->{
                                //Adicionar a Stage Área

                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {

                                    print("Qual arquivo deseja adicionar?")
                                    println(git.listarArquivos())

                                    print("Nome: ")
                                    val nome = readLine()!!.toString()

                                    git.addStageArea(nome)
                                    println("Adicionado.")

                                }

                            }
                            6 ->{
                                //Adicionar todos a Stage Área
                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {

                                    git.addAllStageArea()
                                    println("Todos adicionados")
                                }

                            }
                            7 ->{
                                //Apagar todos de uma vez
                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {
                                    println("Tem certeza que quer excluir todos os arquivos do repositório? (y/n)")
                                    val op = readLine()!!.toString()

                                    if (op == "y"){
//                                        git.excluirTodos()
                                        println("Todos apagados.")

                                    } else {
                                        println("Opção revogada.")
                                    }
                                }

                            }
                            8 ->{
                                //Listar
                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {

                                    println(git.listarArquivos())
                                }
                            }
                            9 ->{
                                //Commit dos arquivos
                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {

                                    println("Commit: ")
                                    val commit = readLine()!!.toString()

                                    git.commit(commit)
                                    println("Arquivos commitados.")
                                }

                            }
                            0 ->{
                                //Sair
                                println("Você retornou ao menu principal.")
                                git.fecharRepositorio()
                                break@loop1
                            }
                        }
                    }

                }

            }
            3-> {
                //Lista apenas os nomes dos repositórios criados pelo usuário

                println(git.listarRepositorios())

            }
            4 ->{
                //Abrir repositório remoto (para conferência) TODO fazer funcionar direito

                if (git.repositorioRemoto.verfificarVazio()) {
                    println("Impossível visualizar! Repositório vazio.")

                } else {

                    if (git.repositorioRemoto.nome.trim() == ""){

                        println("Deseja dar um nome para este repositório?(y/n)")
                        val op = readLine()!!.toString()

                        if (op == "y"){
                            print("Nome: ")
                            val nome = readLine()!!.toString()
                            git.repositorioRemoto.nome = nome
                            println("Nomeado.")

                        } else {
                            git.repositorioRemoto.nome = "Sem título"

                        }

                    }
                    git.repositorioRemoto.abrir()
                    println(git.repositorioRemoto.listar())

                }
            }
            5 ->{
                //Sincronizar com o repositorio remoto (semelhante ao "git push") TODO fazer funcionar direito

                println("Qual repositório local deseja sincronizar?")
                println(git.listarRepositorios())

                val nomeRepo = readLine()!!.toString()
                git.sincronizarRepositorios(nomeRepo)

                println("Sincronizado.")

            }
            6 ->{
                //Clone do repositório remoto (semelhante ao comando "git clone") TODO fazer funcionar direito

                if (git.repositorios.isEmpty()){
                    println("Impossível clonar! Crie um repositório local e tente novamente.")

                } else {
                    println("Para qual repositório deseja clonar?")
                    println(git.listarRepositorios())

                    val nomeRepo = readLine()!!.toString()
                    git.clone(nomeRepo)

                    println("Clonado.")

                }
            }
            0-> {
                break@loop
            }
        }
    }
}