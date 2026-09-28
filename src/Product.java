public abstract class Product implements Vendavel {
  private String nome;
  private double preco;
  private int quantidade;

  public Product(String nome, double preco, int quantidade) throws QuantidadeInvalidaException {
    if (preco < 0) {
      throw new QuantidadeInvalidaException("O preço não pode ser negativo.");
    }

    if (quantidade < 0) {
      throw new QuantidadeInvalidaException("A quantidade não pode ser negativa.");
    }

    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
  }

  public abstract double calcularValorTotal();

  public String getDescricao() {
    return "Nome: " + nome + " | " + "Preço: R$ " + preco + " | " + "Quantidade: " + quantidade;
  }

  @Override
  public void vender(int quantidadeDesejada) throws ProdutoIndisponivelException {
    if (quantidadeDesejada > quantidade) {
      throw new ProdutoIndisponivelException(
        "Quantidade indisponível para o produto '"
        + nome
        + "'. Estoque atual: "
        + quantidade
        + ", quantidade solicitada: "
        + quantidadeDesejada
        + "."
      );
    }
    quantidade -= quantidadeDesejada;
  }

  public void aplicarDesconto(double percentual) {
    preco -= preco * (percentual / 100.0);
  }

  public void aplicarDescont(double percentual, double descontoMaximo) {
    double percentualAplicado = 0.0;
    if (percentual > descontoMaximo) {
      percentualAplicado = descontoMaximo; 
    } else {
      percentualAplicado = percentual;
    }
    aplicarDesconto(percentualAplicado);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }
}
