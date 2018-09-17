/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;

import editors.usuariosEditor;
import model.Usuario;
import panes.alunosPane;
import panes.usuariosPane;

/**
 *
 * @author Usuario
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        btnCadastros = new javax.swing.JMenu();
        btnAlunosPane = new javax.swing.JMenuItem();
        btnUsuariosPane = new javax.swing.JMenuItem();
        btnSistema = new javax.swing.JMenu();
        btnSobre = new javax.swing.JMenuItem();
        btnSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnCadastros.setText("Cadastros");

        btnAlunosPane.setText("Alunos");
        btnAlunosPane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlunosPaneActionPerformed(evt);
            }
        });
        btnCadastros.add(btnAlunosPane);

        btnUsuariosPane.setText("Usuário");
        btnUsuariosPane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosPaneActionPerformed(evt);
            }
        });
        btnCadastros.add(btnUsuariosPane);

        jMenuBar1.add(btnCadastros);

        btnSistema.setText("Sistema");

        btnSobre.setText("Sobre");
        btnSistema.add(btnSobre);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        btnSistema.add(btnSair);

        jMenuBar1.add(btnSistema);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAlunosPaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlunosPaneActionPerformed
        // TODO add your handling code here:
        alunosPane alunos = new alunosPane();
        alunos.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAlunosPaneActionPerformed

    private void btnUsuariosPaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosPaneActionPerformed
        // TODO add your handling code here:
        usuariosPane usuarios = new usuariosPane();
        usuarios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUsuariosPaneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAlunosPane;
    private javax.swing.JMenu btnCadastros;
    private javax.swing.JMenuItem btnSair;
    private javax.swing.JMenu btnSistema;
    private javax.swing.JMenuItem btnSobre;
    private javax.swing.JMenuItem btnUsuariosPane;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
