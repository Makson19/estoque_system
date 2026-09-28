public class EstoqueApp {
  public static void main(String[] args) throws Exception {
    Estoque estoque = new Estoque();

    // Cadastrando produtos válidos
    ProdutoComum arroz = new ProdutoComum("Arroz 5kg", 30.0, 15);
    ProdutoComum teclado = new ProdutoComum("Teclado", 350.0, 10);
    ProdutoPerecivel leite = new ProdutoPerecivel("Leite", 7.0, 15, 2);
    ProdutoPerecivel biscoito = new ProdutoPerecivel("Biscoito", 5.5, 8, 10);

    estoque.adicionarProduto(arroz);
    estoque.adicionarProduto(teclado);
    estoque.adicionarProduto(leite);
    estoque.adicionarProduto(biscoito);

    System.out.println("=== PRODUTOS CADASTRADOS ===");
    estoque.getProdutos();
    System.out.println("");


    // Cadastrando produto com quantidade negativa
    try {
      ProdutoComum mouse = new ProdutoComum("Mouse", 50.0, -5);
      estoque.adicionarProduto(mouse);
      System.out.println("");
    } catch (QuantidadeInvalidaException e) {
      System.out.println(e.getMessage());
    } catch (EstoqueException e) {
      System.out.println(e.getMessage());
    }


    // Venda válida e inválida
    try {
      estoque.venderProduto(0, 3);
      estoque.venderProduto(3, 10);
    } catch (ProdutoIndisponivelException e) {
      System.out.println(e.getMessage());
    }
    System.out.println("");
    estoque.getProdutos();
    System.out.println("");


    // Valor total do estoque
    System.out.println("=== VALOR TOTAL DO ESTOQUE ===");
    System.out.printf("Valor total: R$ %.2f%n", estoque.calcularValorTotalEstoque());
  }
}
