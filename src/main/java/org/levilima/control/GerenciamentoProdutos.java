package org.levilima.control;

import java.util.LinkedList;
import org.levilima.model.Produto;

/**
*
* @author levi
*/
public class GerenciamentoProdutos {
    private LinkedList<Produto> produtos;
    private int tamanho;
    private int id;
    public static int CODIGO = 200;
    private String carrinho;
    private double total;

    public GerenciamentoProdutos() {
        this.produtos = new LinkedList<Produto>();
        this.carrinho = "";
        this.total = 0;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public String listarProdutos() {
        String conteudo = "";

        for(Produto produto : this.produtos)
            conteudo += produto.exibirProduto() + "\n\n";

        return conteudo;
    }

    public Produto buscarProduto(int codigo) {
        for(Produto produto : this.produtos)
            if(produto.getCodigo() == codigo)
                return produto;

        return null;
    }

    public void excluirProduto(int codigo) {
        for(Produto produto : this.produtos) {
            if(produto.getCodigo() == codigo) {
                this.produtos.remove(produto);
                return;
            }
        }
    }

    public void atualizarProduto(int codigo, String nome, double preco, int quantidade, String vencimento, String categoria, String descricao) {
        for(Produto produto : this.produtos) {
            if(codigo == produto.getCodigo()) {
                produto.setNome(nome);
                produto.setPreco(preco);
                produto.setQuantidade(quantidade);
                produto.setVencimento(vencimento);
                produto.setCategoria(categoria);
                produto.setDescricao(descricao);
            }
        }
    }

    /*
    public void adicionarCarrinho(Produto produto, int quantidade) {
        this.carrinho += "\nCodigo: " + produto.getCodigo() + "\tNome: " + produto.getNome() + "\tQuantidade: " + quantidade + "\tPreço: " + (produto.getPreco() * quantidade) + "\n";
        this.total += (produto.getPreco() * quantidade);
        produto.setQuantidade(produto.getQuantidade() - quantidade);
    }

    public String verCarrinho() {
        return this.carrinho + "Total: " + this.total + "\n";
    }

    public String verificarEstoque() {
        String conteudo = "";

        if(this.id == 0) return "Nenhum produto no estoque";

        for(int i = 0; i < this.id; ++i)
                if(this.produtos[i].getQuantidade() == 0)
                        conteudo += "Código: " + this.produtos[i].getCodigo() + " Nome: " + this.produtos[i].getNome() + " Descrição: " + this.produtos[i].getDescricao() + " Quantidade: " + this.produtos[i].getQuantidade() + " Preço: " + this.produtos[i].getPreco() + "\n";

        if(conteudo.equals("")) return "Os produtos possuem itens";

        return conteudo;
    }

    public String verificarEstoque(int margem) {
        String conteudo = "";

        if(this.id == 0) return "Nenhum produto no estoque";

        for(int i = 0; i < this.id; ++i)
            if(this.produtos[i].getQuantidade() <= margem)
                    conteudo += "Código: " + this.produtos[i].getCodigo() + " Nome: " + this.produtos[i].getNome() + " Descrição: " + this.produtos[i].getDescricao() + " Quantidade: " + this.produtos[i].getQuantidade() + " Preço: " + this.produtos[i].getPreco() + "\n";

        if(conteudo.equals("")) return "Os produtos possuem itens";

        return conteudo;
    }

    public String finalizarCompra() {
        String conteudo = this.carrinho + "\nTotal" + this.total + "\nCompra concluída com sucesso!\n";
        this.carrinho = "";
        this.total = 0;
        return conteudo;
    }
    */
}