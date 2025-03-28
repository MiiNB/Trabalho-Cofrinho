import java.util.ArrayList;

public class Cofre {
    // Lista para armazenar as moedas no cofre
    private ArrayList<Moeda> moedas = new ArrayList<>();

    // Método para adicionar moeda
    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda);
        System.out.println("Moeda " + moeda.getTipo() + " adicionada: " + moeda.getValor());
    }

    // Método para remover moeda
    public void removerMoeda(int posicao) {
        if (posicao >= 0 && posicao < moedas.size()) {
            Moeda moedaRemovida = moedas.remove(posicao);
            System.out.println("Moeda " + moedaRemovida.getTipo() + " removida: " + moedaRemovida.getValor());
        } else {
            System.out.println("Posição inválida!");
        }
    }

    // Método para exibir as moedas no cofre
    public void exibirMoedas() {
        if (moedas.isEmpty()) {
            System.out.println("O cofre está vazio.");
            return;
        }

        System.out.println("Moedas no cofre:");
        for (Moeda moeda : moedas) {
            moeda.exibirDetalhes();  // Exibe os detalhes de cada moeda
        }
    }

    // Método para calcular o total convertido para Real
    public double calcularTotalConvertido() {
        double totalConvertido = 0;
        for (Moeda moeda : moedas) {
            totalConvertido += moeda.converterParaReal();  // Converte o valor de cada moeda para R$
        }
        return totalConvertido;
    }

    // Método para verificar se o cofre está vazio
    public boolean isVazio() {
        return moedas.isEmpty();
    }

    // Retorna o tamanho do cofre
    public int tamanho() {
        return moedas.size();
    }
}
