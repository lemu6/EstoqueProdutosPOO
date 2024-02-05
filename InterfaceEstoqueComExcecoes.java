package estoqueComProdutoPerecivelExcecoes;

import java.sql.Date;
import java.util.ArrayList;

public interface InterfaceEstoqueComExcecoes {
	
	public void incluir(Produto p) throws ProdutoJaCadastrado, DadosInvalidos;
	
	public void comprar(int cod, int quant, double preco, Date val) throws ProdutoInexistente, DadosInvalidos, ProdutoNaoPerecivel;
	
	public double vender(int cod, int quant) throws ProdutoInexistente, ProdutoVencido, DadosInvalidos;

	public Produto Pesquisar(int cod) throws ProdutoInexistente;
	
	public ArrayList<Produto> EstoqueAbaixoDoMinimo();
	
	public ArrayList<Produto> estoqueVencido();
	
	public int quantidadedeVencidos(int cod) throws ProdutoInexistente;
	

}
