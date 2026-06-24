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
    private static GerenciamentoProdutos instance = null;
    private LinkedList<String> carrinho;
    private double total;

    private GerenciamentoProdutos() {
        this.produtos = new LinkedList<Produto>();
        this.carrinho = new LinkedList<String>();
        this.total = 0;
    }
    
    public static GerenciamentoProdutos getInstance() {
        if(instance == null)
            instance = new GerenciamentoProdutos();
        
        return instance;
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

    
    public void adicionarCarrinho(Produto produto, int quantidade) {
        String conteudo = "\nCódigo: " + produto.getNome()
                + "\nNome: " + produto.getNome()
                + "\nQuantidade: " + produto.getQuantidade()
                + "\nPreco: " + produto.getPreco();
        
        this.carrinho.add(conteudo);
        this.total += (produto.getPreco() * quantidade);
        produto.setQuantidade(produto.getQuantidade() - quantidade);
    }

    
    public String verCarrinho() {
        String conteudo = "";
        
        for(String compra : carrinho)
            conteudo += compra;
        
        return conteudo + "\nTotal: " + total + "\n";
    }

    public String verificarEstoque() {
        String conteudo = "";

        if(produtos.isEmpty())
            return "Nenhum produto no estoque";

        for(Produto produto : produtos)
            if(produto.getQuantidade() == 0)
                conteudo += "Código: " +
                        produto.getCodigo() +
                        " Nome: " + produto.getNome() +
                        " Descrição: " + produto.getDescricao() +
                        " Quantidade: " + produto.getQuantidade() +
                        " Preço: " + produto.getPreco() + "\n";

        if(conteudo.equals(""))
            return "O estoque possue itens";

        return conteudo;
    }

    public String verificarEstoque(int margem) {
        String conteudo = "";

        if(carrinho.isEmpty())
            return "Nenhum produto no estoque";

        for(Produto produto : produtos)
            if(produto.getQuantidade() <= margem)
                conteudo += "Código: " + produto.getCodigo() +
                        " Nome: " + produto.getNome() +
                        " Descrição: " + produto.getDescricao() +
                        " Quantidade: " + produto.getQuantidade() +
                        " Preço: " + produto.getPreco() + "\n";

        if(conteudo.equals(""))
            return "Os produtos possuem itens";

        return conteudo;
    }

    public String finalizarCompra() {
        String conteudo = "";
        
        for(String compra : carrinho)
            conteudo += compra;
        
        conteudo += "\nTotal: " + total
                + "Compra concluída com sucesso!\n";
        
        carrinho.clear();
        total = 0;
        
        return conteudo;
    }
}