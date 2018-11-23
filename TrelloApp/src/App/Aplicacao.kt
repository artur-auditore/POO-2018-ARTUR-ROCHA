package App

import Service.Trello

fun main(args: Array<String>) {

    val trello = Trello()
    val menuLogin = "**** Trello App ****" +
            "\n1. Login" +
            "\n2. Cadastre-se" +
            "\n0. Sair"

    println(menuLogin)
    loop@ while (true){
        print("Opção: ")
        val opcao = readLine()!!.toString()

        when (opcao){

            "1" ->{

                println("E-mail/Nome de usuário:")
                val emailOrUsername = readLine()!!.toString()
                println("Senha:")
                val senha = readLine()!!.toString()

                if (trello.logar(emailOrUsername, senha)){
                    println("Bem vindo!")

                    val primeroMenu = "1. Novo quadro" +
                            "\n2. Ver quadros" +
                            "\n3. Abrir quadro" +
                            "\n4. Arquivar" +
                            "\n5. Ver quadros arquivados" +
                            "\n6. Copiar" +
                            "\n7. Renomear" +
                            "\n8. Logs" +
                            "\n0. Sair" +
                            "\nPara obter ajuda pressione h"

                    println(primeroMenu)
                    loop1@ while (true){
                        print("Opção: ")
                        val opcaoUsuario = readLine()!!.toString()

                        when(opcaoUsuario){

                            //Novo quadro
                            "1" ->{

                                println("Título:")
                                val titulo = readLine()!!.toString()

                                if (titulo.trim() == "") {
                                    println("Nome inválido. Tente novamente.")
                                } else {
                                    trello.novoQuadro(titulo)
                                    println("$titulo criado. Adicione listas...")
                                }
                            }
                            //Listagem por nome dos quadros
                            "2" ->{

                                println(trello.verQuadros())
                            }
                            //Abrir quadro
                            "3" ->{
                                println("Qual quadro deseja abrir?")
                                println(trello.verQuadros())
                                val nomeQuadro = readLine()!!.toString()

                                trello.abrirQuadro(nomeQuadro)
                                println("Quadro aberto.")

                                val segundoMenu = "1. Adicionar Lista" +
                                        "\n2. Abrir Lista" +
                                        "\n3. Ver Listas" +
                                        "\n4. Copiar Lista" +
                                        "\n5. Mover Lista" +
                                        "\n6. Arquivar" +
                                        "\n7. Ver listas arquivadas" +
                                        "\n0. Voltar" +
                                        "\nPara obter ajuda pressione h"

                                println(segundoMenu)
                                loop2@ while (true){
                                    print("Opção: ")
                                    val opcaoQuadro = readLine()!!.toString()

                                    when(opcaoQuadro){

                                        //Adicionar Lista
                                        "1" ->{
                                            println("Título:")
                                            val titulo = readLine()!!.toString()

                                            if (titulo.trim() == ""){
                                                println("Título inválido. Tente novamente.")
                                            } else{
                                                trello.novaLista(titulo)
                                                println("$titulo criada.")
                                            }
                                        }

                                        //Abrir Lista
                                        "2" ->{
                                            println("Qual lista deseja abrir?")
                                            println(trello.verListas())
                                            val nomeLista = readLine()!!.toString()

                                            if (nomeLista.trim() == "") {
                                                println("Nome inválido.")
                                            } else {
                                                trello.abrirLista(nomeLista)
                                                println("Lista aberta.")
                                                val terceiroMenu = "1. Novo cartão" +
                                                        "\n2. Abrir cartão" +
                                                        "\n3. Ver Cartões" +
                                                        "\n4. Copiar" +
                                                        "\n5. Mover" +
                                                        "\n6. Renomear" +
                                                        "\n7. Arquivar" +
                                                        "\n8. Ver cartões arquivados" +
                                                        "\n0. Sair" +
                                                        "\nPara obter ajuda pressione h"

                                                println(terceiroMenu)
                                                loop3@ while (true){
                                                    print("Opção: ")
                                                    val opcaoCartao = readLine()!!.toString()

                                                    when(opcaoCartao){

                                                        //Novo cartão
                                                        "1" ->{

                                                            println("Título:")
                                                            val tituloCartao = readLine()!!.toString()
                                                            println("Descrição")
                                                            val descCartao = readLine()!!.toString()
                                                            if (tituloCartao.trim() == ""){
                                                                println("Forneça um título inválido")
                                                            } else {
                                                                trello.novoCartao(tituloCartao, descCartao)
                                                                println("$tituloCartao criado")
                                                            }
                                                        }

                                                        // Abrir cartão (para editar também)
                                                        "2" ->{

                                                            println("Qual cartão deseja abrir?")
                                                            println(trello.verCartoes())
                                                            val tituloCartao = readLine()!!.toString()

                                                            if (tituloCartao.trim() == ""){
                                                                println("Tente novamente com um nome válido.")
                                                            } else{

                                                                trello.abrirCartao(tituloCartao)
                                                                println("Cartão aberto.")

                                                                val quartoMenu = "1. Adicionar/Mudar descrição" +
                                                                        "\n2. Adicionar comentário" +
                                                                        "\n3. Editar comentário" +
                                                                        "\n4. Excluir comentário" +
                                                                        "\n6. Ver comentários" +
                                                                        "\n5. Definir etiquetas" +
                                                                        "\n0. Sair" +
                                                                        "\nPara obter ajuda pressione h"

                                                                println(quartoMenu)
                                                                loop4@ while (true){
                                                                    print("Opção: ")
                                                                    val opc = readLine()!!.toString()

                                                                    when(opc){

                                                                        //Adicionar/Mudar descrição
                                                                        "1" ->{
                                                                            println("Nova descrição:")
                                                                            val descricao = readLine()!!.toString()

                                                                            if (descricao.trim() == ""){
                                                                                println("Erro. Tente Novamente.")
                                                                            } else {
                                                                                trello.addOrChangeDescription(descricao)
                                                                                println("Descrição adicionada/" +
                                                                                        "alterada.")
                                                                            }
                                                                        }

                                                                        //Adicionar Comentário
                                                                        "2" ->{

                                                                            println("Novo comentário:")
                                                                            val comentario = readLine()!!.toString()
                                                                            if (comentario.trim() == ""){
                                                                                println("Comentário inválido." +
                                                                                        "Tente novamente.")
                                                                            } else {
                                                                                trello.comentar(comentario)
                                                                            }
                                                                        }

                                                                        //Editar comentário
                                                                        "3" ->{
                                                                            println("Qual comentário deseja editar?")
                                                                            println(trello.verComentarios())
                                                                            val comment = readLine()!!.toString()
                                                                            println("Novo comentário:")
                                                                            val newComment = readLine()!!.toString()

                                                                            if (comment.trim() == ""){
                                                                                println("Inválido. Tente novamente.")
                                                                            } else {
                                                                                trello.editarComentario(comment,
                                                                                    newComment)
                                                                                println("Comentário editado")
                                                                            }
                                                                        }

                                                                        //Excluir comentário
                                                                        "4" -> {

                                                                            println("Qual comentário deseja remover?")
                                                                            println(trello.verComentarios())
                                                                            val comment = readLine()!!.toString()

                                                                            if (comment.trim() == ""){
                                                                                println("Inválido. Tente novamente.")
                                                                            } else {
                                                                                trello.excluirComentario(comment)
                                                                                println("Comentário excluído.")
                                                                            }
                                                                        }

                                                                        //Ver Comentários
                                                                        "6" ->{

                                                                            println(trello.verComentarios())
                                                                        }
                                                                        //Todo Definir etiquetas
                                                                        "5" ->{

                                                                        }

                                                                        //Sair
                                                                        "0" ->{
                                                                            trello.fecharCartao()
                                                                            println(terceiroMenu)
                                                                            break@loop4
                                                                        }

                                                                        "h" -> println(quartoMenu)

                                                                        else -> println("Opção inválida.")
                                                                    }
                                                                }
                                                            }
                                                        }

                                                        //Ver cartões (por título)
                                                        "3" ->{
                                                            println(trello.verCartoes())
                                                        }

                                                        //Copiar cartão
                                                        "4" ->{

                                                            println("Escolha um cartão:")
                                                            println(trello.verCartoes())
                                                            val tituloCartao = readLine()!!.toString()

                                                            if (tituloCartao.trim() == "") {
                                                                println("Forneça um título válido.")
                                                            } else {
                                                                println("Para onde deseja copiar $tituloCartao?" +
                                                                        "\n1. Mesma lista" +
                                                                        "\n2. Outra lista" +
                                                                        "\n3. Outro lista de outro quadro")

                                                                val opcaoCopiar = readLine()!!.toString()
                                                                when (opcaoCopiar){

                                                                    //Copia para a mesma lista
                                                                    "1" -> {
                                                                        trello.copiarCartao(tituloCartao)
                                                                        println("$tituloCartao copiado.")
                                                                    }

                                                                    //Copia para outra lista do mesmo quadro
                                                                    "2" ->{
                                                                        println("Deseja copiar para qual lista?")
                                                                        println(trello.verListas())
                                                                        val tituloLista = readLine()!!.toString()

                                                                        trello.copiarCartao(tituloCartao, tituloLista)
                                                                        println("$tituloCartao copiado.")
                                                                    }

                                                                    //Escolhe um quadro e uma lista para copiar o cartão
                                                                    "3" ->{
                                                                        println("Deseja copiar para qual quadro?")
                                                                        println(trello.verQuadros())
                                                                        val tituloQuadro = readLine()!!.toString()
                                                                        println("Escolha a lista de destino:")
                                                                        println(trello.verListas(tituloQuadro))
                                                                        val tituloLista = readLine()!!.toString()

                                                                        trello.copiarCartao(tituloCartao, tituloLista,
                                                                            tituloQuadro)
                                                                        println("$tituloCartao copiado.")
                                                                    }

                                                                    else -> println("Opção inválida.")
                                                                }
                                                            }
                                                        }

                                                        //Todo Mover
                                                        "5" ->{

                                                            println("Escolha um cartão:")
                                                            println(trello.verCartoes())
                                                            val tituloCartao = readLine()!!.toString()

                                                            if (tituloCartao.trim() == ""){
                                                                println("Tente novamente com um título válido.")
                                                            } else {
                                                                println("Para onde deseja mover $tituloCartao?" +
                                                                        "\n1. Mesma lista" +
                                                                        "\n2. Outra lista" +
                                                                        "\n3. Outro lista de outro quadro")
                                                                print("Opção: ")
                                                                val opcaoMover = readLine()!!.toString()

                                                                when(opcaoMover){

                                                                    "1" ->{

                                                                    }

                                                                    "2" ->{

                                                                    }

                                                                    "3" ->{

                                                                    }

                                                                    else -> println("Opção inválida")
                                                                }
                                                            }
                                                        }

                                                        //Renomear Cartão
                                                        "6" ->{
                                                            println("Qual cartão deseja renomear?")
                                                            println(trello.verCartoes())
                                                            val tituloCartao = readLine()!!.toString()
                                                            println("Atribua um novo título:")
                                                            val novoTitulo = readLine()!!.toString()

                                                            if (tituloCartao.trim() == "" || novoTitulo.trim() == ""){
                                                                println("Tente novamente com um título válido.")
                                                            } else {
                                                                trello.renomearCartao(tituloCartao, novoTitulo)
                                                                println("Renomeado.")
                                                            }
                                                        }

                                                        //Arquivar cartão
                                                        "7" ->{

                                                            println("Escolha um cartão para arquivar:")
                                                            println(trello.verCartoes())
                                                            val titulo = readLine()!!.toString()

                                                            if (titulo.trim() == ""){
                                                                println("Forneça um título válido.")
                                                            } else {
                                                                trello.arquivarCartao(titulo)
                                                                println("$titulo arquivado.")
                                                            }
                                                        }

                                                        //Lista por nome os cartões arquivados
                                                        "8" ->{
                                                            println(trello.verCartoesArquivados())
                                                        }

                                                        //Lista por nome todos os cartões
                                                        "9" ->{

                                                        }

                                                        "0" -> {
                                                            trello.fecharLista()
                                                            println(segundoMenu)
                                                            break@loop3
                                                        }

                                                        "h" -> println(terceiroMenu)

                                                        else -> println("Opção inválida.")
                                                    }
                                                }
                                            }
                                        }

                                        //Ver listas
                                        "3" ->{
                                            println(trello.verListas())
                                        }

                                        //Copiar lista
                                        "4" ->{

                                            println("Qual lista deseja copiar?")
                                            println(trello.verListas())
                                            val nomeLista = readLine()!!.toString()

                                            if (nomeLista.trim() == ""){
                                                println("Título inválido. Tente novamente.")
                                            } else {
                                                trello.copiarLista(nomeLista)
                                                println("$nomeLista copiada.")
                                            }
                                        }

                                        //Todo Mover lista (mudar a posição)
                                        "5" ->{

                                            println("Qual lista deseja mover a posição?")
                                            println(trello.verListas())
                                            val titulo = readLine()!!.toString()
                                            println("Escolha a posição:")
                                            val posicao = readLine()!!.toInt()

                                            if (titulo.trim() == "" || posicao.toString().trim() == ""){
                                                println("Tente novamente com titúlo ou posição válida.")
                                            } else {
                                                trello.moverLista(titulo, posicao)
                                                println("Lista movida.")
                                            }
                                        }

                                        //Renomear
                                        "6" ->{

                                            println("Qual lista deseja renomear?")
                                            println(trello.verListas())
                                            val nomeLista = readLine()!!.toString()
                                            println("Atribua um novo título:")
                                            val novoTitulo = readLine()!!.toString()

                                            if (nomeLista.trim() == "" || novoTitulo.trim() == ""){
                                                println("Tente novamente com um nome válido.")
                                            } else{
                                                trello.renomearLista(nomeLista, novoTitulo)
                                                println("Renomeado.")
                                            }
                                        }

                                        //Arquivar lista
                                        "7" ->{
                                            println("Qual lista deseja arquivar?")
                                            println(trello.verListas())
                                            val nomeLista = readLine()!!.toString()

                                            if (nomeLista.trim() == ""){
                                                println("Título inválido. Tente novamente.")
                                            } else{
                                                trello.arquivarLista(nomeLista)
                                                println("$nomeLista arquivada")
                                            }
                                        }

                                        //Ver listas arquivadas
                                        "8" ->{

                                            println(trello.verListasArquivadas())
                                        }
                                        "0" -> {
                                            trello.fecharQuadro()
                                            println(primeroMenu)
                                            break@loop2
                                        }

                                        "h" -> println(segundoMenu)

                                        else -> println("Opção inválida.")

                                    }
                                }
                            }

                            //Arquivar
                            "4" ->{

                                println("Qual dos quadros deseja arquivar?")
                                println(trello.verQuadros())
                                val tituloQuadro = readLine()!!.toString()

                                trello.arquivarQuadro(tituloQuadro)
                                println("$tituloQuadro arquivado.")
                            }

                            //Ver quadros arquivados
                            "5" ->{

                                println(trello.verQuadrosArquivados())
                            }

                            //Copiar Quadro
                            "6" ->{

                                println("Qual quadro deseja copiar?")
                                println(trello.verQuadros())
                                val titulo = readLine()!!.toString()
                                println("Novo nome para o quadro:")
                                val novoTitulo = readLine()!!.toString()

                                println("Manter cartões? (y/n)")
                                val manterCartoes = readLine()!!.toString()
                                if (manterCartoes == "y"){

                                    trello.copiarQuadro(titulo, novoTitulo, manterCartoes)
                                    println("Quanro copiado")
                                } else {

                                    trello.copiarQuadro(titulo, novoTitulo, manterCartoes)
                                    println("Quadro copiado")
                                }
                            }

                            //Renomar quadro
                            "7" ->{
                                println("Qual quadro deseja renomear?")
                                println(trello.verQuadros())
                                val titulo = readLine()!!.toString()
                                println("Novo nome para o quadro:")
                                val novoTitulo = readLine()!!.toString()

                                if (titulo.trim() == "" || novoTitulo.trim() == ""){
                                    println("Tente novamente com um nome válido.")
                                } else {
                                    trello.renomearQuadro(titulo, novoTitulo)
                                    println("Renomeado.")
                                }
                            }

                            //Ver Logs
                            "8" ->{

                                println(trello.verLogs())
                            }

                            "h" -> println(primeroMenu)

                            "0" -> {
                                println(menuLogin)
                                trello.logout()
                                break@loop1
                            }

                            else -> println("Opção inválida.")
                        }
                    }

                } else println("E-mail/Nome de usuário ou senha incorretos.")
            }

            "2" ->{

                println("Nome:")
                val nome = readLine()!!.toString()
                println("E-mail:")
                val email = readLine()!!.toString()
                println("Senha:")
                val senha = readLine()!!.toString()

                if (nome.trim() == "" || email.trim() == "" || senha.trim() == "") {

                    println("Dados inválidos. Tente novamente\n$menuLogin")
                } else {

                    trello.novoCadastro(nome, email, senha)
                    println("Usuário cadastrado com sucesso!" +
                            "\nSeu nome de usuário é ${trello.gerarUsername(nome)}\n")
                }
            }
            "0" -> {
                println("Encerrado.")
                break@loop
            }

            else -> println("Opção inválida.")
        }
    }
}