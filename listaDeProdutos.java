package estoqueComProdutoPerecivelExcecoes;
//package estoqueProdutos;
//
//import java.util.ArrayList;
//
//
//public class listaDeProdutos extends EstruturaDeDadosProdutos {
//
//    private Produto produto = null;
//
//    private listaDeProdutos prox = null;
//
//    private listaDeProdutos ini = null;
//
//    private int i = 0;
//
//    @Override
//    public void incluir(Produto p) {
//
//        if (produto == null) {
//            produto = p;
//            if(i == 0){
//                i++;
//                ini = prox;
//            }
//            prox = new listaDeProdutos();
//
//        }else{
//            prox.incluir(p);
//        }
//
//    }
//
//    @Override
//    public void comprar(int cod, int quant, double preco) throws DadosInvalidos {
//        pesquisar(cod).compra(quant, preco);
//    }
//
//    @Override
//    public double vender(int cod, int quant) throws ProdutoVencido, DadosInvalidos {
//        try {
//			return pesquisar(cod).venda(quant);
//		} catch (ProdutoInexistente e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return quant;
//    }
//
//    @Override
//    public Produto pesquisar(int cod) {
//        /*
//        int i;
//        for (i = 0; i < produtos.size(); i++) {
//            if (cod == produtos.get(i).getCodigo()) {
//                return produtos.get(i);
//            }
//
//        }
//        return null;
//    }*/
//        int i;
//        listaDeProdutos aux = ini;
//        while(aux.produto.getCodigo() != cod && produto != null){
//            aux = aux.prox;
//        }
//        return aux.produto;
//    }
//
//
//    @Override
//    public ArrayList<Produto> estoqueAbaixoDoMinimo() {
//       /*
//    ArrayList<Produto> produtosAbaixoMinimo = new ArrayList<Produto>();
//    int j;
//        for (j = 0; i < .size(); j++) {
//        if (produtos.get(j).getQuantidade() < .get(j).getEstoqueMinimo()) {
//            produtosAbaixoMinimo.add(produtos.get(j));
//        }
//
//    }
//        return produtosAbaixoMinimo;
//}
//
//     */
//        ArrayList<Produto> produtosAbaixoMinimo = new ArrayList<Produto>();
//
//        int i;
//        listaDeProdutos aux = ini;
//        while(aux.produto != null){
//            if(aux.produto.getQuantidade() < aux.produto.getEstoqueMinimo()){
//                produtosAbaixoMinimo.add(aux.produto);
//            }
//            aux = aux.prox;
//        }
//        return produtosAbaixoMinimo;
//
//    }
//}
