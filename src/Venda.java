public class Venda {

    private int numero;
    private ItemVenda[] itens;
    private int quantItens;
    private static final double DESCONTO_PADRAO = 0.15; // 15% de desconto
    private static final double IMPOSTO = 0.25; // 25% de imposto

    public Venda(int numero, int tamanhoMaximoItens) {
        this.numero = numero;
        this.itens = new ItemVenda[tamanhoMaximoItens];
        this.quantItens = 0;
    }

    public int getNumero(){
        return numero;
    }

    public double getSubtotal() {
        double subtotal = 0.0;
        for (int i = 0; i < quantItens; i++) {
            subtotal += itens[i].getValorItem();
        }
        return subtotal;
    }

    public double getDesconto(){
        return getSubtotal() * DESCONTO_PADRAO;
    }

    public double getImposto(){
        return (getSubtotal() - getDesconto()) * IMPOSTO;
    }

    public double getTotalVenda() {
        return getSubtotal() - getDesconto() + getImposto();
    }

    public boolean insereItem(Produto produto, int quantidade) {
        if (quantItens < itens.length) {
            itens[quantItens] = new ItemVenda(produto, quantidade);
            quantItens++;
            return true; // Item inserido com sucesso
        }
        return false; // Não há espaço para mais itens
    }

    public boolean removeItem(int numeroItem) {
        for (int i = 0; i < quantItens; i++) {
            if (itens[i] != null && itens[i].getNumero() == numeroItem) {
                // Move os itens restantes para preencher o espaço do item removido
                for (int j = i; j < quantItens - 1; j++) {
                    itens[j] = itens[j + 1];
                }
                itens[quantItens - 1] = null; // Define a última posição como nula
                quantItens--; // Decrementa o contador de itens
                return true; // Item removido com sucesso
            }
        }
        return false; // Item com o número especificado não encontrado
    }
    

    public boolean fecha(){
        // Implemente a lógica para fechar a venda 
        return true;
        /*venda fechada
        não tem mais itens para adicionar nem remover
        */
    }

    public boolean imprimeRecibo(){
        if (fecha()) { //se a venda for fechada
        return true; //imrpime o recibo (após pergunta se gostaria de realizar outra compra, se não, finaliza o programa)
        } else {
        return false;
        }
    }
}
