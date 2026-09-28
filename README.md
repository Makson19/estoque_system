# 📦 Sistema de Gerenciamento de Estoque (`estoque_system`)

Este projeto é um **Sistema de Gerenciamento de Estoque** desenvolvido em **Java** para a disciplina de **Paradigmas de Linguagens de Programação** (4º período - Unipê).

O objetivo principal do projeto é demonstrar na prática os conceitos fundamentais do **Paradigma Orientado a Objetos (POO)**, incluindo abstração, herança, polimorfismo, encapsulamento, interfaces e tratamento de exceções customizadas.

---

## 🚀 Funcionalidades

- **Cadastro de Produtos**: Suporte a produtos comuns e produtos perecíveis.
- **Validação de Dados**: Impede o cadastro de produtos com preço ou quantidade com valores negativos.
- **Controle de Vendas**: Permite realizar vendas com baixa automática no estoque e validação de disponibilidade.
- **Cálculo Automático do Valor em Estoque**:
  - Para **produtos comuns**, o valor é o preço unitário multiplicado pela quantidade.
  - Para **produtos perecíveis**, aplica-se automaticamente um **desconto de 20%** no valor total caso faltem 3 dias ou menos para a data de vencimento.
- **Tratamento de Exceções**: Mensagens de erro claras e amigáveis em cenários de dados inválidos ou estoque insuficiente.

---

## 🛠️ Estrutura do Projeto & Conceitos de POO

```text
estoque_system/
├── bin/                       # Arquivos compilados (.class)
├── src/                       # Código-fonte da aplicação
│   ├── Estoque.java           # Classe gerenciadora do estoque
│   ├── EstoqueApp.java        # Classe principal (main) com a demonstração do sistema
│   ├── EstoqueException.java  # Exceção base do sistema
│   ├── Product.java           # Classe abstrata base para produtos
│   ├── ProdutoComum.java      # Subclasse para produtos convencionais
│   ├── ProdutoIndisponivelException.java  # Exceção para vendas com estoque insuficiente
│   ├── ProdutoPerecivel.java  # Subclasse para produtos perecíveis (com regra de vencimento)
│   ├── QuantidadeInvalidaException.java   # Exceção para preços/quantidades inválidas
│   └── Vendavel.java          # Interface que define a capacidade de venda
└── README.md
```

### Conceitos Aplicados:
1. **Interface (`Vendavel`)**: Contrato que define a assinatura do método `vender(int quantidade)`.
2. **Classe Abstrata (`Product`)**: Implementa `Vendavel`, centraliza atributos (`nome`, `preco`, `quantidade`), métodos comuns e declara o método abstrato `calcularValorTotal()`.
3. **Herança e Polimorfismo**:
   - `ProdutoComum` e `ProdutoPerecivel` herdam de `Product` e sobrescrevem `calcularValorTotal()` com suas respectivas regras de negócio.
4. **Encapsulamento**: Atributos privados acessados/modificados via métodos getters e setters e métodos utilitários.
5. **Tratamento de Exceções Personalizadas**:
   - `EstoqueException` estende `Exception`.
   - `QuantidadeInvalidaException` e `ProdutoIndisponivelException` herdam de `EstoqueException`, categorizando falhas operacionais específicas.

---

## 💻 Como Executar

### Clonar o repositório

Clone este repositório utilizando o Git:

```bash
https://github.com/Makson19/estoque_system.git
```

Em seguida, entre na pasta do projeto:

```bash
cd estoque_system
```

### Pré-requisitos
- **Java JDK** instalado (versão 17 ou superior recomendada).

### Compilação e Execução

1. **Compilar os arquivos Java:**
   ```bash
   javac -d bin src/*.java
   ```

2. **Executar a aplicação:**
   ```bash
   java -cp bin EstoqueApp
   ```

---

## 📝 Exemplo de Saída

Ao executar a classe `EstoqueApp`, o sistema realiza as seguintes operações:
1. Cadastra produtos válidos e exibe a lista inicial.
2. Tenta cadastrar um produto inválido (capturando e exibindo o erro de quantidade negativa).
3. Processa vendas válidas e tenta realizar uma venda acima do limite em estoque (exibindo o aviso de indisponibilidade).
4. Atualiza e exibe o estoque final e o valor total acumulado.

---

## 📚 Tecnologias

- **Linguagem**: Java
- **IDE**: Visual Studio Code / Qualquer IDE Java compatível
