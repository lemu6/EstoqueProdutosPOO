package estoqueComProdutoPerecivelExcecoes;

import java.util.ArrayList;

public abstract class EstruturaDeDadosProdutos {
    public abstract void incluir(Produto p);

    public abstract void comprar(int cod, int quant, double preco) throws DadosInvalidos;

    public abstract double vender(int cod, int quant) throws ProdutoVencido, DadosInvalidos;

    public abstract Produto pesquisar(int cod);

    public abstract ArrayList<Produto> estoqueAbaixoDoMinimo();
    /*
    ArrayList<Produto> produtosAbaixoMinimo = new ArrayList<Produto>();
    int j;
        for (j = 0; i < .size(); j++) {
        if (produtos.get(j).getQuantidade() < .get(j).getEstoqueMinimo()) {
            produtosAbaixoMinimo.add(produtos.get(j));
        }

    }
        return produtosAbaixoMinimo;
}

     */
}
