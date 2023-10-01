public class ItemEstoque {
    private Produto produto;
    private int quantidade;

    public ItemEstoque (Produto produto, int quantidade) {
    this.produto = produto;
    this.quantidade = quantidade;
    }

    public Produto getProduto(){
        return produto;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public boolean baixaQuantidade(int quantidadeBaixa) {
        if (quantidade >= quantidadeBaixa) {
            quantidade -= quantidadeBaixa;
            return true;
        }
        return false;
    }

    public void reporQuantidade(int quantidadeReposta) {
        quantidade += quantidadeReposta;
    }
}
