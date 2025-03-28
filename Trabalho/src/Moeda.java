public abstract class Moeda {
  protected double valor;
  protected String tipo;

  // Construtor da classe Moeda
  public Moeda(double valor, String tipo) {
      this.valor = valor;
      this.tipo = tipo;
  }

  // Métodos getters para acessar os atributos
  public double getValor() {
      return valor;
  }

  public String getTipo() {
      return tipo;
  }

  // Método abstrato para converter a moeda para Real
  public abstract double converterParaReal();

  // Método abstrato para exibir os detalhes da moeda
  public abstract void exibirDetalhes();  // Agora está abstrato
}
