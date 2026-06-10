package org.levilima.model;

import org.levilima.control.GerenciamentoProdutos;

/**
*
* @author levi
*/
public class Produto {
    private int codigo = 200;
    private String nome;
    private String descricao;
    private double preco;
    private String vencimento;
    private int quantidade;
    private String categoria;
	
    public Produto(String nome, String descricao, double preco, String vencimento, int quantidade, String categoria) {
        this.codigo = GerenciamentoProdutos.CODIGO;
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setVencimento(vencimento);
        this.setQuantidade(quantidade);
        this.setCategoria(categoria);
        ++GerenciamentoProdutos.CODIGO;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        if(preco >= 0) this.preco = preco;
    }

    public String getVencimento() {
        return this.vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade >= 0) {
            this.quantidade = quantidade;
        }
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String exibirProduto() {
        String conteudo = "Codigo: " + this.codigo +
                        " Nome: " + this.nome +
                        " Preco: " + this.preco +
                        " Quantidade: " + this.quantidade +
                        " Vencimento: " + this.vencimento +
                        " Categoria: " + this.categoria +
                        " Descricao: " + this.descricao;
        return conteudo;
    }
}