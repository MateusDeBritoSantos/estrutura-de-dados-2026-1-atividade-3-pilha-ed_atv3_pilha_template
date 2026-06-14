import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = lerInteiro(scanner, "Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    executarExercicio01();
                    break;
                case 2:
                    executarExercicio02();
                    break;
                case 3:
                    executarExercicio03(scanner);
                    break;
                case 4:
                    executarExercicio04(scanner);
                    break;
                case 5:
                    executarExercicio05(scanner);
                    break;
                case 6:
                    executarExercicio06(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("=== Exercicios com Pilha ===");
        System.out.println("1 - Pilha com valores fixos");
        System.out.println("2 - Pilha de nomes");
        System.out.println("3 - Remover 10 numeros da pilha");
        System.out.println("4 - Menu interativo de pilha");
        System.out.println("5 - Inverter palavra com pilha");
        System.out.println("6 - Historico de navegacao");
        System.out.println("0 - Sair");
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);

            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }

            System.out.println("Entrada invalida. Digite um numero inteiro.");
            scanner.nextLine();
        }
    }

    public static Stack<Integer> criarPilhaValoresFixos() {
        Stack<Integer> pilha = new Stack<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        pilha.push(50);

        return pilha;
    }

    public static Stack<String> criarPilhaNomes() {
        Stack<String> pilha = new Stack<>();

        pilha.push("Ana");
        pilha.push("Carlos");
        pilha.push("Pedro");
        pilha.push("Juliana");

        return pilha;
    }

    public static List<Integer> removerTodosElementos(Stack<Integer> pilha) {
        List<Integer> removidos = new ArrayList<>();

        while (!pilha.empty()) {
            removidos.add(pilha.pop());
        }

        return removidos;
    }

    public static String inverterPalavra(String palavra) {
        Stack<Character> pilha = new Stack<>();
        StringBuilder palavraInvertida = new StringBuilder();

        for (int i = 0; i < palavra.length(); i++) {
            pilha.push(palavra.charAt(i));
        }

        while (!pilha.empty()) {
            palavraInvertida.append(pilha.pop());
        }

        return palavraInvertida.toString();
    }

    public static void visitarPagina(Stack<String> historico, String pagina) {
        if (pagina != null && !pagina.trim().isEmpty()) {
            historico.push(pagina);
        }
    }

    public static String voltarPagina(Stack<String> historico) {
        if (historico.empty()) {
            return null;
        }

        return historico.pop();
    }

    public static String paginaAtual(Stack<String> historico) {
        if (historico.empty()) {
            return null;
        }

        return historico.peek();
    }

    private static void executarExercicio01() {
        Stack<Integer> pilha = criarPilhaValoresFixos();

        System.out.println("Pilha completa: " + pilha);
        System.out.println("Elemento removido do topo: " + pilha.pop());
        System.out.println("Pilha apos remover o topo: " + pilha);
    }

    private static void executarExercicio02() {
        Stack<String> pilha = criarPilhaNomes();

        System.out.println("Topo da pilha: " + pilha.peek());
        System.out.println("Quantidade de elementos: " + pilha.size());
    }

    private static void executarExercicio03(Scanner scanner) {
        Stack<Integer> pilha = new Stack<>();

        for (int i = 1; i <= 10; i++) {
            int numero = lerInteiro(scanner, "Digite o " + i + "o numero inteiro: ");
            pilha.push(numero);
        }

        List<Integer> removidos = removerTodosElementos(pilha);

        System.out.println("Elementos removidos:");
        for (Integer numero : removidos) {
            System.out.println(numero);
        }
    }

    private static void executarExercicio04(Scanner scanner) {
        Stack<Integer> pilha = new Stack<>();
        int opcao;

        do {
            System.out.println("=== Menu Interativo de Pilha ===");
            System.out.println("1 - Empilhar");
            System.out.println("2 - Desempilhar");
            System.out.println("3 - Mostrar topo");
            System.out.println("4 - Mostrar pilha");
            System.out.println("5 - Sair");

            opcao = lerInteiro(scanner, "Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    int valor = lerInteiro(scanner, "Digite o valor para empilhar: ");
                    pilha.push(valor);
                    System.out.println("Valor empilhado: " + valor);
                    break;
                case 2:
                    if (pilha.empty()) {
                        System.out.println("A pilha esta vazia.");
                    } else {
                        System.out.println("Valor desempilhado: " + pilha.pop());
                    }
                    break;
                case 3:
                    if (pilha.empty()) {
                        System.out.println("A pilha esta vazia.");
                    } else {
                        System.out.println("Topo da pilha: " + pilha.peek());
                    }
                    break;
                case 4:
                    System.out.println("Pilha: " + pilha);
                    break;
                case 5:
                    System.out.println("Saindo do menu interativo.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

            System.out.println();
        } while (opcao != 5);
    }

    private static void executarExercicio05(Scanner scanner) {
        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine();

        System.out.println(palavra + " -> " + inverterPalavra(palavra));
    }

    private static void executarExercicio06(Scanner scanner) {
        Stack<String> historico = new Stack<>();
        int opcao;

        do {
            System.out.println("=== Historico de Navegacao ===");
            System.out.println("1 - Visitar pagina");
            System.out.println("2 - Voltar pagina");
            System.out.println("3 - Mostrar pagina atual");
            System.out.println("4 - Exibir historico");
            System.out.println("5 - Sair");

            opcao = lerInteiro(scanner, "Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    System.out.print("Digite a pagina: ");
                    String pagina = scanner.nextLine();
                    visitarPagina(historico, pagina);
                    System.out.println("Pagina visitada: " + pagina);
                    break;
                case 2:
                    String removida = voltarPagina(historico);

                    if (removida == null) {
                        System.out.println("Nao ha paginas no historico.");
                    } else {
                        System.out.println("Pagina removida: " + removida);

                        String atual = paginaAtual(historico);
                        if (atual == null) {
                            System.out.println("Nenhuma pagina atual.");
                        } else {
                            System.out.println("Pagina atual: " + atual);
                        }
                    }
                    break;
                case 3:
                    String atual = paginaAtual(historico);

                    if (atual == null) {
                        System.out.println("Nenhuma pagina atual.");
                    } else {
                        System.out.println("Pagina atual: " + atual);
                    }
                    break;
                case 4:
                    System.out.println("Historico: " + historico);
                    break;
                case 5:
                    System.out.println("Saindo do historico de navegacao.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

            System.out.println();
        } while (opcao != 5);
    }
}
