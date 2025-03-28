public class Euro extends Moeda {

    public Euro(double valor) {
        super(valor, "Euro");
    }

    @Override
    public double converterParaReal() {
        return getValor() * 6.00;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Moeda: " + getTipo() + ", Valor: €" + getValor());
    }
}

