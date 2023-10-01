public class Estoque {
    private ItemEstoque[] itens;

    // Construtor da classe Estoque
    public Estoque(int tamanhoMaximo) {
        itens = new ItemEstoque[tamanhoMaximo];
    }
    
    public ItemEstoque[] getItens() {
        return itens;
    }

    public void setItens(ItemEstoque[] itens) {
        this.itens = itens;
    }

    public int getQuantidade(int codigo) {
        for (ItemEstoque item : itens) {
            if (item != null && item.getProduto().getCodigo() == codigo) {
                return item.getQuantidade();
            }
        }
        return 0; // Produto não encontrado no estoque
    }

    public boolean baixaEstoque(int codigo, int quantidade) {
        for (ItemEstoque item : itens) {
            if (item != null && item.getProduto().getCodigo() == codigo) {
                if (item.baixaQuantidade(quantidade)) {
                    return true; // Baixa de estoque realizada com sucesso
                }
                return false; // Não há quantidade suficiente em estoque
            }
        }
        return false; // Produto com o código especificado não encontrado no estoque
    }

    public boolean repoeEstoque(int codigo, int quantidade) {
        for (ItemEstoque item : itens) {
            if (item != null && item.getProduto().getCodigo() == codigo) {
                item.reporQuantidade(quantidade);
                return true;
            }
        }
        return false; //produto com o código especificado não encontrado
    }

    public boolean verificarDisponibilidade(Produto produto, double quantidade) {
        return false;
    }

    public void adicionarProduto(Produto produto1, int i) {
    }
}
