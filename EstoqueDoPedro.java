package estoqueComProdutoPerecivelExcecoes;

import java.util.Date;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class EstoqueDoPedro {

	public ArrayList<Produto> produtos = new ArrayList<Produto>();

	public void incluir(Produto p) throws ProdutoJaCadastrado, DadosInvalidos {
		Produto p1;
		if (p.getCodigo() <= 0 ||
				p.getForn() == null || 
				p.getDescricao() == null ||
				p.getDescricao().equals("") ||
				p.getQuantidade() < 0 || 
				p.getEstoqueMinimo() < 0 ||
				p.getPrecoDeCompra() < 0 ||
				p.getPrecoDeVenda() < 0) {

			throw new DadosInvalidos();
		}

		try {
			p1 = pesquisar(p.getCodigo());
			throw new ProdutoJaCadastrado(p.getCodigo());
		} catch (ProdutoInexistente e){
			produtos.add(p);
		}

	}

	public void comprar(int cod, int quant, double preco, Date val) throws DadosInvalidos, ProdutoInexistente, ProdutoNaoPerecivel, ProdutoVencido {

		if (cod <= 0 || 
				quant <= 0 ||
				preco <= 0 
				) {
			throw new DadosInvalidos();
		}
		Produto p = pesquisar(cod); 
		if(val == null) {
			if(p instanceof ProdutoPerecivel) {
				throw new DadosInvalidos();	
			}else {
				p.compra(quant, preco);
			}
			
		}
		if(val != null) {
			if(p instanceof ProdutoPerecivel) {
				((ProdutoPerecivel) p).compra(quant, preco, val); 
			
			}
			if(!(p instanceof ProdutoPerecivel)) {
				throw new ProdutoNaoPerecivel();
			}
		}
	
	}

	public double vender(int cod, int quant) throws ProdutoInexistente, ProdutoVencido, DadosInvalidos {
		Produto p = pesquisar(cod);
		if(p instanceof ProdutoPerecivel) {
			if(p.quantidade < quant) {
			throw new ProdutoInexistente();
			}
		}
		if(p instanceof ProdutoPerecivel) {
			return ((ProdutoPerecivel) p).venda(quant);
		
		}else {
			return p.venda(quant);
		}
	}

	public Produto pesquisar(int cod) throws ProdutoInexistente{
		int i;
		for (i = 0; i < produtos.size(); i++) {
			if (cod == produtos.get(i).getCodigo()) {
				return produtos.get(i);
			}

		}
		throw new ProdutoInexistente();
	}
	public ArrayList<Produto> estoqueAbaixoDoMinimo() {
		ArrayList<Produto> produtosAbaixoMinimo = new ArrayList<Produto>();
		int i;
		for (i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getQuantidade() < produtos.get(i).getEstoqueMinimo()) {
				produtosAbaixoMinimo.add(produtos.get(i));
			}

		}
		return produtosAbaixoMinimo;
	}

	public int quantidadeVencidos(int cod) throws ProdutoNaoPerecivel, ProdutoInexistente {
		Produto p = pesquisar(cod);

		if(p instanceof ProdutoPerecivel) {
			p = (ProdutoPerecivel ) p; 
			return ((ProdutoPerecivel) p).quantidadeVencidos();	
		}else {
			throw new ProdutoNaoPerecivel();
		}

	}

	public ArrayList<Produto> estoqueVencido() {
		ArrayList<Produto> produtosVencidos = new ArrayList<Produto>();

		for (Produto produto : produtos) {
			if(produto instanceof ProdutoPerecivel) {
				if(((ProdutoPerecivel) produto).quantidadeVencidos()>0) {

					produtosVencidos.add(produto);
				}
			}

		}
		return produtosVencidos;
	}
}



