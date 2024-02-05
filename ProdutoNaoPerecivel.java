package estoqueComProdutoPerecivelExcecoes;

public class ProdutoNaoPerecivel extends Exception {
	
	public ProdutoNaoPerecivel() {
		super("Produto nao perecivel");
	}
}
