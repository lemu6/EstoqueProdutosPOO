package estoqueComProdutoPerecivelExcecoes;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class ProdutoPerecivel extends Produto{

	ArrayList<Lote> lotes = new ArrayList<Lote> ();

	public ProdutoPerecivel(int cod, String desc, int min, double lucro, Fornecedor forn) {
		super(cod, desc, min, lucro, forn);
	}

//	public double venda(int quant) throws ProdutoVencido {
//		int quantProdutos = 0;
//		Date hoje = Date.from(Instant.now(Clock.system(ZoneId.of("America/Sao_Paulo"))));
//		for (Lote lote : lotes) {
//			if(lote.getValidade().after(hoje)) {
//
//				quantProdutos+=lote.getQuant();
//			}
//		}
//
//		if(quantProdutos < quant) {
//			throw new ProdutoVencido();
//		}else {
//			int q = getQuantidade();
//
//			q -= quant;
//			setQuantidade(q);
//
//			for (Lote lote : lotes) {
//				if(lote.getValidade().after(hoje)){
//
//					if(lote.getQuant() >= quant) {
//						lote.setQuant(lote.getQuant()-quant);
//						quant -= lote.getQuant();
//					}else {
//
//						lote.setQuant(0);
//						quant -= lote.getQuant();
//					}
//					if (quant <= 0) {
//						break;
//					}
//				}
//				if (quant <= 0) {
//					break;
//				}
//
//			}
//			
//			}
//		
//	return (quant * getPrecoDeVenda());
//}
	
	public double venda(int quant) throws ProdutoVencido {
		Date dataAtual =  new Date();
		ArrayList<Lote> lotesVendidos = new ArrayList<Lote>();
		int quantEmEstoque = 0;
		for (Lote lote : lotes) {
			if (lote.getValidade().after(dataAtual) && quantEmEstoque < quant) {
				quantEmEstoque += lote.getQuant();
				lotesVendidos.add(lote);
			}
		}
		if (quantEmEstoque >= quant) {
			quantEmEstoque = quant;
			for (Lote lote : lotesVendidos) {
				if (lote.getValidade().after(dataAtual) && quantEmEstoque >= 0) {
					if (lote.getQuant() - quantEmEstoque <= 0) {
						quantEmEstoque -= lote.getQuant();
						lote.setQuant(0);
					} else {
						lote.setQuant(lote.getQuant() - quantEmEstoque);
						quantEmEstoque = 0;
					}
				}
			}
			quantidade -= quant;
			return quant * getPrecoDeVenda();
		} else {
			throw new ProdutoVencido();
		}
	}

public void compra(int quant, double val, Date date) throws DadosInvalidos{
	if(quant>=0 || val > 0){

		int newquant = getQuantidade() + quant;
		setQuantidade(newquant);
		setPrecoDeCompra(((quantidade - quant)*getPrecoDeCompra() + quant*val)/quantidade);
		setPrecoDeVenda(getPrecoDeCompra() *(1 + this.getLucro()));

		Lote l = new Lote(quant, date);
		lotes.add(l);
	}else{
		throw new DadosInvalidos();
		//System.out.println("Impossível realizar a compra!");
	}
}

public int quantidadeVencidos() {
	Date dataAtual = Date.from(Instant.now(Clock.system(ZoneId.of("America/Sao_Paulo"))));
	int quantVenci = 0;
	for (Lote lote : lotes) {
		if(lote.getValidade().before(dataAtual)) {
			quantVenci+=lote.getQuant();
		}
	}
	return quantVenci;
}
}
