package estoqueComProdutoPerecivelExcecoes;

public class Fornecedor {
    private int cnpj;
    private String nome;

    public Fornecedor(int cod, String nome){
        this.cnpj = cod;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
