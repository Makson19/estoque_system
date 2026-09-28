import java.util.ArrayList;
import java.util.List;

public class Estoque {
  private List<Product> produtos = new ArrayList<>();  

  public Estoque() {}

  public void adicionarProduto(Product p) {
    produtos.add(p);
  }

  public void venderProduto(int indice, int quantidade) throws ProdutoIndisponivelException {
    produtos.get(indice).vender(quantidade);
  }

  public double calcularValorTotalEstoque() {
    double total = 0.0;

    for(Product produto: produtos) {
      total += produto.calcularValorTotal();
    }

    return total;
  }

  public void getProdutos() {
    for (int i = 0; i < produtos.size(); i++) {
      System.out.println((i+1) + " - " + produtos.get(i).getDescricao());
    }
  }
}
