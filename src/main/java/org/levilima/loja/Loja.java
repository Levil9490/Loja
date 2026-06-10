package org.levilima.loja;

/**
 *
 * @author levi
 */
import org.levilima.control.GerenciamentoProdutos;
import org.levilima.model.Produto;
import javax.swing.JOptionPane;

public class Loja {
    public static void main(String[] args) {
        int quantidade;
        String nome, descricao, vencimento, categoria;
        double preco;
        boolean controle = true;
        int busca;
        Produto produto;

        GerenciamentoProdutos genProd = new GerenciamentoProdutos(5);

        while(controle) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Sistema de gerenciamento de produtos\n" +
                "Escolha uma opcao:\n" +
                "1 - Inserir produto\n" +
                "2 - Listar produtos\n" +
                "3 - Buscar produto\n" +
                "4 - Excluir produto\n" +
                "5 - Editar produto\n" +
                "6 - Adicionar ao carrinho\n" +
                "7 - Ver carrinho\n" +
                "8 - Verificar estoque\n" +
                "9 - Finalizar compra\n" +
                "0 - Sair"));

            switch(opcao) {
                case 0:
                    controle = false;
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    break;
                case 1:
                    nome = JOptionPane.showInputDialog("Digite o nome do produto:");
                    descricao = JOptionPane.showInputDialog("Digite a descricao do produto:");
                    preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preco do produto:"));
                    vencimento = JOptionPane.showInputDialog("Digite o vencimento do produto:");
                    quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto:"));
                    categoria = JOptionPane.showInputDialog("Digite a categoria do produto:");

                    produto = new Produto(nome, descricao, preco, vencimento, quantidade, categoria);
                    genProd.adicionarProduto(produto);

                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, genProd.listarProdutos());
                    break;
                case 3:
                    busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto:"));
                    produto = genProd.buscarProduto(busca);

                    if(genProd.buscarProduto(busca) == null) {
                        JOptionPane.showMessageDialog(null, "Produto não encontrado");
                    } else {
                        JOptionPane.showMessageDialog(null, produto.exibirProduto());
                    }

                    break;
                case 4:
                    busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto:"));
                    genProd.excluirProduto(busca);
                    break;
                case 5:
                    busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto: "));
                    produto = genProd.buscarProduto(busca);

                    if(produto == null) {
                        JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                    } else {
                        nome = JOptionPane.showInputDialog("Digite o nome do produto:");
                        descricao = JOptionPane.showInputDialog("Digite a descricao do produto:");
                        preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preco do produto:"));
                        vencimento = JOptionPane.showInputDialog("Digite o vencimento do produto:");
                        quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto:"));
                        categoria = JOptionPane.showInputDialog("Digite a categoria do produto:");
                        genProd.atualizarProduto(busca, nome, preco, quantidade, vencimento, categoria, descricao);
                    }
                    break;
                case 6:
                    busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto: "));
                    produto = genProd.buscarProduto(busca);

                    if(produto == null) {
                        JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                    } else {
                        quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto:"));
                        if(quantidade > produto.getQuantidade()) {
                            JOptionPane.showMessageDialog(null, "Quantidade indisponível.");
                        } else {
                            genProd.adicionarCarrinho(produto, quantidade);
                        }
                    }

                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, genProd.verCarrinho());
                    break;
                case 8:
                    int margem = Integer.parseInt(JOptionPane.showInputDialog("Digite a margem desejada:"));

                    if(margem == 0) {
                        JOptionPane.showMessageDialog(null, genProd.verificarEstoque());
                    } else {
                        JOptionPane.showMessageDialog(null, genProd.verificarEstoque(margem));
                    }

                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, genProd.finalizarCompra());
            }
        }
    }
}