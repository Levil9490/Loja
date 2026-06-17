package org.levilima.view;

import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import org.levilima.control.GerenciamentoProdutos;
import org.levilima.model.Produto;

/**
 *
 * @author levi
 */
public class AdicionaProduto extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdicionaProduto.class.getName());

    public AdicionaProduto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new JLabel();
        txtNome = new JTextField();
        lblDescricao = new JLabel();
        txtDescricao = new JTextField();
        lblPreco = new JLabel();
        txtPreco = new JTextField();
        lblVencimento = new JLabel();
        txtVencimento = new JTextField();
        lblQuantidade = new JLabel();
        txtQuantidade = new JTextField();
        lblCategoria = new JLabel();
        txtCategoria = new JTextField();
        btnAdicionar = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adicionar Produto");
        setResizable(false);

        lblNome.setText("Nome");

        lblDescricao.setText("Descrição");

        lblPreco.setText("Preço");

        lblVencimento.setText("Vencimento");

        lblQuantidade.setText("Quantidade");

        lblCategoria.setText("Categoria");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(this::btnAdicionarActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescricao)
                            .addComponent(lblNome)
                            .addComponent(lblPreco)
                            .addComponent(lblVencimento)
                            .addComponent(lblQuantidade)
                            .addComponent(lblCategoria))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtDescricao, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                            .addComponent(txtPreco, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                            .addComponent(txtVencimento, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                            .addComponent(txtQuantidade, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                            .addComponent(txtCategoria, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdicionar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVencimento)
                    .addComponent(txtVencimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(txtCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdicionar)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        String nome = txtNome.getText();
        String descricao = txtDescricao.getText();
        double preco = Double.parseDouble(txtPreco.getText());
        String vencimento = txtVencimento.getText();
        int quantidade = Integer.parseInt(txtQuantidade.getText());
        String categoria = txtCategoria.getText();
        GerenciamentoProdutos genPro = new GerenciamentoProdutos();
        Produto produto = new Produto(nome, descricao, preco, vencimento, quantidade, categoria);
        
        genPro.adicionarProduto(produto);
    }//GEN-LAST:event_btnAdicionarActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new AdicionaProduto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAdicionar;
    private JLabel lblCategoria;
    private JLabel lblDescricao;
    private JLabel lblNome;
    private JLabel lblPreco;
    private JLabel lblQuantidade;
    private JLabel lblVencimento;
    private JTextField txtCategoria;
    private JTextField txtDescricao;
    private JTextField txtNome;
    private JTextField txtPreco;
    private JTextField txtQuantidade;
    private JTextField txtVencimento;
    // End of variables declaration//GEN-END:variables
}
