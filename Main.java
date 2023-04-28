import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Arquivo arquivo = new Arquivo();
      Menu menu = new Menu();
      String nomeArquivo = "";

      // Solicita o nome do arquivo de dados ao usuário
     int opcaoMenu = -1;
  while(opcaoMenu != 0){
     menu.exibirMenuArquivos();
     opcaoMenu = scanner.nextInt();      // recebe a resposta do usuario e salva na variavel opcaoMenu
     scanner.nextLine();                 // consome a quebra de linha

     if(opcaoMenu == 1){
        arquivo.criarArquivo();
        nomeArquivo = arquivo.getNomeArquivo();
     } else if (opcaoMenu == 2){
        arquivo.selecionarArquivo();
        nomeArquivo = arquivo.getNomeArquivo();
     } else if (opcaoMenu == 0) {
        // Cria o gerenciador de tarefas a partir do nome do arquivo fornecido
        GerenciadorTarefas gerenciador = new GerenciadorTarefas(nomeArquivo);

        int opcaoTarefa = 1;
        while (opcaoTarefa != 0) {             //
           menu.exibirMenuTarefas();           // Apresenta as opções de operação disponíveis
           opcaoTarefa = scanner.nextInt();    // Lê a opção escolhida pelo usuário
           scanner.nextLine();                 // consome a quebra de linha

           if (opcaoTarefa == 1) {
              // Solicita o título e a descrição da tarefa ao usuário
              String titulo = Utils.lerTexto("Digite o título da tarefa:");
              String descricao = Utils.lerTexto("Digite a descrição da tarefa:");

              // Cria uma nova tarefa com os dados fornecidos e a adiciona ao gerenciador
              Tarefa tarefa = new Tarefa(titulo, descricao);
              gerenciador.adicionarTarefa(tarefa);

              // Informa ao usuário que a tarefa foi adicionada com sucesso
              Utils.imprimirTexto("Tarefa adicionada com sucesso!");
           
           } else if (opcaoTarefa == 2) {
              Tarefa tarefaSelecionada = gerenciador.selecionarTarefa();
              if (tarefaSelecionada != null) {
                 gerenciador.concluirTarefa(tarefaSelecionada);
                 Utils.imprimirTexto("Tarefa concluída com sucesso.");
              } else {
                 Utils.imprimirTexto("Nenhuma tarefa selecionada.");
              }
           } else if (opcaoTarefa == 3) {
              // Exibe as tarefas pendentes ao usuário
              gerenciador.exibirTarefasPendentes();
           } else if (opcaoTarefa == 4) {
              // Exibe as tarefas concluídas ao usuário
              gerenciador.exibirTarefasConcluidas();
           } else if (opcaoTarefa == 5) {
              // Busca tarefas por palavra-chave
              String palavraChave = Utils.lerTexto("Digite a palavra-chave:");
              List<Tarefa> tarefasEncontradas = gerenciador.buscarTarefa(palavraChave);
              if (tarefasEncontradas.isEmpty()) {
                 Utils.imprimirTexto("Não foram encontradas tarefas com a palavra-chave informada.");
              } else {
                 Utils.imprimirTexto("Tarefas encontradas:");
                 for (Tarefa tarefa int tarefasEncontradas) {
                  Utils.imprimirTexto("- " + tarefa.getTitulo() + " - " + tarefa.getDescricao());
                  }
                  }
                  } else if (opcaoTarefa == 0) {
                  // Encerra o programa
                  Utils.imprimirTexto("Saindo...");
                  } else {
                  // Informa ao usuario que a opção é invalida
                  Utils.imprimirTexto("Opção inválida.");
                  }
                  }
                  } else {
                  // opção inválida
                  Utils.imprimirTexto("Opção inválida.");
                  }
                  }
                  scanner.close();
                  }
}