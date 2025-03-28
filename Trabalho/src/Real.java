public class Real extends Moeda {

    public Real(double valor) {
        super(valor, "Real");
    }

    @Override
    public double converterParaReal() {
        return getValor(); // Já é Real, então não precisa de conversão
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Moeda: " + getTipo() + ", Valor: R$" + getValor());
    }
}
