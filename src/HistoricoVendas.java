public class HistoricoVendas {
    private Venda[] vendas; // Um array para armazenar as vendas

    // Construtor da classe HistóricoVendas
    public HistoricoVendas(int tamanhoMaximo) {
        vendas = new Venda[tamanhoMaximo];
    }

    // Método para inserir uma venda no histórico
    public boolean insere(Venda venda) {
        // Encontra a primeira posição vazia no array de vendas
        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i] == null) {
                vendas[i] = venda;
                return true; // Venda inserida com sucesso
            }
        }
        return false; // Não há espaço para inserir a venda
    }

    // Método para obter as últimas N vendas
    public Venda[] getUltimasVendas(int n) {
        int tamanho = Math.min(n, vendas.length);
        Venda[] ultimasVendas = new Venda[tamanho];

        // Copia as últimas vendas para o array 'ultimasVendas'
        for (int i = vendas.length - tamanho, j = 0; i < vendas.length; i++, j++) {
            ultimasVendas[j] = vendas[i];
        }

        return ultimasVendas;
    }

    // Método para obter uma venda pelo número
    public Venda getVenda(int numero) {
        for (Venda venda : vendas) {
            if (venda != null && venda.getNumero() == numero) {
                return venda;
            }
        }
        return null; // Venda não encontrada
    }
}


/*public class HistoricoVendas {
    //private vendas[]:Venda
    Venda vendas = new Venda();
    private int n;

    public boolean insere(Venda vendas){
        return true;
    }

    
    // * @param n
    // * @return
    
    public Venda[] getUltimasVendas(int n){
            n é a quantidade de vendas que quer vizualizar
            (das últimas, ou seja, de trás pra frente)
            ex são 10 vendas no total e quero saber quais foram as 3 últimas
            retorna venda[9], venda[8] e venda[7]
            precisa de repetição e ifs para o caso de só haver 1 venda ou nenhuma
            
        return Venda[];
    }

    public Venda getVenda(int numero){
        return getVenda(0);
    }

}
 */