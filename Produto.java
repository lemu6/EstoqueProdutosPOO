package estoqueComProdutoPerecivelExcecoes;

import java.util.ArrayList;

public class Produto {
    private int cod;
    private String desc;
    private int min;
    private double lucro;
    private Fornecedor forn;
    private double PrecoDeCompra;
    private double PrecoDeVenda;
    protected int quantidade;

    ArrayList<Produto> produtos = new ArrayList<Produto> ();

    public  Produto(int cod, String desc, int min, double lucro, Fornecedor forn) {
        this.cod = cod;
        this.desc = desc;
        this.min = min;
        this.lucro = lucro;
        setForn(forn);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quant){
        this.quantidade = quant;
    }

    public double getPrecoDeVenda() {
        return PrecoDeVenda;
    }

    public void setPrecoDeVenda(double precoDeVenda) {
        PrecoDeVenda = precoDeVenda;
    }

    public double getPrecoDeCompra() {
        return PrecoDeCompra;
    }

    public void setPrecoDeCompra(double precoDeCompra) {
        PrecoDeCompra = precoDeCompra;
    }

    public Fornecedor getForn() {
        return forn;
    }

    public void setForn(Fornecedor forn) {
        this.forn = forn;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public int getEstoqueMinimo() {
        return min;
    }

    public void setEstoqueMinimo(int estoqueMínimo) {
        min = estoqueMínimo;
    }

    public String getDescricao() {
        return desc;
    }

    public void setDescricao(String descrição) {
        this.desc = descrição;
    }

    public int getCodigo() {
        return cod;
    }

    public void setCodigo(int código) {
        this.cod = código;
    }

    public void compra(int quant, double val) throws DadosInvalidos{
    	
        if(quant>=0 || val > 0){
            this.quantidade+= quant;
            setPrecoDeCompra(((quantidade - quant)*getPrecoDeCompra() + quant*val)/quantidade);
            setPrecoDeVenda(this.PrecoDeCompra *(1 + this.lucro));
        }else{
            throw new DadosInvalidos();
        }
    }

    public double venda(int quant) throws ProdutoInexistente, ProdutoVencido, DadosInvalidos{
      if(quant <= this.getQuantidade()){
          double valor = quant * getPrecoDeVenda();
          setQuantidade(getQuantidade() - quant);
          return valor;
      }else{
          throw new DadosInvalidos();
      }
  }
}