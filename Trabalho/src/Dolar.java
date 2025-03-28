public class Dolar extends Moeda {

    public Dolar(double valor) {
        super(valor, "Dólar");
    }

    @Override
    public double converterParaReal() {
        return getValor() * 5.50;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Moeda: " + getTipo() + ", Valor: $" + getValor());
    }
}
