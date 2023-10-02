import java.util.Scanner;

public class App {
    private static final CatalogoProdutos catalogo = null;

    public static CatalogoProdutos getCatalogo() {
        return catalogo;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        
       
        
        // Cria um catálogo de produtos
        CatalogoProdutos catalogo = new CatalogoProdutos(10);
        Produto produto1 = new Produto(1, "Produto 1", 100.0);
        Produto produto2 = new Produto(2, "Produto 2", 50.0);
        Produto produto3 = new Produto(3, "Produto 3", 25.0);
        Produto produto4 = new Produto(4, "Produto 4", 150.0);
        Produto produto5 = new Produto(5, "Produto 5", 5.0);
        
        catalogo.cadastra(produto1);
        catalogo.cadastra(produto2);
        catalogo.cadastra(produto3);
        catalogo.cadastra(produto4);
        catalogo.cadastra(produto5);
        

        // Cria um estoque
        Estoque estoque = new Estoque(10);
        estoque.repoeEstoque(1, 50);
        estoque.repoeEstoque(2, 30);
        estoque.repoeEstoque(3, 10);
        estoque.repoeEstoque(4, 5);
        estoque.repoeEstoque(5, 2);


        // Cria uma venda
        Venda venda1 = new Venda(1, 10);
        venda1.insereItem(produto1, 3);
        venda1.insereItem(produto2, 2);
        venda1.fecha();

        // Insere a venda no histórico de vendas
        HistoricoVendas historico = new HistoricoVendas(10);
        historico.insere(venda1);

        // Testa a consulta de produtos no catálogo
        Produto produtoConsultado = catalogo.consulta(1);
        if (produtoConsultado != null) {
            System.out.println("Produto Consultado: " + produtoConsultado.getDescricao());
        } else {
            System.out.println("Produto não encontrado no catálogo.");
        }

        // Testa a consulta de quantidade em estoque
        int quantidadeEmEstoque = estoque.getQuantidade(1);
        System.out.println("Quantidade em Estoque (Produto 1): " + quantidadeEmEstoque);

        // Testa a consulta de última venda no histórico
        Venda ultimaVenda = historico.getUltimasVendas(1)[0];
        if (ultimaVenda != null) {
            System.out.println("Última Venda - Número: " + ultimaVenda.getNumero());
        } else {
            System.out.println("Nenhuma venda registrada no histórico.");


             //Menu do Programa
        Scanner scanner= new Scanner (System.in);
       // HistoricoVendas historico = new HistoricoVendas(10);
        Venda vendaAtual= null;

        // Cria um catálogo de produtos
        CatalogoProdutos catalogo = new CatalogoProdutos(10);
        Produto produto1 = new Produto(1, "Produto 1", 100.0);
        Produto produto2 = new Produto(2, "Produto 2", 50.0);
        Produto produto3 = new Produto(3, "Produto 3", 25.0);
        Produto produto4 = new Produto(4, "Produto 4", 150.0);
        Produto produto5 = new Produto(5, "Produto 5", 5.0);

        catalogo.cadastra(produto1);
        catalogo.cadastra(produto2);
        catalogo.cadastra(produto3);
        catalogo.cadastra(produto4);
        catalogo.cadastra(produto5);


        // Cria um estoque
        Estoque estoque = new Estoque(10);
        estoque.repoeEstoque(1, 50);
        estoque.repoeEstoque(2, 30);
        estoque.repoeEstoque(3, 10);
        estoque.repoeEstoque(4, 5);
        estoque.repoeEstoque(5, 2);


        // Cria uma venda
        Venda venda1 = new Venda(1, 10);
        venda1.insereItem(produto1, 3);
        venda1.insereItem(produto2, 2);
        venda1.fecha();

        // Insere a venda no histórico de vendas
        // HistoricoVendas historico = new HistoricoVendas(10);
        historico.insere(venda1);

        int opcao = 0;
        while (opcao!=7) {
            //Limpando o consele após uma seleção no Menu
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("---------MENU-------------");
            System.out.println("1- Abrir uma nova venda");
            System.out.println("2- Inserir um item de venda");
            System.out.println("3- Remover um item de venda (digite o n°)");
            System.out.println("4- Encerrar uma venda");
            System.out.println("5- Listar as últimas 5 vendas");
            System.out.println("6- Listar uma venda (Digete o n° do recibo)");
            System.out.println("7- Fim :) ");
            System.out.println(" Escolha uma opção");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                // Abrir uma nova venda
                int numeroVenda = historico.getUltimasVendas(1).length + 1;
                vendaAtual = new Venda(numeroVenda, 10);
                System.out.println("Venda " + numeroVenda + " aberta.");
                break;
            case 2:
                // Inserir um item de venda
                if (vendaAtual != null) {
                    System.out.print("Código do produto: ");
                    int codigoProduto = scanner.nextInt();
                    Produto produto = catalogo.consulta(codigoProduto);
                    if (produto != null) {
                        System.out.print("Quantidade: ");
                        int quantidade = scanner.nextInt();
                        vendaAtual.insereItem(produto, quantidade);
                        System.out.println("Item de venda inserido.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                } else {
                    System.out.println("Nenhuma venda aberta.");
                }
                break;
            case 3:
                // Remover um item de venda (pelo número)
                if (vendaAtual != null) {
                    System.out.print("Número do item a ser removido: ");
                    // Implemente a lógica para remover o item da vendaAtual
                    System.out.println("Item de venda removido.");
                } else {
                    System.out.println("Nenhuma venda aberta.");
                }
                break;
            case 4:
                // Fechar uma venda
                if (vendaAtual != null) {
                    vendaAtual.fecha();
                    historico.insere(vendaAtual);
                    System.out.println("Venda fechada. Recibo impresso:");
                    vendaAtual.imprimeRecibo();
                    vendaAtual = null; // Venda concluída
                } else {
                    System.out.println("Nenhuma venda aberta.");
                }
                break;
            case 5:
                // Listar as últimas 5 vendas
                Venda[] ultimasVendas = historico.getUltimasVendas(5);
                for (Venda venda : ultimasVendas) {
                    if (venda != null) {
                        System.out.println("Venda Número: " + venda.getNumero());
                    }
                }
                break;
            case 6:
                // Listar uma venda pelo número do recibo
                System.out.print("Número do recibo da venda: ");
                int numeroRecibo = scanner.nextInt();
                Venda venda = historico.getVenda(numeroRecibo);
                if (venda != null) {
                    System.out.println("Venda Número: " + venda.getNumero());
                } else {
                    System.out.println("Venda não encontrada.");
                }
                break;
            case 7:
                System.out.println("Encerrando o programa.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");

            }
        }       
        scanner.close();
<<<<<<< HEAD
=======

        // Testa a consulta de produtos no catálogo
        Produto produtoConsultado = catalogo.consulta(1);
        if (produtoConsultado != null) {
            System.out.println("Produto Consultado: " + produtoConsultado.getDescricao());
        } else {
            System.out.println("Produto não encontrado no catálogo.");
        }

        // Testa a consulta de quantidade em estoque
        int quantidadeEmEstoque = estoque.getQuantidade(1);
        System.out.println("Quantidade em Estoque (Produto 1): " + quantidadeEmEstoque);

        // Testa a consulta de última venda no histórico
        Venda ultimaVenda = historico.getUltimasVendas(1)[0];
        if (ultimaVenda != null) {
            System.out.println("Última Venda - Número: " + ultimaVenda.getNumero());
        } else {
            System.out.println("Nenhuma venda registrada no histórico.");
>>>>>>> 665811064428f783f91000198bf3be86d6ede881


            
        }
    }
}


