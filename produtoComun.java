package estoqueComProdutoPerecivelExcecoes;

public class produtoComun extends Produto{
    public produtoComun(int código, String descrição, int estoqueMínimo, double lucro, Fornecedor forn) {
        super(código, descrição, estoqueMínimo, lucro, forn);
    }

    public double venda(int quant) throws DadosInvalidos{
        if(quant <= this.getQuantidade()){
            double valor = quant * getPrecoDeVenda();
            setQuantidade(getQuantidade() - quant);
            return valor;
        }else{
           throw new DadosInvalidos();
        }
    }

    public void compra(int quant, double val) throws DadosInvalidos{
        if(quant>=0 || val > 0){
            int newquant = getQuantidade() + quant;
            setQuantidade(newquant);
            setPrecoDeCompra(((getQuantidade() - quant)*getPrecoDeCompra() + quant*val)/getQuantidade());
            setPrecoDeVenda(getPrecoDeCompra() *(1 + getLucro()));
        }else{
            throw new DadosInvalidos();
        }
    }
}
