public class ProdutoPerecivel extends Product {
  private int diasParaVencer;

  public ProdutoPerecivel(String nome, double preco, int quantidade, int diasParaVencer) throws QuantidadeInvalidaException {
    super(nome, preco, quantidade);
    this.diasParaVencer = diasParaVencer;
  }

  @Override
  public double calcularValorTotal() {
    double total = getPreco() * getQuantidade();

    if (diasParaVencer <= 3) {
      total *= 0.80; 
    }

    return total;
  }

  @Override
  public String getDescricao() {
    return "Nome: " + getNome() + " | " + "Preço: R$ " + getPreco() + " | " + "Quantidade: " + getQuantidade() + " | " + "Dias para vencer: " + diasParaVencer;
  }

  public int getDiasParaVencer() {
    return diasParaVencer;
  }
}
