import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    // Lista para armazenar as moedas no cofre
    private static ArrayList<Moeda> cofre = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu Cofrinho ---");
            System.out.println("1 - Adicionar moeda");
            System.out.println("2 - Remover moeda");
            System.out.println("3 - Exibir moedas");
            System.out.println("4 - Calcular total convertido");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            processarOpcao(opcao, scanner);
        } while (opcao != 0);

        scanner.close();
    }

    private static void processarOpcao(int opcao, Scanner scanner) {
        switch (opcao) {
            case 1:
                System.out.println("Opção de adicionar moeda selecionada.");
                adicionarMoeda(scanner);
                break;
            case 2:
                System.out.println("Opção de remover moeda selecionada.");
                removerMoeda(scanner);
                break;
            case 3:
                System.out.println("Opção de exibir moedas selecionada.");
                exibirMoedas();
                break;
            case 4:
                System.out.println("Opção de calcular total selecionada.");
                calcularTotalConvertido();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    // Método para adicionar moeda
    private static void adicionarMoeda(Scanner scanner) {
        System.out.println("Escolha o tipo de moeda:");
        System.out.println("1 - Dólar");
        System.out.println("2 - Euro");
        System.out.println("3 - Real");
        int tipoMoeda = scanner.nextInt();
        System.out.print("Informe o valor da moeda: ");
        double valor = scanner.nextDouble();

        Moeda moeda = null;
        switch (tipoMoeda) {
            case 1:
                moeda = new Dolar(valor);
                break;
            case 2:
                moeda = new Euro(valor);
                break;
            case 3:
                moeda = new Real(valor);
                break;
            default:
                System.out.println("Tipo de moeda inválido!");
                return;
        }

        cofre.add(moeda);
        System.out.println("Moeda adicionada: " + moeda.getTipo() + " " + moeda.getValor());
    }

    // Método para remover moeda
    private static void removerMoeda(Scanner scanner) {
        if (cofre.isEmpty()) {
            System.out.println("O cofre está vazio.");
            return;
        }

        System.out.println("Escolha a posição da moeda para remover (1 a " + cofre.size() + "): ");
        int posicao = scanner.nextInt() - 1;  // Ajuste da indexação, pois ArrayList começa em 0

        if (posicao >= 0 && posicao < cofre.size()) {
            Moeda moedaRemovida = cofre.remove(posicao);
            System.out.println("Moeda removida: " + moedaRemovida.getTipo() + " " + moedaRemovida.getValor());
        } else {
            System.out.println("Posição inválida!");
        }
    }

    // Método para exibir as moedas no cofre
    private static void exibirMoedas() {
        if (cofre.isEmpty()) {
            System.out.println("O cofre está vazio.");
            return;
        }

        System.out.println("Moedas no cofre:");
        for (Moeda moeda : cofre) {
            moeda.exibirDetalhes();  // Exibe os detalhes de cada moeda
        }
    }

    // Método para calcular o total convertido para Real
    private static void calcularTotalConvertido() {
        if (cofre.isEmpty()) {
            System.out.println("O cofre está vazio.");
            return;
        }

        double totalConvertido = 0;
        for (Moeda moeda : cofre) {
            totalConvertido += moeda.converterParaReal();  // Converte o valor de cada moeda para R$
        }

        System.out.println("Total convertido para Real: R$ " + totalConvertido);
    }
}
