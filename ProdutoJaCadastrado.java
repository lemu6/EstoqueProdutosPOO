package estoqueComProdutoPerecivelExcecoes;

public class ProdutoJaCadastrado extends Exception{
	
	public ProdutoJaCadastrado(int cod) {
		super("Produto Ja Cadastrado: " + cod);
	}
}
