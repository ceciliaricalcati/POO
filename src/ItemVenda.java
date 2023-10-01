

public class ItemVenda {

    private Produto produto;
    private int quantidade;


    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto(){
        return produto;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public double getValorItem(){
        return produto.getPrecoUnitario() * quantidade;
    }

    public int getNumero() {
        return 0;
    }
}
