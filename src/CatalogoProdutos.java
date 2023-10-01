public class CatalogoProdutos {
    private Produto[] produtos;

    public CatalogoProdutos(int tamanhoMaximo) {
        produtos = new Produto[tamanhoMaximo];
    }

    public Produto consulta(int codigo) {
        for (Produto produto : produtos) {
            if (produto != null && produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null; //produto com o código especificado não encontrado no catálogo
    }

    public boolean cadastra(Produto produto) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] == null) {
                produtos[i] = produto;
                return true;
            }
        }
        return false; // Não há espaço para cadastrar o produto
    }
}