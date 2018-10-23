package App

import Model.Git

fun main(args: Array<String>){

    val git = Git()

    val menu = "**************SIMULADOR GITHUB****************" +
            "\nPara obter ajuda, digite help" +
            "\n1 - Novo Repositório" + //"git init"
            "\n2 - Abrir Repositório" +
            "\n3 - Listar Repositórios" + // ls
            "\n4 - Abrir Repositório Remoto" +
            "\n5 - Sincronizar repositório local com o remoto" + //git pull
            "\n6 - Clone do repositório remoto" + //"git clone"
            "\n0 - Sair"
    println(menu)

    loop@ while (true){

        print("Opção: ")
        val opcao = readLine()!!.toString()

        when (opcao){
            "1"-> {
                //Criação de Repositório local

                print("Nome do Repositório: ")
                val nome = readLine()!!.toString()
                git.novoRepositorio(nome)
                println("Repositório Criado.")

            }
            "2"-> {
                //Abre repositório, se o array estiver vazio será impossível abrir algum

                if (git.repositorios.isEmpty()){
                    println("Nenhum repositório criado! Crie um e tente novamente.")

                } else {
                    println("Qual repositório deseja abrir? ")
                    println(git.listarRepositorios())
                    val nome = readLine()!!.toString()
                    git.abrirRepositorio(nome)

                    val menuRepositorio = "Para obter ajuda, digite help" +
                            "\n1 - Novo Arquivo" +
                            "\n2 - Renomear" +
                            "\n3 - Excluir" +
                            "\n4 - Abrir" + //Edita também
                            "\n5 - Adicionar à Stage Área" +
                            "\n6 - Adicionar todos à Stage Área" + //semelhante ao "git add *"
                            "\n7 - Excluir todos" +
                            "\n8 - Listar (por nome)" +
                            "\n9 - Fazer commit" +
                            "\n10 - Status dos arquivos" +
                            "\n0 - Sair"
                    println(menuRepositorio)

                    loop1@ while(true){
                        val opc = readLine()!!.toString()

                        when(opc){
                            "1" ->{
                                //Novo Arquivo

                                print("Nome: ")
                                val nomeArquivo = readLine()!!.toString()

                                if (nomeArquivo.trim() == "")
                                    println("Tente novamente com um novo nome.")

                                println("Conteúdo:")
                                val conteudo = readLine()!!.toString()

                                git.novoArquivo(nomeArquivo, conteudo)
                                println("Arquivo criado.")
                            }
                            "2" ->{
                                //Renomear

                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {

                                    print("Qual arquivo deseja renomear?")
                                    println(git.listarArquivos())

                                    val nomeArquivo = readLine()!!.toString()
                                    print("Novo nome: ")
                                    val novoNome = readLine()!!.toString()

                                    git.renomear(nomeArquivo, novoNome)
                                    println("Renomeado.")
                                }
                            }
                            "3" ->{
                                //Excluir

                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {

                                    print("Qual arquivo deseja excluir?")
                                    println(git.listarArquivos())
                                    val nomeArquivo = readLine()!!.toString()

                                    git.excluir(nomeArquivo)
                                    println("Apagado.")
                                }
                            }
                            "4" ->{

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
                            "5" ->{
                                //Adicionar a Stage Área

                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {

                                    print("Qual arquivo deseja adicionar?")
                                    println(git.listarArquivos())

                                    print("Nome: ")
                                    val nomeArquivo = readLine()!!.toString()

                                    git.addStageArea(nomeArquivo)
                                    println("Adicionado.")
                                }
                            }
                            "6" ->{
                                //Adicionar todos a Stage Área
                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {
                                    val op = readLine()!!.toString()
                                    if (op == "y"){
                                        git.addAllStageArea()
                                        println("Todos adicionados.")
                                    } else {
                                        println("Opção revogada.")
                                    }
                                }
                            }
                            "7" ->{
                                //Apagar todos de uma vez
                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {
                                    println("Tem certeza que quer excluir todos os arquivos do repositório? (y/n)")
                                    val op = readLine()!!.toString()

                                    if (op == "y"){
//                                        git.excluirTudo()
                                        println("Todos apagados.")

                                    } else {
                                        println("Opção revogada.")
                                    }
                                }
                            }
                            "8" ->{
                                //Listar
                                if (git.verfificarVazio()){
                                    println("Nenhum arquivo criado! Crie um e tente novamente.")

                                } else {

                                    println(git.listarArquivos())
                                }
                            }
                            "9" ->{
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
                            "10" ->{
                                //Status todo não esquecer

                            }
                            "0" ->{
                                //Sair
                                println("Você retornou ao menu principal.")
                                git.fecharRepositorio()
                                break@loop1
                            }
                            "help" ->{
                                println(menuRepositorio)
                            }
                            else ->{
                                println("Opção inválida! Tente novamente.")
                            }
                        }
                    }

                }
            }
            "3"-> {
                //Lista apenas os nomes dos repositórios criados pelo usuário

                println(git.listarRepositorios())

            }
            "4" ->{
                //Abrir repositório remoto (para conferência)

                if (git.repositorioRemoto.nome.trim() == "") {

                    println("Deseja dar um nome para este repositório?(y/n)")
                    val op = readLine()!!.toString()

                    if (op == "y") {
                        print("Nome: ")
                        val nomeRepRemoto = readLine()!!.toString()
                        git.repositorioRemoto.nome = nomeRepRemoto
                        println("Nomeado.")

                    } else {
                        git.repositorioRemoto.nome = "Sem título"

                    }
                }

                if (git.repositorioRemoto.verfificarVazio()) {
                    println("Impossível visualizar! Repositório vazio.")

                } else {
                    git.repositorioRemoto.abrir()
                    println(git.repositorioRemoto.listar())

                }
            }
            "5" ->{
                //Sincronizar com o repositorio remoto ("git push")

                println("Qual repositório local deseja sincronizar?")
                println(git.listarRepositorios())

                val nomeRepo = readLine()!!.toString()
                git.sincronizarRepositorios(nomeRepo)

                println("Sincronizado.")

            }
            "6" ->{
                //Clone do repositório remoto ("git clone")

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
            "0"-> {
                break@loop
            }
            "help" ->{
                println(menu)
            }
            else ->{
                println("Opção inválida! Tente novamente.")
            }
        }
    }
}