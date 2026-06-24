package org.levilima.view;

import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import org.levilima.control.GerenciamentoProdutos;
import org.levilima.model.Produto;

/**
 *
 * @author levi
 */
public class Home extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Home.class.getName());

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdicionarProduto = new JButton();
        btnBuscarProduto = new JButton();
        btnAtualizarProduto = new JButton();
        btnListarProdutos = new JButton();
        btnExcluirProduto = new JButton();
        btnCarrinho = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnAdicionarProduto.setText("Adcionar Produto");
        btnAdicionarProduto.addActionListener(this::btnAdicionarProdutoActionPerformed);

        btnBuscarProduto.setText("Buscar Produto");
        btnBuscarProduto.addActionListener(this::btnBuscarProdutoActionPerformed);

        btnAtualizarProduto.setText("Atualizar Produto");
        btnAtualizarProduto.addActionListener(this::btnAtualizarProdutoActionPerformed);

        btnListarProdutos.setText("Listar Produtos");
        btnListarProdutos.addActionListener(this::btnListarProdutosActionPerformed);

        btnExcluirProduto.setText("Excluir Produto");
        btnExcluirProduto.addActionListener(this::btnExcluirProdutoActionPerformed);

        btnCarrinho.setText("Carrinho");
        btnCarrinho.addActionListener(this::btnCarrinhoActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAtualizarProduto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdicionarProduto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluirProduto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnListarProdutos, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(btnBuscarProduto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCarrinho, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarProduto)
                    .addComponent(btnBuscarProduto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizarProduto)
                    .addComponent(btnListarProdutos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirProduto)
                    .addComponent(btnCarrinho))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarProdutoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAtualizarProdutoActionPerformed
        int busca = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o código do produto que deseja editar:"));
        GerenciamentoProdutos genPro = GerenciamentoProdutos.getInstance();
        genPro.buscarProduto(busca);
        Produto produto = genPro.buscarProduto(busca);
        
        if(produto == null) {
            JOptionPane.showMessageDialog(this, "Produto não encontrado.");
        } else {
            JOptionPane.showMessageDialog(this, "Produto: " + produto.getNome());
            TelaAtualiza tela = new TelaAtualiza(produto);
            tela.setVisible(true);
        }
    }//GEN-LAST:event_btnAtualizarProdutoActionPerformed

    private void btnAdicionarProdutoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoActionPerformed
        AdicionaProduto tela = new AdicionaProduto();
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }//GEN-LAST:event_btnAdicionarProdutoActionPerformed

    private void btnBuscarProdutoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdutoActionPerformed
        int busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código desejado:"));
        GerenciamentoProdutos genProd = GerenciamentoProdutos.getInstance();
        Produto produto = genProd.buscarProduto(busca);
        
        if(produto == null) {
            JOptionPane.showMessageDialog(this, "Produto não encontrado!");
        } else {
            JOptionPane.showMessageDialog(this, "Produto: " + produto.getNome());
        }
    }//GEN-LAST:event_btnBuscarProdutoActionPerformed

    private void btnListarProdutosActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnListarProdutosActionPerformed
        GerenciamentoProdutos genProd = GerenciamentoProdutos.getInstance();
        
        JOptionPane.showMessageDialog(this, genProd.listarProdutos());
    }//GEN-LAST:event_btnListarProdutosActionPerformed

    private void btnExcluirProdutoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnExcluirProdutoActionPerformed
        int busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código desejado:"));
        GerenciamentoProdutos genProd = GerenciamentoProdutos.getInstance();
        Produto produto = genProd.buscarProduto(busca);
        
        if(produto == null) {
            JOptionPane.showMessageDialog(this, "Produto não encontrado!");
        } else {
            genProd.excluirProduto(produto.getCodigo());
            JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
        }
    }//GEN-LAST:event_btnExcluirProdutoActionPerformed

    private void btnCarrinhoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCarrinhoActionPerformed
        int busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código desejado:"));
        GerenciamentoProdutos genProd = GerenciamentoProdutos.getInstance();
        Produto produto = genProd.buscarProduto(busca);
        
        if(produto == null) {
            JOptionPane.showMessageDialog(this, "Produto não encontrado!");
        } else {
            int qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade desejada:"));
            
            if(qtd <= produto.getQuantidade()) {
                genProd.adicionarCarrinho(produto, qtd);
                JOptionPane.showMessageDialog(this, "Produto adicionado ao carrinho.");
            } else {
                JOptionPane.showMessageDialog(this, "Quantidade indisponível.");
            }
        }
    }//GEN-LAST:event_btnCarrinhoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Home().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAdicionarProduto;
    private JButton btnAtualizarProduto;
    private JButton btnBuscarProduto;
    private JButton btnCarrinho;
    private JButton btnExcluirProduto;
    private JButton btnListarProdutos;
    // End of variables declaration//GEN-END:variables
}
